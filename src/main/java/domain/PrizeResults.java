package domain;

import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class PrizeResults {

    private static final String GET_ALL_RESULT_OPERATOR = "all";

    private final Map<Player, Prize> results;

    private PrizeResults(Map<Player, Prize> results) {
        this.results = results;
    }

    public static PrizeResults of(Players players, Prizes prizes, Ladder ladder) {
        Map<Player, Prize> generated = generate(players, prizes, ladder);
        return new PrizeResults(generated);
    }

    private static Map<Player, Prize> generate(Players players, Prizes prizes, Ladder ladder) {
        Map<Player, Prize> results = new LinkedHashMap<>();
        for (int i = 0; i < players.getSize(); i++) {
            results.put(players.get(i), prizes.get(ladder.getDestinationIndex(i)));
        }
        return results;
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
}
