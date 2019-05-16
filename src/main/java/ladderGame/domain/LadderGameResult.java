package ladderGame.domain;

import ladderGame.util.StringUtil;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class LadderGameResult {

    private Map<String, String> resultMap;

    public LadderGameResult(List<String> result, List<User> users) {
        this.resultMap = createResultMap(result, users);
    }

    private Map<String, String> createResultMap(List<String> result, List<User> users) {
        Map<String, String> resultMap = new HashMap<>();

        for (User user : users) {
            resultMap.put(user.getName(), result.get(user.getPosition()));
        }
        return resultMap;
    }

    public String getResultByName(String name) {
        return resultMap.get(name);
    }

    public Map<String, String> getResultMap() {
        return resultMap;
    }

}
