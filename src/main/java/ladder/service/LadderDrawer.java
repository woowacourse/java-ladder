package ladder.service;

import java.util.stream.Collectors;

import ladder.domain.FootBars;
import ladder.domain.Ladder;
import ladder.domain.LadderFormat;
import ladder.domain.Names;
import ladder.domain.Results;

public class LadderDrawer {
    private static final int WIDTH = 5;
    private static final String LEG = "|";
    private static final String BLANK = " ";
    private static final String NAME_FORMAT = "%5s";
    private static final String RESULT_FORMAT = "%5s";
    private static final String LINE_SEPARATOR = System.lineSeparator();
    private final StringBuilder stringBuilder;

    public LadderDrawer() {
        this.stringBuilder = new StringBuilder();
    }

    public String draw(Names names, Ladder ladder, Results results) {
        writeNames(names);
        drawLadder(ladder);
        writeResults(results);
        return stringBuilder.toString();
    }

    private void writeNames(Names names) {
        String nameRow = names.getNames()
            .stream()
            .map(name -> String.format(NAME_FORMAT, name.getName()) + BLANK)
            .collect(Collectors.joining());
        append(nameRow);
        append(LINE_SEPARATOR);
    }

    private void drawLadder(Ladder ladder) {
        ladder.getLadder().forEach(footBars -> {
            String result = " ".repeat(WIDTH - 1);
            result += shapeOf(footBars);
            result += LEG;

            append(result);
            append(LINE_SEPARATOR);
        });
    }

    private String shapeOf(FootBars footBars) {
        return footBars.getFootBars()
            .stream()
            .map(LadderFormat::getComponent)
            .map(component -> LEG + component.repeat(WIDTH))
            .collect(Collectors.joining());
    }

    private void writeResults(Results results) {
        String resultsRow = results.getResults().stream()
            .map(result -> String.format(RESULT_FORMAT, result.getResult()) + BLANK)
            .collect(Collectors.joining());
        append(resultsRow);
        append(LINE_SEPARATOR);
    }

    private void append(String str) {
        stringBuilder.append(str);
    }
}
