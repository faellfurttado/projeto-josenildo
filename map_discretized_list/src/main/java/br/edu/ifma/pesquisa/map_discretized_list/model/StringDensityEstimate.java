package br.edu.ifma.pesquisa.map_discretized_list.model;

import java.util.Map;

public class StringDensityEstimate<T> {
    
	private Map<T, Double> densityEstimate = null;

	public Map<T, Double> getDensityEstimate() {
		return densityEstimate;
	}

	public void setDensityEstimate(Map<T, Double> densityEstimate) {
		this.densityEstimate = densityEstimate;
	}
}
