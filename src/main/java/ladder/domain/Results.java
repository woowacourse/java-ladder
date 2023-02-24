package ladder.domain;

import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Results {

    private final static String delimiter = " : ";

    private final List<String> products;
    private final Players players;

    public Results(final Players players, final List<String> products) {
        validateLength(players, products);
        this.products = products;
        this.players = players;
    }

    private void validateLength(final Players players, final List<String> products) {
        if (players.size() != products.size()) {
            throw new IllegalArgumentException("참가자와 결과의 개수는 같아야합니다.");
        }
    }

    public Map<String, String> toResultByPlayerName(final String name) {
        if ("all".equals(name)) {
            return createAllResultMessage();
        }

        Player player = players.getPlayerByName(name);
        int position = player.getPosition();
        return Map.of(player.getName(), products.get(position));
    }

    private Map<String, String> createAllResultMessage() {
        Map<String, String> result = new HashMap<>();

        for (Player player : players.toUnmodifiablePlayers()) {
            String name = player.getName();
            String product = products.get(player.getPosition());
            result.put(name, product);
        }

        return result;
    }

    public List<String> toUnmodifiableResults() {
        return Collections.unmodifiableList(products);
    }
}
