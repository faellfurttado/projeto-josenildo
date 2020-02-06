package br.edu.ifma.pesquisa.discretize.controller;

import javax.validation.Valid;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.edu.ifma.pesquisa.discretize.model.TimeSeries;

@RestController
@RequestMapping("/discretize")
public class DiscretizedController {

	@PostMapping
	public String discretize(@Valid DiscretizeForm form) {

		// List<Double> timeSerie1 = Arrays.asList(-1.0,0.2,-0.2,-0.6,4.0);
		// String alphabet1 = "abc";
		TimeSeries ts = new TimeSeries(form.getTimeSerie());
		String discretized = ts.discretize(form.getAlphabet());
		// assertEquals("abbac", discretized.toString());
		return discretized;
	}

}
