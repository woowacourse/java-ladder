package view;

import exception.ErrorCode;
import java.util.List;

public class OutputView {
    private static final String RESULT_HEAD = "실행결과";
    private static final String BLANK = " ";
    private static final String LADDER_UNIT = "|";
    private static final String BRIDGE_UNIT = "-";

    public OutputView() {
    }

    public void printLadder(List<String> persons, List<List<Boolean>> ladder, int bridgeSize) {
        System.out.println(RESULT_HEAD + "\n");
        int firstNameLength = printPersons(persons, bridgeSize);
        printLadder(ladder, firstNameLength, bridgeSize);
    }

    private static void printLadder(List<List<Boolean>> ladder, int firstNameLength, int bridgeSize) {
        for (List<Boolean> line : ladder) {
            System.out.print(BLANK.repeat(firstNameLength));
            System.out.print(LADDER_UNIT);
            printEachLine(bridgeSize, line);
            System.out.println();
        }
    }

    private static void printEachLine(int bridgeSize, List<Boolean> line) {
        line.forEach(hasBridge -> printEachBridge(bridgeSize, hasBridge));
    }

    private static void printEachBridge(int bridgeSize, boolean hasBridge) {
        if (hasBridge) {
            System.out.print(BRIDGE_UNIT.repeat(bridgeSize));
            System.out.print(LADDER_UNIT);
            return;
        }
        System.out.print(BLANK.repeat(bridgeSize));
        System.out.print(LADDER_UNIT);
    }

    public void printErrorMessage(String errorMessage) {
        System.out.println(ErrorCode.HEAD.getMessage() + errorMessage);
    }

    private int printPersons(List<String> names, int bridgeSize) {
        String firstName = names.remove(0);
        System.out.print(BLANK + firstName);
        names.forEach(name -> System.out.printf(String.format("%%%ds", bridgeSize + 1), name));
        System.out.println();
        return firstName.length();
    }

}
