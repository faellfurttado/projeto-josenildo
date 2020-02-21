package br.edu.ifma.pesquisa.discretize.service;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Set;
import java.util.Map.Entry;

import javax.swing.JOptionPane;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.context.SpringBootTest.WebEnvironment;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

@SpringBootTest(webEnvironment = WebEnvironment.RANDOM_PORT)
class DiscretizedControllerTest {

	@Autowired
	private TestRestTemplate restTemplate;
	private DiscretizeForm form;

	@BeforeEach
	public void setup(){
		
		String alfabeto = ""; 
		List<Double> timeSeries = null;
		HashMap<String, List<Double>> linha = findLine(1);
		
		Set<Entry<String, List<Double>>> retornado = linha.entrySet(); 
		for(Entry<String, List<Double>> percorrido : retornado){ 
			alfabeto = percorrido.getKey(); 
			timeSeries = percorrido.getValue(); 
		}	
		
		System.out.println(alfabeto);
		System.out.println(timeSeries);
		
		form = new DiscretizeForm();
		form.setAlphabet(alfabeto);
		form.setTimeSerie(timeSeries);
	}
	
	public HashMap<String, List<Double>> findLine(int linha){
		
		FileReader reader;
		BufferedReader buffer;
		String leitura = new String();
		String alfabeto = "";
		List<Double> timeSeries = null;
		int contador = 0;
		
		try{
			reader = new FileReader("sporulation.txt");
			buffer = new BufferedReader(reader);
			leitura = buffer.readLine();
			  
			while(leitura != null && contador !=linha){
				   leitura= buffer.readLine();
				   contador ++;
			}
		
		}catch(IOException erro){
				JOptionPane.showMessageDialog(null,"Erro de I/O: " + erro ,
					"Erro",JOptionPane.ERROR_MESSAGE);
		}
		
		String[] arrayValores = leitura.split("\\s");
	    for (int i=0; i < arrayValores.length; i++) {
	    	alfabeto = arrayValores[0];
	    	timeSeries = Arrays.asList(Double.parseDouble(arrayValores[1]), 
	    							   Double.parseDouble(arrayValores[2]), 
	    							   Double.parseDouble(arrayValores[3]), 
	    							   Double.parseDouble(arrayValores[4]), 
	    							   Double.parseDouble(arrayValores[5]), 
	    							   Double.parseDouble(arrayValores[6]), 
	    							   Double.parseDouble(arrayValores[7]));
	    }
	    HashMap<String, List<Double>> mapa = new HashMap<String, List<Double>>(); 
	    mapa.put(alfabeto, timeSeries);
	    return mapa;
	}

	@Test
	void shouldBeDiscretize() {
		ResponseEntity<String> response
			= restTemplate.postForEntity("/discretize", form, String.class);

		assertEquals(HttpStatus.OK, response.getStatusCode());
		assertEquals("CYL2A25", response.getBody());   //Linha 1
		//assertEquals("6YL0AC3", response.getBody()); //Linha 2
		//assertEquals("CA0AACA", response.getBody()); //Linha 3
		//assertEquals("cYL7LLL", response.getBody()); //Linha 4
		//assertEquals("CYR1DC1", response.getBody()); //Linha 5
		System.out.println(response.getBody());
	}

	@Test
	void shouldBeFailWhenReceivingTheEmptyAlpahbet() {
		form = new DiscretizeForm();
		form.setAlphabet("");

		ResponseEntity<String> response
			= restTemplate.postForEntity("/discretize", form, String.class);

		assertEquals(HttpStatus.BAD_REQUEST, response.getStatusCode());
		// TODO: Implements assert response body
	}

	@Test
	void shouldBeFailWhenReceivingTheEmptyTimeSerie() {
		form = new DiscretizeForm();
		form.setTimeSerie(null);

		ResponseEntity<String> response
			= restTemplate.postForEntity("/discretize", form, String.class);

		assertEquals(HttpStatus.BAD_REQUEST, response.getStatusCode());
		// TODO: Implements assert response body
	}
}
