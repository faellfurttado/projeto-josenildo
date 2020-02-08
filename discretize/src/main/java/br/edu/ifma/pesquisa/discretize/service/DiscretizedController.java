package br.edu.ifma.pesquisa.discretize.service;

import javax.validation.Valid;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import model.patterndiscovery.TimeSeries;

@RestController
@RequestMapping("/discretize")
class DiscretizedController {

	@PostMapping
	public String discretize(@Valid @RequestBody DiscretizeForm form) {
		try {
			TimeSeries ts = new TimeSeries(form.getTimeSerie());
			String discretized = ts.discretize(form.getAlphabet()).toString();

			return discretized;
		} catch (Exception e) {
			e.printStackTrace();
			throw new RuntimeException(e);
		}
	}

}
