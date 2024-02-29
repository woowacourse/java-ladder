package view;

import domain.reward.Result;
import domain.reward.Reward;
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

    public static void printPlayerNames(List<Name> playerNames) {
        playerNames.stream()
                   .map(Name::getValue)
                   .map(OutputView::padString)
                   .forEach(System.out::print);
        printNewLine();
    }

    public static void printDirections(List<Direction> directions) {

        StringBuilder resultStringBuilder = new StringBuilder();
        resultStringBuilder.append(BLANK_SPACE);

        directions.forEach(direction -> {
            String symbol = directionSymbols.get(direction);
            resultStringBuilder.append(symbol);
        });

        System.out.println(resultStringBuilder);
    }

    public static void printRewards(List<Reward> rewards) {
        rewards.stream()
               .map(Reward::getValue)
               .map(OutputView::padString)
               .forEach(System.out::print);
        printNewLine();
    }

    public static final void printResult(List<Result> results) {
        results.stream()
               .forEach(result -> {
                   StringBuilder resultStringBuilder = new StringBuilder();
                   resultStringBuilder.append(result.nameToString())
                                      .append(" : ")
                                      .append(result.rewardToString());
                   System.out.println(resultStringBuilder);
               });
    }

    public static final void printResult(Result result) {
        System.out.println(result.rewardToString());
    }

    private static String padString(String name) {
        return NAME_SPACE_UNIT.repeat(NAME_SPACE_SIZE - name.length()) + name;
    }

    private static void printNewLine() {
        System.out.print(System.lineSeparator());
    }


    private static EnumMap<Direction, String> initializedDirectionSymbol() {
        final EnumMap<Direction, String> directionSymbols = new EnumMap<>(Direction.class);
        directionSymbols.put(Direction.RIGHT, RIGHT_DIRECTION_SYMBOL);
        directionSymbols.put(Direction.LEFT, LEFT_DIRECTION_SYMBOL);
        directionSymbols.put(Direction.DOWN, DOWN_DIRECTION_SYMBOL);
        return directionSymbols;
    }
}
