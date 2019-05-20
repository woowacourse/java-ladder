package ladder.domain;

import java.util.HashMap;
import java.util.Map;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class GameResult {
    private static final String ALL_RESULT = "all";
    private static final String DELIMITER = " : ";
    private static final String NEXT_LINE = "\n";

    private Map<Player, Reward> results;

    GameResult() {
        results = new HashMap<>();
    }

    public void addGameResult(Player player, Reward drawResult) {
        results.put(player, drawResult);
    }

    public String getResult(String message) {
        if (message.equals(ALL_RESULT)) {
            return this.toString();
        }
        return getRewardOfPlayerNamed(message);
    }

    private String getRewardOfPlayerNamed(String message) {
        if (!isExistThePlayerNamed(message))
            throw new IllegalArgumentException("해당 이름을 가진 플레이어가 없습니다.");

        Stream<String> matchedResults = results.keySet()
                .stream()
                .filter(player -> player.getName().equals(message))
                .map(player -> results.get(player).getResult());

        return matchedResults.collect(Collectors.joining(" "));
    }

    private boolean isExistThePlayerNamed(String name) {
        return results.keySet()
                .stream().anyMatch(player -> player.getName().equals(name));
    }

    @Override
    public String toString() {
        StringBuilder stringBuilder = new StringBuilder();
        results.keySet().forEach(player -> stringBuilder.append(player.getName())
                .append(DELIMITER)
                .append(results.get(player).getResult())
                .append(NEXT_LINE));
        return stringBuilder.toString();
    }
}