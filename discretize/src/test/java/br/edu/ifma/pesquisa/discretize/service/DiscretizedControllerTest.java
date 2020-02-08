package br.edu.ifma.pesquisa.discretize.service;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.Arrays;

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
	public void setup() {
		form = new DiscretizeForm();
		form.setAlphabet("abc");
		form.setTimeSerie(Arrays.asList(-1.0, 0.2, -0.2, -0.6, 4.0));
	}

	@Test
	void shouldBeDiscretize() {
		ResponseEntity<String> response
			= restTemplate.postForEntity("/discretize", form, String.class);

		assertEquals(HttpStatus.OK, response.getStatusCode());
		assertEquals("abbac", response.getBody());
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
