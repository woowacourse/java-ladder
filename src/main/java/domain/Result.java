package domain;

import java.util.Map;
import java.util.Map.Entry;
import java.util.stream.Collectors;

public class Result {

    private final Map<String, Integer> result;

    public Result(Map<String, Integer> result) {
        this.result = result;
    }

    public String match(String playerName, Prizes prizes) {
        return prizes.getPrizeNameOf(result.get(playerName));
    }

    public Map<String, String> matchAll(Prizes prizes) {
        return result.entrySet().stream()
                .collect(Collectors.toMap(Entry::getKey, entry -> prizes.getPrizeNameOf(entry.getValue())));
    }

    public boolean isContain(String nameForResult) {
        return result.keySet().stream()
                .anyMatch(name -> name.equals(nameForResult));
    }
}
