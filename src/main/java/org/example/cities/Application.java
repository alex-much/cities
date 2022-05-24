package org.example.cities;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication//(exclude = DataSourceAutoConfiguration.class)
//@ComponentScan({"org.example","org.example.cities"})
//@EntityScan("org.example.cities")
//@EnableJpaRepositories("org.example.cities.repos")
//@EnableAutoConfiguration

public class Application {
    public static void main(String[] args) {
        SpringApplication.run(Application.class, args);
    }

}