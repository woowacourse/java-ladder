package ladder.view;

import ladder.domain.ladder.Direction;
import ladder.domain.ladder.Ladder;
import ladder.domain.ladder.Line;
import ladder.domain.player.Players;
import ladder.domain.reward.Rewards;
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

    public void printLadder(Players players, Ladder ladder, Rewards rewards) {
        System.out.println(OUTPUT_LADDER_MESSAGE);
        System.out.println(convertAssignedGroupOfLadder(players.findPlayerNames()));
        System.out.println(convertLadderToSymbol(ladder));
        System.out.println(convertAssignedGroupOfLadder(rewards.findRewardNames()));
    }

    public void printResultOfAll(Map<String, String> resultOfAll) {
        System.out.println(OUTPUT_RESULT_MESSAGE);
        resultOfAll.forEach((playerName, rewardName) -> {
                    String resultOfPlayer = playerName + PATTERN_OF_RESULT + rewardName;
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

    private String convertBarToSymbol(Direction secondDirection) {
        return LadderOutputSymbol.decideLadderSymbol(secondDirection)
                .repeat(LENGTH_OF_ONE_BLOCK);
    }

}
