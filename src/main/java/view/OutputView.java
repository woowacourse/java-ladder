package view;

import domain.model.Ladder;
import domain.model.Layer;
import domain.type.Line;
import domain.vo.Name;
import java.util.Comparator;
import java.util.List;

public class OutputView {

    private static final String RESULT_ANNOUNCEMENT = "\n실행결과";
    private static final int INTERVAL_UNIT = 5;
    private static final String FRONT_SPACE = "    ";
    private static final String LINE_DELIMITER = "|";
    private static final String CONNECTED_LINE = "-";
    private static final String SPACE = " ";

    public void printResult(List<Name> names, Ladder ladder) {
        System.out.println(RESULT_ANNOUNCEMENT);
        printNames(names);
        printLadder(ladder,
            names.stream().map(name -> name.getValue().length()).max(Comparator.naturalOrder())
                .orElse(INTERVAL_UNIT));
    }

    private void printLadder(Ladder ladder, int lineLength) {
        ladder.getLayers().forEach(layer -> printLayer(layer, lineLength));
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

    private void printNames(final List<Name> names) {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("\n");
        names.forEach(name -> {
            int difference = INTERVAL_UNIT - name.getValue().length();
            stringBuilder.append(SPACE.repeat(difference)).append(name.getValue());
        });
        System.out.println(stringBuilder);
    }
}
