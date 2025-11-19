package com.example.accessing_data_jpa;

import com.example.accessing_data_jpa.model.Customer;
import com.example.accessing_data_jpa.repository.CustomerRepository;
import com.example.accessing_data_jpa.service.IncidentService;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class AccessingDataJpaApplication {
    private static final Logger log = LoggerFactory.getLogger(AccessingDataJpaApplication.class);
	public static void main(String[] args) {
		SpringApplication.run(AccessingDataJpaApplication.class, args);
	}

    @Bean
    public CommandLineRunner demo(CustomerRepository repository, IncidentService incidentService) {
        return (args) -> {
            // save a few customers
            repository.save(new Customer("Jack", "Bauer", "jb@email.com"));
            repository.save(new Customer("Chloe", "O'Brian", "co@email.com"));
            repository.save(new Customer("Kim", "Bauer", "kb@email.com"));
            repository.save(new Customer("David", "Palmer", "dp@email.com"));
            repository.save(new Customer("Michelle", "Dessler", "md@email.com"));

            incidentService.crearIncidenciaPerCustomer(1L);

            // fetch all customers
            log.info("Customers found with findAll():");
            log.info("-------------------------------");
            repository.findAll().forEach(customer -> {
                log.info(customer.toString());
            });
            log.info("");

            // fetch an individual customer by ID
            Customer customer = repository.findById(1L);
            log.info("Customer found with findById(1L):");
            log.info("--------------------------------");
            log.info(customer.toString());
            log.info("");

            // fetch customers by last name
            log.info("Customer found with findByLastName('Bauer'):");
            log.info("--------------------------------------------");
            repository.findByLastName("Bauer").forEach(bauer -> {
                log.info(bauer.toString());
            });
            log.info("");
        };
    }

}
