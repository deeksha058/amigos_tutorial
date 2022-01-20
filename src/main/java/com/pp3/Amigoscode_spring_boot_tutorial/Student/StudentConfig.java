package com.pp3.Amigoscode_spring_boot_tutorial.Student;

import org.springframework.beans.factory.annotation.Configurable;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.time.LocalDate;
import java.time.Month;
import java.util.List;

import static java.time.Month.JANUARY;

@Configuration
public class StudentConfig {

    @Bean
    CommandLineRunner commandLineRunner(
            StudentRepository repository) {
        return args -> {
            Student jindal = new Student(
                    1l,
                    "jindal",
                    "jindal@helloworld.com",
                    LocalDate.of(2000, JANUARY, 5)
            );

            Student amigo = new Student(
                    2l,
                    "amigo",
                    "amigo@byeworld.com",
                    LocalDate.of(2004, JANUARY, 5)

            );

            repository.saveAll(
                    List.of(jindal,amigo)
            );
        };
    }
}
