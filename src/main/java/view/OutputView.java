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

    public void printResult(Map<Integer, List<Boolean>> ladderInformation, List<String> names, List<String> prizes) {
        System.out.println("사다리 결과");
        System.out.println();
        printPlayers(names);
        printLadder(ladderInformation);
        printPrizes(prizes);
    }

    private void printPlayers(List<String> names) {
        names.forEach(name -> System.out.print(String.format("%6s", name)));
        System.out.println();
    }

    private void printLadder(Map<Integer, List<Boolean>> ladderInformation) {
        for (List<Boolean> lineInformation : ladderInformation.values()) {
            printLine(lineInformation);
        }
    }

    private void printPrizes(List<String> prizes) {
        prizes.forEach(name -> System.out.print(String.format("%6s", name)));
        System.out.println();
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

    public void printPrizeResult(Map<String, String> result) {
        System.out.println("실행 결과");
        if (result.size() == 1) {
            System.out.println(getResultPerPlayer(result));
            return;
        }
        System.out.println(getAllResults(result));
    }

    private String getAllResults(Map<String, String> result) {
        StringBuilder stringBuilder = new StringBuilder();
        for (String name : result.keySet()) {
            stringBuilder.append(name + " : " + result.get(name) + "\n");
        }
        return stringBuilder.toString();
    }

    private String getResultPerPlayer(Map<String, String> result) {
        return result.values().stream().findFirst().get();
    }
}
