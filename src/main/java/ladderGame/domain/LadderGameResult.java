package ladderGame.domain;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class LadderGameResult {
    private final Map<String, String> resultMap;

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
        if (name.equals("all")) {
            return getResultAll();
        }

        return resultMap.get(name);
    }

    private String getResultAll() {
        StringBuffer buffer = new StringBuffer();

        for(String key : resultMap.keySet()){
            String value = resultMap.get(key);
            buffer.append(key).append(":").append(value).append("\n");
        }
        return buffer.toString();
    }

    public Map<String, String> getResultMap() {
        return resultMap;
    }

}
