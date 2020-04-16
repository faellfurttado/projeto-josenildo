package br.edu.ifma.pesquisa.assign_sequences.services;

import java.util.AbstractMap;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.junit.jupiter.api.Assertions;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import control.clustering.DTSClusterAssigner;
import model.clusteringtimeseries.Cluster;
import model.patterndiscovery.Pattern;
import util.distances.Distance;
import util.distances.DistanceFactory;
import util.trees.Key;

public class AssignSequencesTest {

	private Logger logger = LoggerFactory.getLogger(AssignSequencesTest.class);

	void a() {
		List<Map.Entry<Pattern<String>, Double>> topEntries = new ArrayList<>();
		topEntries.add(new AbstractMap.SimpleEntry<Pattern<String>, Double>(new Pattern<>("ab"), 0.39 * 6));
		topEntries.add(new AbstractMap.SimpleEntry<Pattern<String>, Double>(new Pattern<>("bb"), 0.39 * 4));
		topEntries.add(new AbstractMap.SimpleEntry<Pattern<String>, Double>(new Pattern<>("cb"), 0.39 * 3));
		topEntries.add(new AbstractMap.SimpleEntry<Pattern<String>, Double>(new Pattern<>("cd"), 0.39 * 5));
		topEntries.add(new AbstractMap.SimpleEntry<Pattern<String>, Double>(new Pattern<>("dd"), 0.39 * 2));
		DTSClusterAssigner<String> clusterAssigner = new DTSClusterAssigner<>();
		Distance d = DistanceFactory.getDistance(DistanceFactory.Distances.MANHATTAN);
		Double radius = 1d;
		Map<String, Key<String>> subSeqs = new HashMap<>();
		int pos = 0;
		for (Map.Entry<Pattern<String>, Double> entry : topEntries) {
			String pattern = entry.getKey().getPoint();
			Double value = entry.getValue();
			int qntOccurences = (int) (value / 0.39);
			Key<String> key = new Key<>(pattern);
			for (int i = 0; i < qntOccurences; i++) {
				key.addOccurence(pos);
				pos += pattern.length();
			}
			subSeqs.put(pattern, key);
		}
		try {
			List<Cluster<String>> clusters = clusterAssigner.assignSequences2(subSeqs, topEntries, d, radius);
			Assertions.assertEquals("ab", clusters.get(0).getCentroid());
			Assertions.assertEquals("cd", clusters.get(1).getCentroid());
			System.out.println(clusters.size());
		} catch (Exception ex) {
			logger.error(ex.getMessage());
			Assertions.fail();
		}
	}

}
