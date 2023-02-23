package view;

import domain.model.Ladder;
import domain.model.Layer;
import domain.type.Line;
import domain.vo.Name;
import domain.vo.Result;
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

    public void printLadder(List<Name> names, Ladder ladder, List<Result> results) {
        System.out.println(RESULT_ANNOUNCEMENT);
        printValues(names.stream().map(Name::getValue).collect(Collectors.toList()));
        printLadder(ladder,
            names.stream()
                .map(name -> name.getValue().length())
                .max(Comparator.naturalOrder())
                .orElse(INTERVAL_UNIT));
        printValues(results.stream().map(Result::getValue).collect(Collectors.toList()));
    }

    public void printResult(Result result) {
        System.out.println(RESULT_ANNOUNCEMENT);
        System.out.println(result.getValue());
    }

    public void printAllResult(Map<Name, Result> result) {
        System.out.println(RESULT_ANNOUNCEMENT);
        for (Name name : result.keySet()) {
            System.out.println(name.getValue() + RESULT_DELIMITER + result.get(name).getValue());
        }
    }

    private void printLadder(Ladder ladder, int lineLength) {
        ladder.getLayers()
            .forEach(layer -> printLayer(layer, lineLength));
    }

    private void printLayer(Layer layer, int lineLength) {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append(FRONT_SPACE).append(LINE_DELIMITER);
        List<Line> lines = layer.getLines();
        lines.forEach(
            line -> stringBuilder.append(selectLine(line).repeat(lineLength))
                .append(LINE_DELIMITER));
        System.out.println(stringBuilder);
    }

    private String selectLine(Line line) {
        if (line.equals(Line.CONNECTED)) {
            return CONNECTED_LINE;
        }
        return SPACE;
    }

    private void printValues(final List<String> values) {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("\n");
        values.forEach(value -> {
            int difference = INTERVAL_UNIT - value.length();
            stringBuilder.append(SPACE.repeat(difference)).append(value);
        });
        System.out.println(stringBuilder);
    }
}
