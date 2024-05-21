package com.cleanarch.clean.archtecture.infra.controller;

import com.cleanarch.clean.archtecture.application.usercase.DeleteBbdr;
import com.cleanarch.clean.archtecture.application.usercase.GetAllBbdr;
import com.cleanarch.clean.archtecture.application.usercase.PostBbdr;
import com.cleanarch.clean.archtecture.application.usercase.UpdateBbdr;
import com.cleanarch.clean.archtecture.infra.dto.BbdrPostDto;
import com.cleanarch.clean.archtecture.infra.dto.ResponseBbdrDTO;
import com.cleanarch.clean.archtecture.infra.dto.UpdateBbdrDto;
import com.cleanarch.clean.archtecture.model.entity.Bbdr;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.util.UriComponentsBuilder;

@RestController
@RequestMapping("/bbdr")
public class BbdrController {
    private final PostBbdr postBbdr;
    private final GetAllBbdr getAllBbdr;
    private final UpdateBbdr updateBbdr;
    private final DeleteBbdr deleteBbdr;

    public BbdrController(PostBbdr postBbdr, GetAllBbdr getAllBbdr, UpdateBbdr updateBbdr, DeleteBbdr deleteBbdr) {
        this.postBbdr = postBbdr;
        this.getAllBbdr = getAllBbdr;
        this.updateBbdr = updateBbdr;
        this.deleteBbdr = deleteBbdr;
    }


    @PostMapping
    public ResponseEntity postBbdr(@RequestBody BbdrPostDto dto, UriComponentsBuilder builder){
        Bbdr toPost = new Bbdr(dto);
//        if (toPost.getAge()<18){
//            throw new RuntimeException("Erro controller under age");
//        }
        var posted = postBbdr.postBbdr(toPost);
        var uri = builder.path("/bbdr/{id}").buildAndExpand(posted.getId()).toUri();
        return ResponseEntity.created(uri).body(new ResponseBbdrDTO(posted));
    }

    @GetMapping
    public ResponseEntity<Page<ResponseBbdrDTO>> getAllController(@PageableDefault Pageable pageable){
        var lisfOfBbdr = getAllBbdr.getAll(pageable);
        return ResponseEntity.ok().body(lisfOfBbdr.map(ResponseBbdrDTO::new));
    }

    @PutMapping("/{id}")
    public ResponseEntity updateBbdrController(@PathVariable Long id ,@RequestBody UpdateBbdrDto dto){
        Bbdr updated = updateBbdr.updateBbrd(id, dto);
        return ResponseEntity.ok().body(new ResponseBbdrDTO(updated));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity deleteBbdrController(@PathVariable Long id){
        deleteBbdr.deleteBbrd(id);
        return ResponseEntity.status(HttpStatus.I_AM_A_TEAPOT).body("""
                ⠀⠀⠀⠀⠀⠀⠀⠀⠀⡄⠀⡼⠃⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀
                ⠀⠀⠀⠀⠀⠀⠀⠀⣸⣿⣿⣶⡾⠟⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀
                ⠀⠀⠀⠀⠀⠀⠀⣰⣿⣿⣿⣅⡀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀
                ⠀⠀⠀⠀⣠⣴⣿⡿⠋⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀
                ⠀⣀⣴⣾⣿⡿⠋⠀⣠⣶⣶⠿⠿⠿⠿⠷⢶⣶⣤⣄⠀⠀⠀⠀⠀⠀⠀⠀
                ⢰⣿⣿⣿⣟⠀⠀⢸⣿⣿⣥⣤⣤⣄⣀⣀⣠⣬⣭⣿⠁⠀⠀⠀⠀⠀⠀⠀
                ⠀⠉⠻⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣷⣤⣤⣄⠀⠀⠀⠀
                ⠀⠀⠀⠀⢿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣦⣄⠀
                ⠀⠀⠀⠀⠀⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⡏⠈⠙⠿⣿⣿
                ⠀⠀⠀⠀⠀⢿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⠃⠀⠀⠀⣀⣹
                ⠀⠀⠀⠀⠀⠘⢿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⠏⣀⣤⣶⡿⠿⠟
                ⠀⠀⠀⠀⠀⠀⠈⠻⠿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⠿⠋⠰⣿⠇⠀⠀⠀⠀
                ⠀⠀⠀⠀⠀⠀⠀⣀⣤⣤⡍⠉⠉⠙⠛⠛⠋⣩⣥⣤⣀⠀⠀⠀⠀⠀⠀⠀
                ⠀⠀⠀⠀⠀⠀⠻⢿⡋⠉⠀⠀⠀⠀⠀⠀⠀⠀⠉⣻⡿⠿⠂⠀⠀⠀⠀⠀
                """);
    }
}
