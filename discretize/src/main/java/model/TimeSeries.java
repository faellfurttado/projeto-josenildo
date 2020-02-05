package model;

import java.util.List;

public class TimeSeries {
	
	private List<Double> timeSerie;
	
	public TimeSeries(List<Double> timeSerie) {
        this.timeSerie = timeSerie;
    }
	
	public List<Double> getTimeSerie() {
		return this.timeSerie;
	}
	
	public void setTimeSerie(List<Double> timeSerie) {
		this.timeSerie = timeSerie;
	}

	public String discretize(String alphabet1) {
		// TODO Auto-generated method stub
		return null;
	}

}
