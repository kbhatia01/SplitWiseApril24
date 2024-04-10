package org.example.splitwiseaprl;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;

@EnableJpaAuditing
@SpringBootApplication
public class SplitwiseAprlApplication {

    public static void main(String[] args) {
        SpringApplication.run(SplitwiseAprlApplication.class, args);
    }

    // settle up users
    // settle up groups
    // Command line

}
