package view;

import domain.ladder.attirbute.Direction;

import java.util.List;

public class OutputView {
    private static final String BLANK_SPACE = "      ";
    private static final int NAME_SPACE_SIZE = 7;
    private static final String NAME_SPACE_UNIT = " ";
    private static final String ALL_RESULT_PRINT_FORMAT = "%s : %s";

    private OutputView() {
    }

    public static <T> void printObjectNames(List<T> names) {
        names.stream()
             .map(Object::toString)
             .map(OutputView::padString)
             .forEach(System.out::print);
        printNewLine();
    }

    private static String padString(String name) {
        return NAME_SPACE_UNIT.repeat(NAME_SPACE_SIZE - name.length()) + name;
    }

    public static void printNewLine() {
        print(System.lineSeparator());
    }

    public static void printDirections(List<Direction> directions) {
        StringBuilder resultStringBuilder = new StringBuilder();

        resultStringBuilder.append(BLANK_SPACE);
        directions.forEach(direction -> resultStringBuilder.append(direction.getSymbol()));

        print(resultStringBuilder.toString());
    }

    public static void printAllResults(String name, String prize) {
        String resultAndPrize = String.format(ALL_RESULT_PRINT_FORMAT, name, prize);
        print(resultAndPrize);
    }

    public static void print(String toBePrint) {
        System.out.println(toBePrint);
    }

}
