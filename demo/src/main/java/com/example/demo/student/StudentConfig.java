package com.example.demo.student;

import java.time.LocalDate;
import java.time.Month;
import java.util.List;

import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class StudentConfig {

	@Bean
	CommandLineRunner runner( StudentRepository repository ) {
		return args -> {
			Student akj = new Student( "Akanksha", LocalDate.of(2000, Month.JANUARY, 15), "akanksha@gmail.com");
			Student ksj = new Student( "Kuldeep", LocalDate.of(1995, Month.NOVEMBER, 02), "akanksha@gmail.com");
			
			repository.saveAll( List.of(akj, ksj));
		};
	};
}
