package br.edu.ifma.pesquisa.assign_sequences.services;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import control.clustering.DTSClusterAssigner;
import model.clusteringtimeseries.Cluster;
import util.distances.Distance;
import util.distances.DistanceFactory;

@RestController
@RequestMapping("/assign-sequences")
public class AssignSequencesService {

	private final Logger logger = LoggerFactory.getLogger(AssignSequencesService.class);
	
	@PostMapping
	public List<Cluster<String>> assignSequences(
			@RequestBody final AssignServicesForm form) {
		final DTSClusterAssigner<String> clusterAssigner = new DTSClusterAssigner<>();
		final Distance distance = DistanceFactory.getDistance(form.getDist());
		try {
			final List<Cluster<String>> clusters =
					clusterAssigner.assignSequences2(form.getSubSeq(),
													 form.getCandidatePatterns(),
													 distance,
													 form.getRadius());
			return clusters;
		} catch (Exception err) {
			logger.error("Message: {}. Cause: {}", err.getMessage(), err.getCause());
			throw new RuntimeException(err);
		}

	}
}
