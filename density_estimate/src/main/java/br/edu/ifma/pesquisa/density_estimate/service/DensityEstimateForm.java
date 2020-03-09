package br.edu.ifma.pesquisa.density_estimate.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import model.patterndiscovery.Pattern;

public class DensityEstimateForm {

	private String discret;
	private String alphabet;
	private int s;
	private String dist;
	private double radius;
	private String kernelFunc;
	private double h;
	private final List<Map.Entry<Pattern<String>, Double>> partialDensity = new ArrayList<>();

	public String getDiscret() {
		return discret;
	}

	public void setDiscret(String discret) {
		this.discret = discret;
	}

	public String getAlphabet() {
		return alphabet;
	}

	public void setAlphabet(String alphabet) {
		this.alphabet = alphabet;
	}

	public int getS() {
		return s;
	}

	public void setS(int s) {
		this.s = s;
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

	public String getKernelFunc() {
		return kernelFunc;
	}

	public void setKernelFunc(String kernelFunc) {
		this.kernelFunc = kernelFunc;
	}

	public double getH() {
		return h;
	}

	public void setH(double h) {
		this.h = h;
	}

	public List<Map.Entry<Pattern<String>, Double>> getPartialDensity() {
		return partialDensity;
	}

}
