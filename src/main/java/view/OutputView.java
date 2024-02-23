package view;

import java.util.List;
import java.util.Map;

public class OutputView {

    private static final String HORIZON_DELIMITER = "-----";
    private static final String VERTICAL_DELIMITER = "|";
    private static final String SPACE = "     ";

    public void printErrorMessage(String errorMessage) {
        System.out.println(errorMessage);
    }

    public void printResult(Map<Integer, List<Boolean>> ladderInformation, List<String> names) {
        System.out.println("실행결과\n");
        printPlayer(names);
        printLadder(ladderInformation);
    }

    private void printPlayer(List<String> names) {
        names.forEach(name -> System.out.print(String.format("%6s", name)));
        System.out.println();
    }

    private void printLadder(Map<Integer, List<Boolean>> ladderInformation) {
        for (List<Boolean> lineInformation : ladderInformation.values()) {
            printLine(lineInformation);
        }
    }

    private void printLine(List<Boolean> lineInformation) {
        System.out.print(SPACE);
        System.out.print(VERTICAL_DELIMITER);
        for (boolean isHorizon : lineInformation) {
            printBridge(isHorizon);
        }
        System.out.println();
    }

    private void printBridge(boolean isHorizon) {
        if (isHorizon) {
            System.out.print(HORIZON_DELIMITER);
            System.out.print(VERTICAL_DELIMITER);
            return;
        }
        System.out.print(SPACE);
        System.out.print(VERTICAL_DELIMITER);
    }
}
