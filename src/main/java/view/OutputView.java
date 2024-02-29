package view;

import domain.Name;
import domain.ladder.attirbute.Direction;
import java.util.EnumMap;
import java.util.List;

public class OutputView {

    private static final int NAME_SPACE_SIZE = 7;
    private static final String NAME_SPACE_UNIT = " ";
    private static final String DEFAULT_BLANK_SPACE = "      ";
    private static final String LADDER_LEG_PIECE_SYMBOL = "|";
    private static final String LADDER_LEG_BRANCH_SYMBOL = "------";
    private static final String ALL_RESULT_PRINT_FORMAT = "%s : %s";
    private static final EnumMap<Direction, String> directionSymbols = initiateDirectionSymbolMap();

    private OutputView() {
    }

    private static EnumMap<Direction, String> initiateDirectionSymbolMap() {
        EnumMap<Direction, String> directionSymbolMap = new EnumMap<>(Direction.class);
        directionSymbolMap.put(Direction.LEFT, DEFAULT_BLANK_SPACE);
        directionSymbolMap.put(Direction.RIGHT, LADDER_LEG_BRANCH_SYMBOL);
        directionSymbolMap.put(Direction.DOWN, DEFAULT_BLANK_SPACE);
        return directionSymbolMap;
    }

    public static void printObjectNames(List<? extends Name> names) {
        names.stream()
                .map(Name::getValue)
                .map(OutputView::padString)
                .forEach(System.out::print);
        printNewLine();
    }

    private static String padString(String name) {
        return NAME_SPACE_UNIT.repeat(NAME_SPACE_SIZE - name.length()) + name;
    }

    public static void printDirections(List<Direction> directions) {
        print(formatLadderResultString(directions));
    }

    private static String formatLadderResultString(List<Direction> directions) {
        StringBuilder result = new StringBuilder();
        result.append(DEFAULT_BLANK_SPACE);
        directions.forEach(direction -> {
            result.append(LADDER_LEG_PIECE_SYMBOL);
            result.append(directionSymbols.get(direction));
        });
        return result.toString();
    }

    public static void printAllResults(String name, String prize) {
        String resultAndPrize = String.format(ALL_RESULT_PRINT_FORMAT, name, prize);
        print(resultAndPrize);
    }

    public static void printNewLine() {
        System.out.print(System.lineSeparator());
    }

    public static void print(String toBePrint) {
        System.out.println(toBePrint);
    }

}
