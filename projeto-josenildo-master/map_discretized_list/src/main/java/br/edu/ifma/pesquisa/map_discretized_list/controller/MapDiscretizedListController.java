package br.edu.ifma.pesquisa.map_discretized_list.controller;

import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.edu.ifma.pesquisa.map_discretized_list.model.Key;

@RestController
@RequestMapping("/map-discretzed-list")
class MapDiscretizedList {

    @PostMapping
    public Map<String, Key> mapDiscretizedList(@RequestBody List<String> tsListDiscretized) {
        final Map<String, Key> mapDiscritized = new LinkedHashMap<>();

        // TODO Implements
        tsListDiscretized.forEach(mapper -> mapDiscritized.put(mapper, new Key()));

        return mapDiscritized;
    }

}