package view;

import domain.model.Ladder;
import domain.model.Layer;
import domain.type.Line;
import domain.vo.Name;
import java.util.List;

public class OutputView {

    private static final String RESULT_ANNOUNCEMENT = "\n실행결과";
    private static final int INTERVAL_UNIT = 6;
    private static final String FRONT_SPACE = "    ";
    private static final String LINE_DELIMITER = "|";
    private static final String CONNECTED_LINE = "-----";
    private static final String UNCONNECTED_LINE = "     ";
    private static final String NAME_SPACE = " ";

    public void printResult(List<Name> names, Ladder ladder) {
        System.out.println(RESULT_ANNOUNCEMENT);
        printNames(names);
        printLadder(ladder);
    }

    private void printLadder(Ladder ladder) {
        ladder.getLayers().forEach(this::printLayer);
    }

    private void printLayer(Layer layer) {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append(FRONT_SPACE).append(LINE_DELIMITER);
        List<Line> lines = layer.getLines();
        lines.forEach(
            line -> stringBuilder.append(selectLine(line)).append(LINE_DELIMITER));
        System.out.println(stringBuilder);
    }

    private String selectLine(Line line) {
        if (line.equals(Line.CONNECTED)) {
            return CONNECTED_LINE;
        }
        return UNCONNECTED_LINE;
    }

    private void printNames(final List<Name> names) {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("\n");
        names.forEach(name -> {
            int difference = INTERVAL_UNIT - name.get().length();
            stringBuilder.append(name.get()).append(NAME_SPACE.repeat(difference));
        });
        System.out.println(stringBuilder);
    }
}
