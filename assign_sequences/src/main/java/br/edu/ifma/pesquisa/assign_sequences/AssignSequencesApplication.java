package br.edu.ifma.pesquisa.assign_sequences;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@EnableDiscoveryClient
@ComponentScan(basePackages={"br.edu.ifma.pesquisa"})
public class AssignSequencesApplication {

	public static void main(String[] args) {
		SpringApplication.run(AssignSequencesApplication.class, args);
	}

}
