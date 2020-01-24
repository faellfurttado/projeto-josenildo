package br.edu.ifma.pesquisa.map_discretized_list.model;

import java.io.Serializable;

public class Cluster implements Serializable {
    
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private String centroid;
    private Double centroidDensity;
    
    public String getCentroid() {
        return centroid;
    }

    public void setCentroid(String centroid) {
        this.centroid = centroid;
    }

    public Double getCentroidDensity() {
        return centroidDensity;
    }

    public void setCentroidDensity(Double centroidDensity) {
        this.centroidDensity = centroidDensity;
    }   
}