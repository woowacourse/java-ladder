package view;

import domain.model.Ladder;
import domain.model.Layer;
import dto.ViewResultParameter;

import java.util.List;

public class OutputView {

    private static final int INTERVAL_UNIT = 6;
    private static final String RESULT_ANNOUNCEMENT = "\n실행결과";
    private static final String FRONT_SPACE = "    ";
    private static final String LINE_DELIMITER = "|";
    private static final String CONNECTED_LINE = "-----";
    private static final String UNCONNECTED_LINE = "     ";
    private static final String NAME_SPACE = " ";
    private static final String GAME_RESULT_MESSAGE = "\n실행 결과";

    public void printLadder(final List<String> names, final Ladder ladder, final List<String> results) {
        System.out.println(RESULT_ANNOUNCEMENT);
        printNames(names);
        printLadder(ladder);
        printResult(results);
    }

    private void printResult(final List<String> results) {
        StringBuilder stringBuilder = new StringBuilder();
        for (String result : results) {
            stringBuilder.append(NAME_SPACE.repeat(4));
            stringBuilder.append(result);
        }
        System.out.println(stringBuilder);
    }

    private void printNames(final List<String> names) {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("\n");
        names.forEach(name -> {
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

    public void printGameResult(final ViewResultParameter viewResultParameter) {
        if (viewResultParameter.getViewResult().isEmpty()) {
            return;
        }
        System.out.println(GAME_RESULT_MESSAGE);
        for (int i = 0; i < viewResultParameter.getViewers().size(); i++) {
            System.out.println(viewResultParameter.getViewers().get(i) + " : " + viewResultParameter.getViewResult().get(i));
        }
    }

    public void printError(IllegalArgumentException e) {
        e.printStackTrace();
    }
}
