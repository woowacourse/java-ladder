package view;

import domain.model.Ladder;
import domain.model.Layer;
import domain.model.Player;
import domain.model.Players;
import domain.model.Result;
import domain.model.Results;
import domain.type.Line;
import java.util.Comparator;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class OutputView {

    private static final String RESULT_ANNOUNCEMENT = "\n실행결과";
    private static final int INTERVAL_UNIT = 6;
    private static final String FRONT_SPACE = "    ";
    private static final String LINE_DELIMITER = "|";
    private static final String CONNECTED_LINE = "-";
    private static final String SPACE = " ";
    public static final String RESULT_DELIMITER = " : ";

    public void printLadder(final Players players, final Ladder ladder, final Results results) {
        System.out.println(RESULT_ANNOUNCEMENT);
        printValues(
            players.getPlayers().stream().map(Player::getName).collect(Collectors.toList()));
        printLadder(ladder,
            players.getPlayers().stream()
                .map(name -> name.getName().length())
                .max(Comparator.naturalOrder())
                .orElse(INTERVAL_UNIT));
        printValues(
            results.getResults().stream().map(Result::getValue).collect(Collectors.toList()));
    }

    public void printResult(final Result result) {
        System.out.println(RESULT_ANNOUNCEMENT);
        System.out.println(result.getValue());
    }

    public void printAllResult(final Map<Player, Result> result) {
        System.out.println(RESULT_ANNOUNCEMENT);
        for (Player player : result.keySet()) {
            System.out.println(player.getName() + RESULT_DELIMITER + result.get(player).getValue());
        }
    }

    private void printLadder(final Ladder ladder, final int lineLength) {
        ladder.getLayers()
            .forEach(layer -> printLayer(layer, lineLength));
    }

    private void printLayer(final Layer layer, final int lineLength) {
        final StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append(FRONT_SPACE).append(LINE_DELIMITER);
        final List<Line> lines = layer.getLines();
        lines.forEach(
            line -> stringBuilder.append(selectLine(line).repeat(lineLength))
                .append(LINE_DELIMITER));
        System.out.println(stringBuilder);
    }

    private String selectLine(final Line line) {
        if (line.equals(Line.CONNECTED)) {
            return CONNECTED_LINE;
        }
        return SPACE;
    }

    private void printValues(final List<String> values) {
        final StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("\n");
        values.forEach(value -> {
            int difference = INTERVAL_UNIT - value.length();
            stringBuilder.append(SPACE.repeat(difference)).append(value);
        });
        System.out.println(stringBuilder);
    }
}
