package ladder.view;

import ladder.domain.*;
import ladder.view.constant.LadderOutputSymbol;

import java.util.List;
import java.util.stream.Collectors;

import static ladder.view.constant.LadderOutputSymbol.LADDER_VERTICAL_SYMBOL;

public class ResultView {

    private static final String BLANK_BETWEEN_NAMES = " ";
    private static final String OUTPUT_RESULT_MESSAGE = "실행결과";
    private static final String ERROR_PREFIX = "[ERROR] ";
    private static final String OUTPUT_PATTERN = "%" + Name.NAME_MAXIMUM_LENGTH + "s";

    public void printError(String errorMessage) {
        System.out.println(ERROR_PREFIX + errorMessage);
    }

    public void printLadder(Players players, Ladder ladder) {
        System.out.println(OUTPUT_RESULT_MESSAGE);
        System.out.println(convertPlayerNames(players));
        System.out.println(convertLadderSymbol(ladder));
    }

    private String convertPlayerNames(Players players) {
        return players.getNames().stream()
                .map(name -> String.format(OUTPUT_PATTERN, name))
                .collect(Collectors.joining(BLANK_BETWEEN_NAMES));
    }

    private String convertLadderSymbol(Ladder ladder) {
        return ladder.getLadder().stream()
                .map(this::convertLineSymbol)
                .collect(Collectors.joining(System.lineSeparator()));
    }

    private String convertLineSymbol(Line line) {
        return line.getLine().stream()
                .map(this::convertBarSymbol)
                .collect(Collectors.joining(
                        LADDER_VERTICAL_SYMBOL.getSymbol(),
                        String.format(OUTPUT_PATTERN, LADDER_VERTICAL_SYMBOL.getSymbol()),
                        LADDER_VERTICAL_SYMBOL.getSymbol()
                ));
    }

    private String convertBarSymbol(Bar bar) {
        return LadderOutputSymbol
                .decideLadderSymbol(bar.getValue())
                .repeat(Name.NAME_MAXIMUM_LENGTH);
    }

}
