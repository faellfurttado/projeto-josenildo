package br.edu.ifma.pesquisa.density_estimate.service;

import static org.junit.jupiter.api.Assertions.assertNotNull;

import java.util.List;
import java.util.Map.Entry;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.context.SpringBootTest.WebEnvironment;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.http.ResponseEntity;

import model.patterndiscovery.Pattern;
import model.patterndiscovery.StringDensityEstimate;

@SpringBootTest(webEnvironment = WebEnvironment.RANDOM_PORT)
class DensityEstimateControllerTest {

	@Autowired
	private TestRestTemplate restTemplate;
	private DensityEstimateForm form;

	@BeforeEach
	void setup() {
		String discret = "aaabacbbbaabababbabb";
		String alphabet = "abc";
		int s = 2;
		String distance = "Manhattan";
		String kernel = "Gauss";
		Double radius = 1d;
		Double h = 1d;

		form = new DensityEstimateForm();
		form.setDiscret(discret);
		form.setAlphabet(alphabet);
		form.setS(s);
		form.setDist(distance);
		form.setKernelFunc(kernel);
		form.setRadius(radius);
		form.setH(h);
	}

	@Test
	void shouldBeEstimate() throws Exception {
		ResponseEntity<StringDensityEstimate> response = restTemplate
				.postForEntity("/density_estimate", form, StringDensityEstimate.class);

		StringDensityEstimate<Pattern<String>> estimate = (StringDensityEstimate<Pattern<String>>) response.getBody();

		List<Entry<Pattern<String>, Double>> topEntries = estimate.getTopEntries(1);

		assertNotNull(estimate.getTopEntries(1));
		System.out.println(topEntries);
		// assertEquals(1, topEntries.size());
		// assertEquals("ab", topEntries.get(0).getKey().getPoint());
	}

}
