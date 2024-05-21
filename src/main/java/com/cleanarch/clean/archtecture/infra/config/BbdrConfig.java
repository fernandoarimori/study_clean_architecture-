package com.cleanarch.clean.archtecture.infra.config;

import com.cleanarch.clean.archtecture.application.usercase.DeleteBbdr;
import com.cleanarch.clean.archtecture.application.usercase.GetAllBbdr;
import com.cleanarch.clean.archtecture.application.usercase.PostBbdr;
import com.cleanarch.clean.archtecture.application.usercase.UpdateBbdr;
import com.cleanarch.clean.archtecture.infra.gateway.TransferRepository;
import com.cleanarch.clean.archtecture.infra.persistense.BbdrMapper;
import com.cleanarch.clean.archtecture.infra.persistense.JpaOriginalRepository;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class BbdrConfig {
    @Bean
    public PostBbdr postBbdrConfigBean(TransferRepository repository) {
        return new PostBbdr(repository);
    }

    @Bean
    public UpdateBbdr updateBbdr(JpaOriginalRepository repository, BbdrMapper mapper){
        return new UpdateBbdr(repository, mapper);
    }

    @Bean
    public DeleteBbdr deleteBbdrConfig(TransferRepository repository){
        return new DeleteBbdr(repository);
    }

    @Bean
    public BbdrMapper bbdrMapperConfig() {
        return new BbdrMapper();
    }

    @Bean
    public TransferRepository transferRepositoryConfig(JpaOriginalRepository repository, BbdrMapper bbdrMapper){
        return new TransferRepository(repository, bbdrMapper);
    }

    @Bean
    public GetAllBbdr getAllBbdr(TransferRepository repository){
        return new GetAllBbdr(repository);
    }
}
