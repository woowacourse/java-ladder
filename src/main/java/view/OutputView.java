package view;

import model.Ladder;
import model.LadderHeight;
import model.Name;

import java.util.List;

public class OutputView {

    private static final String PLAYER_NAME_MESSAGE = "참여할 사람 이름을 입력하세요. (이름은 쉼표(,)로 구분하세요)";
    private static final String LADDER_HEIGHT_MESSAGE = "최대 사다리 높이는 몇 개인가요?";
    private static final String START_LADDER = "   |";
    private static final String CONNECT_LADDER = "-----|";
    private static final String NO_CONNECT_LADDER = "     |";

    private static final int MAXIMUM_PLAYER_NAME = 5;
    public void printPlayerNamesMessage() {
            System.out.println(PLAYER_NAME_MESSAGE);
    }

    public void printLadderHeightMessage() {
        System.out.println(LADDER_HEIGHT_MESSAGE);
    }

    public void printPlayerName( List<Name> names){
        for(int index=0; index<names.size(); index++){
            System.out.print(String.format("%"+ MAXIMUM_PLAYER_NAME +"s ",
                    names.get(index).getName()));
        }
        System.out.println("");
    }

    public void printLadder(int playerSize,Ladder ladder, int ladderHeight) {
        for(int row=0; row<ladderHeight;row++) {
            printStartLadder();
            printConnectLadder(playerSize, ladder, row);
        }
    }

    private void printStartLadder(){
        System.out.print(START_LADDER);
    }

    private void printConnectLadder(int playerSize, Ladder ladder,int row){
        for (int column = 0; column < playerSize - 1; column++) {
            if (ladder.getLadderLine(row, column)) {
                System.out.print(CONNECT_LADDER);
            }
            else
                System.out.print(NO_CONNECT_LADDER);
        }
        System.out.println("");
    }
}
