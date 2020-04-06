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
@RequestMapping("/map-discretized-list")
class MapDiscretizedList {
	
    @PostMapping
    public Map<String, Key<String>> mapDiscretizedList(@RequestBody List<String> tsListDiscretized) {
        
    	final Map<String, Key<String>> mapDiscritized = new LinkedHashMap<>();
    	for (int i = 0; i < tsListDiscretized.size(); i++) {
    	     String subStr = tsListDiscretized.get(i);
    	     Key<String> key;
    	     if (mapDiscritized.containsKey(subStr)) {
    	         key = mapDiscritized.get(subStr);
    	     } else {
    	         key = new Key<String>(subStr);
    	     }
    	     key.addOccurences(i);
    	     mapDiscritized.put(subStr, key);
    	}
        return mapDiscritized;
    }
}
