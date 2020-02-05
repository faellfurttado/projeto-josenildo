package controller;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.Arrays;
import java.util.List;

import model.TimeSeries;


public class DiscretizedController {
	
	public String discretize(String alphabet, List<Double> timeSerie){
		
		List<Double> timeSerie1 = Arrays.asList(-1.0,0.2,-0.2,-0.6,4.0);
        String alphabet1 = "abc";
        TimeSeries ts = new TimeSeries(timeSerie1);
        String discretized = ts.discretize(alphabet1);
        assertEquals("abbac", discretized.toString());
		return discretized;
	}

}
