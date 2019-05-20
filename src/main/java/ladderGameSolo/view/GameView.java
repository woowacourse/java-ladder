package ladderGameSolo.view;

import ladderGameSolo.controller.LadderGame;
import ladderGameSolo.constant.MessageContants;
import ladderGameSolo.domain.Ladder;

public class GameView {
    private static final int LEFT_NUMBER = -1;

    public void run() {
        String[] names = InputView.inputName().split(MessageContants.DELIMITER_COMMA);
        int height = InputView.inputHeight();
        Ladder ladder = LadderGame.getLadders(names.length, height);

        printLadderInfo(names, height, ladder);
    }

    private void printLadderInfo(String[] names, int height, Ladder ladder) {
        printName(names);
        printLadder(ladder, height);
    }

    private void printName(String[] names) {
        for (String name : names) {
            System.out.print(String.format(MessageContants.RESULT_FORMAT, name));
        }
        System.out.println();
    }

    private void printLadder(Ladder ladder, int height) {
        for (int i = 0; i < height; i++) {
            System.out.print(String.format(MessageContants.RESULT_FORMAT, MessageContants.MESSAGE_COLUMN));
            printBridges(ladder, i);

            System.out.println();
        }
    }

    private void printBridges(Ladder ladder, int directionIndex) {
        for (int i = 1; i < ladder.getLines().size(); i++) {
            int directionMoveResult = ladder.getLines().get(i).getDirections().get(directionIndex).move();

            printBridge(directionMoveResult);
        }
    }

    private void printBridge(int directionMoveResult) {
        if (directionMoveResult == LEFT_NUMBER) {
            System.out.print(String.format(MessageContants.RESULT_FORMAT, MessageContants.MESSAGE_ROW));
        }

        if (directionMoveResult != LEFT_NUMBER) {
            System.out.print(String.format(MessageContants.RESULT_FORMAT, MessageContants.MESSAGE_BLANK));
        }
    }

}
