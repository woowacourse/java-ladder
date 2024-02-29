package domain;

import java.util.HashMap;
import java.util.Map;

public class Result {
    private final Map<Name, Winning> results;

    public Result(Map<Name, Winning> results) {
        this.results = results;
    }

    public String getResultByPerson(Name name) {
        return results.get(name).getWinning();
    }

    public Map<String, String> getResultByAll() {
        Map<String, String> resultByAll = new HashMap<>();
        for (Map.Entry<Name, Winning> entry : results.entrySet()) {
            resultByAll.put(entry.getKey().getName(), entry.getValue().getWinning());
        }
        return resultByAll;
    }
}
