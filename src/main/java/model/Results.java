package model;

import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

public class Results {
    private final Map<Integer, String> results;

    public Results(List<String> results) {
        this.results = new LinkedHashMap<>();
        for (int i = 0; i < results.size(); i++) {
            this.results.put(i, results.get(i));
        }
    }

    public String getResult(int position) {
        return this.results.get(position);
    }
}
