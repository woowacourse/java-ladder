package domain.result;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Result {
    private final Map<String, String> result;

    public Result(List<String> userNames) {
        this.result = new HashMap<>();
        for (String userName : userNames) {
            this.result.put(userName, null);
        }
    }

    public Map<String, String> getResult() {
        return result;
    }

    public void saveResult(String userName, String prizeName) {
        this.result.replace(userName, prizeName);
    }
}
