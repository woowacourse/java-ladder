package ladder.view;

import static ladder.view.constant.LadderOutputSymbol.LADDER_VERTICAL_SYMBOL;

import ladder.view.constant.LadderOutputSymbol;

import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class OutputView {

    private static final int LENGTH_OF_ONE_BLOCK = 5;
    private static final String PATTERN_OF_LADDER = "%" + LENGTH_OF_ONE_BLOCK + "s";
    private static final String BLANK_BETWEEN_NAMES = " ";
    private static final String OUTPUT_LADDER_MESSAGE = "사다리 결과";
    private static final String OUTPUT_RESULT_MESSAGE = "실행 결과";
    private static final String ERROR_PREFIX = "[ERROR] ";
    private static final String PATTERN_OF_RESULT = " : ";

    public void printError(final String errorMessage) {
        System.out.println(ERROR_PREFIX + errorMessage);
    }

    public void printLadder(final List<String> playerNames,
                            final List<List<Boolean>> ladder,
                            final List<String> rewardNames) {
        System.out.println(OUTPUT_LADDER_MESSAGE);
        System.out.println(convertAssignedGroupOfLadder(playerNames));
        System.out.println(convertLadderToSymbol(ladder));
        System.out.println(convertAssignedGroupOfLadder(rewardNames));
    }

    private String convertLadderToSymbol(final List<List<Boolean>> ladder) {

        return ladder.stream()
                .map(this::convertLineToSymbol)
                .collect(Collectors.joining(System.lineSeparator()));
    }

    private String convertLineToSymbol(final List<Boolean> line) {
        return line.stream()
                .map(this::convertBarToSymbol)
                .collect(Collectors.joining(LADDER_VERTICAL_SYMBOL.getSymbol(),
                        String.format(PATTERN_OF_LADDER, LADDER_VERTICAL_SYMBOL.getSymbol()),
                        LADDER_VERTICAL_SYMBOL.getSymbol())
                );
    }

    private String convertBarToSymbol(final Boolean isRightConnected) {
        return LadderOutputSymbol.decideLadderSymbol(isRightConnected)
                .repeat(LENGTH_OF_ONE_BLOCK);
    }

    public void printResultOfAll(final Map<String, String> resultOfAll) {
        System.out.println(OUTPUT_RESULT_MESSAGE);

        resultOfAll.forEach((playerName, rewardName) -> {
            final String resultOfPlayer = playerName + PATTERN_OF_RESULT + rewardName;
            System.out.println(resultOfPlayer);
        });
    }

    public void printResultOfPlayer(final String rewardOfPlayer) {
        System.out.println(OUTPUT_RESULT_MESSAGE);
        System.out.println(rewardOfPlayer);
    }

    private String convertAssignedGroupOfLadder(final List<String> assignedGroupOfLadder) {

        return assignedGroupOfLadder.stream()
                .map(name -> String.format(PATTERN_OF_LADDER, name))
                .collect(Collectors.joining(BLANK_BETWEEN_NAMES));
    }

}
