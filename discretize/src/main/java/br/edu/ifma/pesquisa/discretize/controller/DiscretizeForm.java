package br.edu.ifma.pesquisa.discretize.controller;

import java.util.List;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotEmpty;

public class DiscretizeForm {

	@NotBlank
	private String alphabet;
	@NotEmpty
	private List<Double> timeSerie;

	public String getAlphabet() {
		return alphabet;
	}

	public void setAlphabet(String alphabet) {
		this.alphabet = alphabet;
	}

	public List<Double> getTimeSerie() {
		return timeSerie;
	}

	public void setTimeSerie(List<Double> timeSerie) {
		this.timeSerie = timeSerie;
	}

}
