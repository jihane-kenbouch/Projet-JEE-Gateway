package com.costumer.costumermicroservice;

import com.costumer.costumermicroservice.entities.Customer;
import com.costumer.costumermicroservice.repository.CustomerRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.data.rest.core.config.RepositoryRestConfiguration;

@SpringBootApplication
public class CostumermicroServiceSpringCloudandEurekaRegistryImplementationApplication {

    public static void main(String[] args) {
        SpringApplication.run(CostumermicroServiceSpringCloudandEurekaRegistryImplementationApplication.class, args);
    }
    @Bean
    CommandLineRunner start(CustomerRepository customerRepository, RepositoryRestConfiguration restConfiguration){
        restConfiguration.exposeIdsFor(Customer.class);
        return args -> {
            customerRepository.save(new Customer(null,"jihane","jihane@gmail.com"));
            customerRepository.save(new Customer(null,"med","med@gmail.com"));
            customerRepository.save(new Customer(null,"noor","nouri@gmail.com"));
            customerRepository.findAll().forEach(c->{
                System.out.println(c.toString());
            });

        };
    }
}
