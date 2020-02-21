package br.edu.ifma.pesquisa.map_discretized_list.model;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Key {

    private String point;
    private final List<Integer> occurences = new ArrayList<>();

    public String getPoint() {
        return point;
    }

    public void setPoint(String point) {
        this.point = point;
    }

    public List<Integer> getOccurences() {
        return Collections.unmodifiableList(occurences);
    }

    public void addOccurences(Integer o) {
        this.occurences.add(o);
    }

}
