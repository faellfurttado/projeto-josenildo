package br.edu.ifma.pesquisa.assign_sequences;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@ComponentScan(basePackages={"br.edu.ifma.pesquisa"})
public class AssignSequencesApplication {

	public static void main(String[] args) {
		SpringApplication.run(AssignSequencesApplication.class, args);
	}

}
