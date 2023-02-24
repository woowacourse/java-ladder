package view;

import java.util.List;
import java.util.Map;

public class OutputView {
    private static final String RESULT_HEAD = "실행결과";
    private static final String LADDER_HEAD = "사다리 결과";
    private static final String BLANK = " ";
    private static final String LADDER_UNIT = "|";
    private static final String BRIDGE_UNIT = "-";
    private static final String ALL_RESULT = "%s : %s";

    public OutputView() {
    }

    public void printLadder(List<String> persons, List<List<Boolean>> ladder, List<String> winningResults,
                            int bridgeSize) {
        System.out.println("\n" + LADDER_HEAD + "\n");
        int firstNameLength = printPersons(persons, bridgeSize);
        printLadder(ladder, firstNameLength, bridgeSize);
        printTextWithBridgeSize(winningResults, bridgeSize);
    }

    public void printSingleResult(String result) {
        System.out.println("\n" + RESULT_HEAD);
        System.out.println(result);
    }

    public void printTotalResult(Map<String, String> result) {
        System.out.println("\n" + RESULT_HEAD);
        result.forEach((name, prize) -> System.out.printf(ALL_RESULT + "\n", name, prize));
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

    private int printPersons(List<String> names, int bridgeSize) {
        String firstName = names.remove(0);
        System.out.print(BLANK + firstName);
        printTextWithBridgeSize(names, bridgeSize);
        return firstName.length();
    }

    private void printTextWithBridgeSize(List<String> texts, int bridgeSize) {
        texts.forEach(text -> System.out.printf(String.format("%%%ds", bridgeSize + 1), text));
        System.out.println();
    }

}
