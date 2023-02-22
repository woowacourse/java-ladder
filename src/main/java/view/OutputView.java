package view;

import model.*;
import util.LadderPrintMessage;

import java.util.Map;

public class OutputView {
    private static final String PLAYER_NAMES_MESSAGE = "참여할 사람 이름을 입력하세요. (이름은 쉼표(,)로 구분하세요)";
    private static final String EXECUTION_RESULT_MESSAGE = "실행 결과를 입력하세요. (결과는 쉼표(,)로 구분하세요)";
    private static final String LADDER_HEIGHT_MESSAGE = "최대 사다리 높이는 몇 개인가요?";
    private static final String PLAYER_RESULT_MESSAGE = "결과를 보고 싶은 사람은?";
    private static final String LADDER_RESULT = "사다리 결과";
    private static final String EXECUTION_RESULT = "실행 결과";
    private static final int MAXIMUM_PLAYER_NAME_SPACE = 5;

    private static StringBuilder stringBuilder;

    public void printPlayerNamesMessage() {
        System.out.println(PLAYER_NAMES_MESSAGE);
    }

    public void printExecutionResultMessage() {
        System.out.println(System.lineSeparator() + EXECUTION_RESULT_MESSAGE);
    }

    public void printLadderHeightMessage() {
        System.out.println(System.lineSeparator() + LADDER_HEIGHT_MESSAGE);
    }

    public void printPlayerResultMessage() {
        System.out.println(System.lineSeparator() + PLAYER_RESULT_MESSAGE);
    }

    public void printPlayerExecutionResultMessage() {
        System.out.println(System.lineSeparator() + EXECUTION_RESULT);
    }

    public void printLadderResultMessage() {
        System.out.println(System.lineSeparator() + LADDER_RESULT);
    }

    public void printName(Names names) {
        System.out.println();
        names.getNames().forEach(name -> System.out.printf("%-" + MAXIMUM_PLAYER_NAME_SPACE + "s ",
                name.getName()));
        System.out.println();
    }

    public void printLadder(Names names, Ladder ladder, LadderHeight ladderHeight) {
        stringBuilder = new StringBuilder();
        for (int row = 0; row < ladderHeight.getLadderHeight(); row++) {
            stringBuilder.append(printStartLadder());
            printConnectLadder(names.getNamesSize(), ladder, row);
            stringBuilder.append(System.lineSeparator());
        }
        System.out.print(stringBuilder);
    }

    private String printStartLadder() {
        return LadderPrintMessage.START_LADDER.getMessage();
    }

    private void printConnectLadder(int playerSize, Ladder ladder, int row) {
        for (int column = 0; column < playerSize - 1; column++) {
            printLineBetweenLadder(ladder, row, column);
        }
    }

    private void printLineBetweenLadder(Ladder ladder, int row, int column) {
        if (ladder.getLadderLine(column, row)) {
            stringBuilder.append(LadderPrintMessage.CONNECT_LADDER.getMessage());
        } else
            stringBuilder.append(LadderPrintMessage.NO_CONNECT_LADDER.getMessage());
    }

    public void printResult(LadderResult result) {
        result.getLadderResult().forEach(name -> System.out.printf("%-" + MAXIMUM_PLAYER_NAME_SPACE + "s ",
                name.getResult()));
        System.out.println();
    }

    public void printPlayerGameResult(String player) {
        System.out.println(player);
    }

    public void printPlayerGameEndResult(Map<Name, Result> prizeResult) {
        stringBuilder = new StringBuilder();
        for (Name name : prizeResult.keySet()) {
            stringBuilder.append(name.getName())
                    .append(" : ")
                    .append(prizeResult.get(name).getResult())
                    .append(System.lineSeparator());
        }
        System.out.print(stringBuilder.toString());
    }
}
