package view;

import domain.model.Ladder;
import domain.model.Layer;
import domain.vo.Names;
import domain.vo.Results;

import java.util.List;

public class OutputView {

    private static final int INTERVAL_UNIT = 6;
    private static final String RESULT_ANNOUNCEMENT = "\n실행결과";
    private static final String FRONT_SPACE = "    ";
    private static final String LINE_DELIMITER = "|";
    private static final String CONNECTED_LINE = "-----";
    private static final String UNCONNECTED_LINE = "     ";
    private static final String NAME_SPACE = " ";

    public void printLadder(final Names names, final Ladder ladder, final Results results) {
        System.out.println(RESULT_ANNOUNCEMENT);
        printNames(names);
        printLadder(ladder);
        printResult(results);
    }

    private void printResult(final Results results) {
        StringBuilder stringBuilder = new StringBuilder();
        for (String result : results.mapToStrings()) {
            stringBuilder.append(NAME_SPACE.repeat(4));
            stringBuilder.append(result);
        }
        System.out.println(stringBuilder);
    }

    private void printNames(final Names names) {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("\n");
        names.mapToString().forEach(name -> {
            int difference = INTERVAL_UNIT - name.length();
            stringBuilder.append(name).append(NAME_SPACE.repeat(difference));
        });
        System.out.println(stringBuilder);
    }

    private void printLadder(final Ladder ladder) {
        for (Layer layer : ladder.getLayers()) {
            printLayer(layer);
        }
    }

    private void printLayer(final Layer layer) {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append(FRONT_SPACE).append(LINE_DELIMITER);
        List<Boolean> lines = layer.getLines();
        lines.forEach(line -> stringBuilder.append(selectLine(line)).append(LINE_DELIMITER));
        System.out.println(stringBuilder);
    }

    private String selectLine(final boolean line) {
        if (line) {
            return CONNECTED_LINE;
        }
        return UNCONNECTED_LINE;
    }

    public void printGameResult(final Names viewers, final Results viewResult) {
        for (int i = 0; i < viewers.size(); i++) {
            System.out.println(viewers.get(i).getValue() + " : " + viewResult.get(i).getValue());
        }
    }
}
