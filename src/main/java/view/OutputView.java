package view;

import domain.model.Ladder;
import domain.model.Layer;
import domain.model.Name;

import java.util.List;

public class OutputView {

    private static final String RESULT_ANNOUNCEMENT = "실행결과";
    private static final int INTERVAL_UNIT = 6;
    private static final String FRONT_SPACE = "    ";
    private static final String LINE_DELIMITER = "|";
    private static final String CONNECTED_LINE = "-----";
    private static final String UNCONNECTED_LINE = "     ";

    public void printResult(List<Name> names, Ladder ladder) {
        System.out.println(RESULT_ANNOUNCEMENT);
        printNames(names);
        printLadder(ladder);
    }

    private void printLadder(Ladder ladder) {
        for (Layer layer : ladder.getLayers()) {
            printLayer(layer);
        }
    }

    private void printLayer(Layer layer) {
        StringBuilder sb = new StringBuilder();
        sb.append(FRONT_SPACE).append(LINE_DELIMITER);
        List<Boolean> lines = layer.getLines();
        lines.forEach(line -> sb.append(selectLine(line)).append(LINE_DELIMITER));
        System.out.println(sb);
    }

    private String selectLine(boolean line) {
        if (line){
            return CONNECTED_LINE;
        }
        return UNCONNECTED_LINE;
    }

    private void printNames(final List<Name> names) {
        StringBuilder sb = new StringBuilder();
        names.forEach(name -> {
            int difference = INTERVAL_UNIT - name.getName().length();
            sb.append(name.getName()).append(" ".repeat(difference));
        });
        System.out.println(sb);
    }
}
