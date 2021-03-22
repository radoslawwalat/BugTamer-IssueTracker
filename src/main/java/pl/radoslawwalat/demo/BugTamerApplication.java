package pl.radoslawwalat.demo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;


@SpringBootApplication
public class BugTamerApplication {

    public static void main(String[] args) {
        SpringApplication.run(BugTamerApplication.class, args);
    }

}
