package ladder.domain;

import java.util.Collections;
import java.util.List;
import java.util.StringJoiner;

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

    public String toResultByPlayerName(final String name) {
        if ("all".equals(name)) {
            return createAllResultMessage();
        }

        Player player = players.getPlayerByName(name);
        int position = player.getPosition();
        return products.get(position);
    }

    private String createAllResultMessage() {
        StringBuilder builder = new StringBuilder();
        StringJoiner joiner = new StringJoiner(delimiter);

        for (Player player : players.toUnmodifiablePlayers()) {
            String name = player.getName();
            String product = products.get(player.getPosition());
            String join = String.join(delimiter, name, product);
            builder.append(join + "\n");
        }

        return builder.toString();
    }

    public List<String> toUnmodifiableResults() {
        return Collections.unmodifiableList(products);
    }
}
