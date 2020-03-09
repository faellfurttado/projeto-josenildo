package br.edu.ifma.pesquisa.density_estimate.service;

import javax.validation.Valid;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import control.patterndiscovery.TimeSeriesEstimator_JumpingWindow;
import model.patterndiscovery.Pattern;
import model.patterndiscovery.StringDensityEstimate;
import util.distances.Distance;
import util.distances.DistanceFactory;
import util.kernels.Kernel;
import util.kernels.KernelFunctionFactory;

@RestController
@RequestMapping("/density_estimate")
class DensityEstimateController {

	@PostMapping
	public StringDensityEstimate<Pattern<String>> densityEstimate(@Valid @RequestBody DensityEstimateForm form) throws Exception {
		Distance distanceInstance = DistanceFactory.getDistance(form.getDiscret());

		Kernel kernel = KernelFunctionFactory.getKernel(form.getKernelFunc());

		TimeSeriesEstimator_JumpingWindow timeSeriesEstimator = new TimeSeriesEstimator_JumpingWindow();

		return timeSeriesEstimator
				.estimateWithConcreteSequences(
						form.getDiscret(),
						form.getAlphabet(),
						form.getS(),
						distanceInstance,
						form.getRadius(),
						kernel,
						form.getH(),
						form.getPartialDensity()
		);
	}

}
