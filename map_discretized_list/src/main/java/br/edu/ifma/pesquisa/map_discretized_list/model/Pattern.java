package br.edu.ifma.pesquisa.map_discretized_list.model;

import java.util.Collections;
import java.util.List;

public class Pattern {
    
	private String point;
    private List<Key> sequences;
    
    public String getPoint() {
        return point;
    }

    public void setPoint(String point) {
        this.point = point;
    }

    public List<Key> getSequences() {
        return Collections.unmodifiableList(sequences);
    }

    public void addSequences(Key o) {
        this.sequences.add(o);
    }
}