package ladder.view;

import ladder.domain.Bar;
import ladder.domain.Ladder;
import ladder.domain.Line;
import ladder.view.constant.LadderOutputSymbol;

import java.util.List;
import java.util.stream.Collectors;

import static ladder.view.constant.LadderOutputSymbol.LADDER_VERTICAL_SYMBOL;

public class ResultView {

    private static final String BLANK_BETWEEN_NAMES = " ";
    private static final String OUTPUT_RESULT_MESSAGE = "실행결과";
    private static final String ERROR_PREFIX = "[ERROR] ";

    public void printError(String errorMessage) {
        System.out.println(ERROR_PREFIX + errorMessage);
    }

    public void printLadder(List<String> playerNames, Ladder ladder, int nameLength) {
        System.out.println(OUTPUT_RESULT_MESSAGE);
        System.out.println(convertPlayerNames(playerNames, nameLength));
        System.out.println(convertLadderToSymbol(ladder, nameLength));
    }

    private String convertPlayerNames(List<String> playerNames, int nameLength) {
        String ladderFramePattern = "%" + nameLength + "s";

        return playerNames.stream()
                .map(name -> String.format(ladderFramePattern, name))
                .collect(Collectors.joining(BLANK_BETWEEN_NAMES));
    }

    private String convertLadderToSymbol(Ladder ladder, int nameLength) {
        return ladder.getLinesOfLadder().stream()
                .map(line -> convertLineToSymbol(line, nameLength))
                .collect(Collectors.joining(System.lineSeparator()));
    }

    private String convertLineToSymbol(Line line, int nameLength) {
        String ladderRungPattern = "%" + nameLength + "s";

        return line.getLine().stream()
                .map(connection -> convertBarToSymbol(connection, nameLength))
                .collect(Collectors.joining(LADDER_VERTICAL_SYMBOL.getSymbol(),
                        String.format(ladderRungPattern, LADDER_VERTICAL_SYMBOL.getSymbol()),
                        LADDER_VERTICAL_SYMBOL.getSymbol())
                );
    }

    private String convertBarToSymbol(Bar bar, int nameLength) {
        return LadderOutputSymbol.decideLadderSymbol(bar).repeat(nameLength);
    }

}
