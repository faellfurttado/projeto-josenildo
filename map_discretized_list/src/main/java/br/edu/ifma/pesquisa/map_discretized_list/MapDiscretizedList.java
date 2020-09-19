package br.edu.ifma.pesquisa.map_discretized_list;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

@SpringBootApplication
@EnableDiscoveryClient
class MapDiscretizedList {

	public static void main(String[] args) {
		SpringApplication.run(MapDiscretizedList.class, args);
	}

}
