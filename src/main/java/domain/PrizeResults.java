package domain;

import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class PrizeResults {

    public static final String GET_ALL_RESULT_OPERATOR = "all";

    private final Map<Player, Prize> results;

    public PrizeResults(Map<Player, Prize> results) {
        this.results = results;
    }

    public Map<Player, Prize> getByOperator(String operator) {
        validateOperate(operator);
        if (operator.equals(GET_ALL_RESULT_OPERATOR)) {
            return results;
        }
        return getPlayerResult(operator);
    }

    private void validateOperate(String op) {
        List<String> PlayerNames = results.keySet().stream().map(Player::getName).toList();
        if (!GET_ALL_RESULT_OPERATOR.equals(op) && !PlayerNames.contains(op)) {
            throw new IllegalArgumentException(String.format("보고 싶은 결과는 all 또는 사용자 이름으로 입력해주세요. 입력 : %s", op));
        }
    }

    private Map<Player, Prize> getPlayerResult(String op) {
        return results.entrySet().stream()
                .filter(entry -> entry.getKey().getName().equals(op))
                .collect(Collectors.toMap(Map.Entry::getKey, Map.Entry::getValue));
    }

    public Map<String, String> convertResultToData(Map<Player, Prize> result) {
        Map<String, String> resultsInformation = new LinkedHashMap<>();
        for (Player key : result.keySet()) {
            resultsInformation.put(key.getName(), result.get(key).getName());
        }
        return resultsInformation;
    }
}
