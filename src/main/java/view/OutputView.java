package view;

import domain.Bridge;
import exception.ErrorCode;
import java.util.List;
import java.util.Map;

public class OutputView {
    private static final String RESULT_HEAD = "\n실행결과";
    private static final String BLANK = " ";
    private static final String LADDER_UNIT = "|";
    private static final String BRIDGE_UNIT = "-";
    private static final String DELIMITER = " : ";
    private static final int BRIDGE_SIZE = 5;

    public OutputView() {
    }

    public void printLadderResult(List<String> persons, List<List<Bridge>> ladder, List<String> prizes) {
        System.out.println(RESULT_HEAD + "\n");
        int firstNameLength = printPersons(persons);
        printLadder(ladder, firstNameLength);
        printPrizes(prizes);
    }

    private int printPersons(List<String> names) {
        String firstName = names.remove(0);
        System.out.print(BLANK + firstName);
        names.forEach(name -> System.out.printf(String.format("%%%ds", BRIDGE_SIZE + 1), name));
        System.out.println();
        return firstName.length();
    }

    private static void printLadder(List<List<Bridge>> ladder, int firstNameLength) {
        for (List<Bridge> line : ladder) {
            System.out.print(BLANK.repeat(firstNameLength));
            System.out.print(LADDER_UNIT);
            printEachLine(line);
            System.out.println();
        }
    }

    private static void printEachLine(List<Bridge> line) {
        line.forEach(hasBridge -> printEachBridge(hasBridge.getStatus()));
    }

    private static void printEachBridge(boolean hasBridge) {
        if (hasBridge) {
            System.out.print(BRIDGE_UNIT.repeat(BRIDGE_SIZE));
            System.out.print(LADDER_UNIT);
            return;
        }
        System.out.print(BLANK.repeat(BRIDGE_SIZE));
        System.out.print(LADDER_UNIT);
    }

    private void printPrizes(List<String> results) {
        results.forEach(result -> System.out.printf(String.format("%%%ds", -(BRIDGE_SIZE + 1)), result));
        System.out.println();
    }

    public void printErrorMessage(String errorMessage) {
        System.out.println(ErrorCode.HEAD.getMessage() + errorMessage);
    }

    public void printPersonalResult(String result) {
        System.out.println(RESULT_HEAD);
        System.out.println(result);
    }

    public void printAllResult(Map<String, String> results) {
        System.out.println(RESULT_HEAD);
        for (String name : results.keySet()) {
            String prize = results.get(name);
            System.out.println(name + DELIMITER + prize);
        }
    }
}
