package ladder.domain;

import java.util.List;

public class Results {

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

    public String toResultByPlayerName(final String name) {
        Player player = players.getPlayerByName(name);
        int position = player.getPosition();
        return products.get(position);
    }
}
