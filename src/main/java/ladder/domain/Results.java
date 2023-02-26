package ladder.domain;

import java.util.HashMap;
import java.util.Map;

public class Results {

    private final static String delimiter = " : ";

    private final Products products;
    private final Players players;

    public Results(final Players players, final Products products) {
        validateLength(players, products);
        this.products = products;
        this.players = players;
    }

    private void validateLength(final Players players, final Products products) {
        if (players.size() != products.size()) {
            throw new IllegalArgumentException("참가자와 결과의 개수는 같아야합니다.");
        }
    }

    public Map<Player, Product> toResultByPlayerName(final String name) {
        if ("all".equals(name)) {
            return createAllResultMessage();
        }

        Player player = players.getPlayerByName(name);
        int position = player.getPosition();
        return Map.of(player, products.get(position));
    }

    private Map<Player, Product> createAllResultMessage() {
        Map<Player, Product> result = new HashMap<>();

        for (Player player : players.toUnmodifiablePlayers()) {
            Product product = products.get(player.getPosition());
            result.put(player, product);
        }

        return result;
    }
}
