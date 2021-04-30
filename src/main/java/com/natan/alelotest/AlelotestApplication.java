package com.natan.alelotest;

import com.natan.alelotest.model.Vehicle;
import com.natan.alelotest.repository.VehicleRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import java.util.stream.LongStream;

@SpringBootApplication
public class AlelotestApplication {

    public static void main(String[] args) {
        SpringApplication.run(AlelotestApplication.class, args);
    }

    @Bean
    CommandLineRunner init(VehicleRepository repository) {
        return args -> {
            repository.deleteAll();
            LongStream.range(1, 11)
                    .mapToObj(i -> new Vehicle(i, "plate" + i, "model" + i, "manufacturer" + i, "color" + i, true))
                    .map(repository::save)
                    .forEach(System.out::println);
        };
    }
}
