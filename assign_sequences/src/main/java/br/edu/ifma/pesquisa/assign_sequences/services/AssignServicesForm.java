package br.edu.ifma.pesquisa.assign_sequences.services;

import java.util.List;
import java.util.Map;

import model.patterndiscovery.Pattern;
import util.trees.Key;

public class AssignServicesForm {

	private Map<String, Key<String>> subSeq;
	private List<Map.Entry<Pattern<String>, Double>> candidatePatterns;
	private String dist;
	private double radius;

	public Map<String, Key<String>> getSubSeq() {
		return subSeq;
	}

	public void setSubSeq(Map<String, Key<String>> subSeq) {
		this.subSeq = subSeq;
	}

	public List<Map.Entry<Pattern<String>, Double>> getCandidatePatterns() {
		return candidatePatterns;
	}

	public void setCandidatePatterns(List<Map.Entry<Pattern<String>, Double>> candidatePatterns) {
		this.candidatePatterns = candidatePatterns;
	}

	public String getDist() {
		return dist;
	}

	public void setDist(String dist) {
		this.dist = dist;
	}

	public double getRadius() {
		return radius;
	}

	public void setRadius(double radius) {
		this.radius = radius;
	}

}
