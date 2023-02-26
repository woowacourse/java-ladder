package ladder.view;

import ladder.domain.Line;
import ladder.domain.Player;
import ladder.domain.Players;
import ladder.domain.Point;
import ladder.domain.Product;
import ladder.domain.Products;

import java.util.List;
import java.util.Map;
import java.util.StringJoiner;
import java.util.stream.Collectors;

public class OutputView {

    private static final int DEFAULT_LADDER_LENGTH = 5;
    private static final String VERTICAL = "|";
    private static final String HORIZON = "-";
    private static final String NONE = " ";

    public void showLadderGame(final Players players, final List<Line> lines, final Products products) {
        System.out.println("사다리 결과");
        printEndLines(getPlayersView(players));
        printLadder(lines);
        printEndLines(getProductsView(products));
    }

    private void printEndLines(final List<String> players) {
        String names = players.stream()
                .map(name -> String.format("%5s", name))
                .collect(Collectors.joining());

        System.out.println(names);
    }

    private List<String> getPlayersView(final Players players) {
        return players.toUnmodifiablePlayers().stream()
                .map(Player::getName)
                .collect(Collectors.toUnmodifiableList());
    }

    private List<String> getProductsView(final Products products) {
        return products.toUnmodifiableProducts().stream()
                .map(Product::getName)
                .collect(Collectors.toUnmodifiableList());
    }

    private void printLadder(final List<Line> lines) {
        lines.stream()
                .map(this::extractLine)
                .forEach(System.out::println);
    }

    private String extractLine(final Line line) {
        List<Point> points = line.toUnmodifiableLine();
        StringJoiner result = new StringJoiner(VERTICAL, NONE.repeat(DEFAULT_LADDER_LENGTH) + VERTICAL, VERTICAL);

        for (Point point : points) {
            String pointFormat = toPointFormat(point, DEFAULT_LADDER_LENGTH);
            result.add(pointFormat);
        }
        return result.toString();
    }

    private String toPointFormat(final Point point, final int size) {
        if (point == Point.AVAILABLE) {
            return HORIZON.repeat(size);
        }
        return NONE.repeat(size);
    }

    public void showResult(final Map<Player, Product> result) {
        for (Player player : result.keySet()) {
            Product product = result.get(player);
            System.out.println(player.getName() + " : " + product.getName());
        }
    }
}
