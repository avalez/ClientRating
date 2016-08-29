package com.oracle.msa.sample.clientrating.blacklistservice;

import java.util.Arrays;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.context.web.SpringBootServletInitializer;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class Application extends SpringBootServletInitializer {
    public static void main(String[] args) {
        new SpringApplicationBuilder(Application.class)
                .initializers(new SpringApplicationContextInitializer())
                .application()
                .run(args);
    }

    // FIXME: development profile only
	@Bean
	CommandLineRunner init(CustomerRepository customerRepository) {
		return (args) -> Arrays.asList(
				"2,3,5,7,11,13".split(","))
				.forEach(
						id -> {
							Customer customer = customerRepository.save(
									new Customer(Integer.valueOf(id),
											Customer.Status.BLACKLISTED));
						});
	}


}