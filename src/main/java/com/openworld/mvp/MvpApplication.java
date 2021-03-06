package com.openworld.mvp;

import com.openworld.mvp.bm.router.RouterBE;
import com.openworld.mvp.bm.router.RouterRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;

@EnableWebSecurity
@SpringBootApplication
public class MvpApplication {


    public static void main(String[] args) {
        SpringApplication.run(MvpApplication.class, args);
    }

    @Bean
    CommandLineRunner commandLineRunner(RouterRepository routerRepository) {
        return args -> {

            RouterBE routerBE = new RouterBE();
            routerBE.setMacAddress("00:00:00:00:00:00");

            RouterBE routerBE2 = new RouterBE();
            routerBE2.setMacAddress("00:00:00:00:00:01");
            routerRepository.save(routerBE);
            routerRepository.save(routerBE2);

        };
    }

}
