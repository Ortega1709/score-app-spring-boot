package com.ortega.scoreappspringboot;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.kafka.core.KafkaTemplate;

@SpringBootApplication
public class ScoreAppSpringBootApplication {

    public static void main(String[] args) {
        SpringApplication.run(ScoreAppSpringBootApplication.class, args);
    }

//    @Bean
//    CommandLineRunner commandLineRunner(KafkaTemplate<String, String> kafkaTemplate) {
//        return args -> {
//          for (int i = 0; i < 10; i++) {
//              kafkaTemplate.send("score-topic", "Barca: " + i + " - " + "Real: " + 0);
//              Thread.sleep(1000);
//          }
//        };
//    }
}
