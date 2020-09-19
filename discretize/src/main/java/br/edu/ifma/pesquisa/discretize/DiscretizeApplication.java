package br.edu.ifma.pesquisa.discretize;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@EnableDiscoveryClient
@ComponentScan(basePackages={"br.edu.ifma.pesquisa.discretize","br.edu.ifma.pesquisa.discretize.service"})
public class DiscretizeApplication {

	public static void main(String[] args) {
		SpringApplication.run(DiscretizeApplication.class, args);
	}

}
