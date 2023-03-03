package domain.result;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Result {
    private final Map<String, String> results;

    public Result(List<String> userNames) {
        this.results = new HashMap<>();
        for (String userName : userNames) {
            this.results.put(userName, null);
        }
    }

    public Map<String, String> getResults() {
        return results;
    }

    public void saveResult(String userName, String prizeName) {
        this.results.replace(userName, prizeName);
    }

    public String findOneResult(String searchName) {
        return results.get(searchName);
    }

    public List<String> findAllResults() {
        List<String> results = new ArrayList<>();
        for (String searchName : this.results.keySet()) {
            results.add(this.results.get(searchName));
        }
        return results;
    }
}
