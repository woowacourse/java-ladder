package view;

import model.Ladder;
import model.Name;

import java.util.List;

public class OutputView {

    private static final String PLAYER_NAME_MESSAGE = "참여할 사람 이름을 입력하세요. (이름은 쉼표(,)로 구분하세요)";
    private static final String LADDER_HEIGHT_MESSAGE = "최대 사다리 높이는 몇 개인가요?";
    private static final int MAXIMUM_PLAYER_NAME_Length = 5;

    private static StringBuilder stringBuilder = new StringBuilder();

    public void printPlayerNamesMessage() {
            System.out.println(PLAYER_NAME_MESSAGE);
    }

    public void printLadderHeightMessage() {
        System.out.println(LADDER_HEIGHT_MESSAGE);
    }

    public void printPlayerName( List<Name> names){
        names.forEach(name -> System.out.printf("%-"+ MAXIMUM_PLAYER_NAME_Length +"s", name.getName()));
        System.out.println("");
    }

    public void printLadder(int playerSize,Ladder ladder, int ladderHeight) {
        for(int row=0; row<ladderHeight;row++) {
            stringBuilder.append(printStartLadder());
            printConnectLadder(playerSize, ladder, row);
            stringBuilder.append(System.lineSeparator());
        }
        System.out.println(stringBuilder);
    }

    private String printStartLadder(){
        return Message.START_LADDER.getMessage();
    }

    private void printConnectLadder(int playerSize, Ladder ladder,int row){
        for (int column = 0; column < playerSize - 1; column++) {
            if (ladder.getLadderLine(row, column)) {
                stringBuilder.append(Message.CONNECT_LADDER.getMessage());
            }
            else
                stringBuilder.append(Message.NO_CONNECT_LADDER.getMessage());
        }
    }

    public enum Message {
        START_LADDER("   |"),
        CONNECT_LADDER("-----|"),
        NO_CONNECT_LADDER("     |");

        private final String message;

        Message(String move){
            this.message = move;
        }

        public String getMessage() {
            return message;
        }

    }
}
