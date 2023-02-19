package view;

import model.Ladder;
import model.LadderHeight;
import model.Names;
import util.LadderPrintMessage;


public class OutputView {

    private static final String PLAYER_NAME_MESSAGE = "참여할 사람 이름을 입력하세요. (이름은 쉼표(,)로 구분하세요)";
    private static final String LADDER_RESULT_MESSAGE = "실행 결과를 입력하세요. (결과는 쉼표(,)로 구분하세요)";
    private static final String LADDER_HEIGHT_MESSAGE = "최대 사다리 높이는 몇 개인가요?";
    private static final String RESULT_MESSAGE = "실행 결과";

    private static final int MAXIMUM_PLAYER_NAME_SPACE = 5;
    private static StringBuilder stringBuilder;
    public void printPlayerNamesMessage() {
        System.out.println(PLAYER_NAME_MESSAGE);
    }

    public void printLadderHeightMessage() {
        System.out.println(LADDER_HEIGHT_MESSAGE);
    }

    public void printLadderResultMessage() {
        System.out.println(LADDER_RESULT_MESSAGE);
    }

    public void printResultMessage(){
        System.out.println(System.lineSeparator()+RESULT_MESSAGE);
    }

    public void printName(Names names) {
        System.out.println("  ");
        names.getNames().forEach(name -> System.out.printf("%" + MAXIMUM_PLAYER_NAME_SPACE + "s ",
                name.getName()));
        System.out.println();
    }

    public void printLadder(Names names, Ladder ladder, LadderHeight ladderHeight) {
        stringBuilder = new StringBuilder();
        for (int row = 0; row < ladderHeight.getLadderHeight(); row++) {
            stringBuilder.append(printStartLadder());
            printConnectLadder(names.getNames().size(), ladder, row);
            stringBuilder.append(System.lineSeparator());
        }
        System.out.println(stringBuilder);
    }

    private String printStartLadder() {
        return LadderPrintMessage.START_LADDER.getMessage();
    }

    private void printConnectLadder(int playerSize, Ladder ladder, int row) {
        for (int column = 0; column < playerSize - 1; column++) {
            if (ladder.getLadder(row).getLine(column)) {
                stringBuilder.append(LadderPrintMessage.CONNECT_LADDER.getMessage());
            } else
                stringBuilder.append(LadderPrintMessage.NO_CONNECT_LADDER.getMessage());
        }
    }


}
