package de.gabriel.mcdonaldsproject;

import de.gabriel.mcdonaldsproject.order.OrderRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class McDonaldsProjectApplication {

    public static void main(String[] args) {
        SpringApplication.run(McDonaldsProjectApplication.class, args);
    }

    @Bean
    CommandLineRunner commandLineRunner(OrderRepository orderRepository) {
        return args -> {
            
        };
    }

}
