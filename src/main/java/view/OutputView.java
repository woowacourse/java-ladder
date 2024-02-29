package view;

import domain.GameBoard;
import domain.ladder.Ladder;
import domain.reward.PlayerResult;
import domain.reward.Result;
import domain.ladder.attribute.Direction;
import domain.common.Name;

import java.util.EnumMap;
import java.util.List;

public class OutputView {
    private static final EnumMap<Direction, String> directionSymbols = initializedDirectionSymbol();

    private static final String RIGHT_DIRECTION_SYMBOL = "|---";
    private static final String LEFT_DIRECTION_SYMBOL = "---|      ";
    private static final String DOWN_DIRECTION_SYMBOL = "|      ";
    private static final String BLANK_SPACE = "      ";
    private static final int NAME_SPACE_SIZE = 7;
    private static final String NAME_SPACE_UNIT = " ";

    public static void printGameBoard(GameBoard gameBoard) {
        printPlayerNames(gameBoard.getPlayers()
                                  .getPlayerNames());
        printLadder(gameBoard.getLadder(), gameBoard.getLadderHeight());
        printRewards(gameBoard.getRewards()
                              .getResults());
    }


    private static void printPlayerNames(List<Name> playerNames) {
        playerNames.stream()
                   .map(Name::nameToString)
                   .map(OutputView::padString)
                   .forEach(System.out::print);
        printNewLine();
    }

    private static void printLadder(Ladder ladder, int height) {
        for (int index = 0; index < height; index++) {
            OutputView.printDirections(ladder.getDirectionAtHorizontalIndex(index));
        }
    }

    private static void printDirections(List<Direction> directions) {
        StringBuilder resultStringBuilder = new StringBuilder();
        resultStringBuilder.append(BLANK_SPACE);

        directions.forEach(direction -> {
            String symbol = directionSymbols.get(direction);
            resultStringBuilder.append(symbol);
        });

        System.out.println(resultStringBuilder);
    }

    private static EnumMap<Direction, String> initializedDirectionSymbol() {
        final EnumMap<Direction, String> directionSymbols = new EnumMap<>(Direction.class);
        directionSymbols.put(Direction.RIGHT, RIGHT_DIRECTION_SYMBOL);
        directionSymbols.put(Direction.LEFT, LEFT_DIRECTION_SYMBOL);
        directionSymbols.put(Direction.DOWN, DOWN_DIRECTION_SYMBOL);
        return directionSymbols;
    }

    private static void printRewards(List<Result> results) {
        results.stream()
               .map(Result::resultToString)
               .map(OutputView::padString)
               .forEach(System.out::print);
        printNewLine();
    }


    private static String padString(String name) {
        return NAME_SPACE_UNIT.repeat(NAME_SPACE_SIZE - name.length()) + name;
    }


    public static final void printResult(List<PlayerResult> playerResults) {
        playerResults.stream()
                     .forEach(playerResult -> {
                   StringBuilder resultStringBuilder = new StringBuilder();
                   resultStringBuilder.append(playerResult.nameToString())
                                      .append(" : ")
                                      .append(playerResult.rewardToString());
                   System.out.println(resultStringBuilder);
               });
    }

    public static final void printResult(PlayerResult playerResult) {
        System.out.println(playerResult.rewardToString());
    }


    private static void printNewLine() {
        System.out.print(System.lineSeparator());
    }
}
