package ladder.view;

import ladder.domain.Bar;
import ladder.domain.Ladder;
import ladder.domain.Line;
import ladder.domain.Rewards;
import ladder.view.constant.LadderOutputSymbol;

import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import static ladder.view.constant.LadderOutputSymbol.LADDER_VERTICAL_SYMBOL;

public class OutputView {

    private static final int LENGTH_OF_ONE_BLOCK = 5;
    private static final String PATTERN_OF_LADDER = "%" + LENGTH_OF_ONE_BLOCK + "s";
    private static final String BLANK_BETWEEN_NAMES = " ";
    private static final String OUTPUT_LADDER_MESSAGE = "사다리 결과";
    private static final String OUTPUT_RESULT_MESSAGE = "실행 결과";
    private static final String ERROR_PREFIX = "[ERROR] ";
    private static final String PATTERN_OF_RESULT = " : ";

    public void printError(String errorMessage) {
        System.out.println(ERROR_PREFIX + errorMessage);
    }

    public void printLadder(List<String> playerNames, Ladder ladder, Rewards rewards) {
        System.out.println(OUTPUT_LADDER_MESSAGE);
        System.out.println(convertAssignedGroupOfLadder(playerNames));
        System.out.println(convertLadderToSymbol(ladder));
        System.out.println(convertAssignedGroupOfLadder(rewards.findRewards()));
    }

    public void printResultOfAll(List<String> playerNames, Map<String, String> resultOfAll) {
        System.out.println(OUTPUT_RESULT_MESSAGE);
        playerNames
                .forEach(playerName -> {
                    String resultOfPlayer = playerName + PATTERN_OF_RESULT + resultOfAll.get(playerName);
                    System.out.println(resultOfPlayer);
                });
    }

    public void printResultOfPlayer(String rewardOfPlayer) {
        System.out.println(OUTPUT_RESULT_MESSAGE);
        System.out.println(rewardOfPlayer);
    }

    private String convertAssignedGroupOfLadder(List<String> assignedGroupOfLadder) {

        return assignedGroupOfLadder.stream()
                .map(name -> String.format(PATTERN_OF_LADDER, name))
                .collect(Collectors.joining(BLANK_BETWEEN_NAMES));
    }

    private String convertLadderToSymbol(Ladder ladder) {

        return ladder.getLinesOfLadder().stream()
                .map(this::convertLineToSymbol)
                .collect(Collectors.joining(System.lineSeparator()));
    }

    private String convertLineToSymbol(Line line) {
        return line.getLine().stream()
                .map(this::convertBarToSymbol)
                .collect(Collectors.joining(LADDER_VERTICAL_SYMBOL.getSymbol(),
                        String.format(PATTERN_OF_LADDER, LADDER_VERTICAL_SYMBOL.getSymbol()),
                        LADDER_VERTICAL_SYMBOL.getSymbol())
                );
    }

    private String convertBarToSymbol(Bar bar) {
        return LadderOutputSymbol.decideLadderSymbol(bar)
                .repeat(LENGTH_OF_ONE_BLOCK);
    }

}
