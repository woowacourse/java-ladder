package ladderGameSolo.view;

import ladderGameSolo.constant.MessageConstants;
import ladderGameSolo.domain.GameMembers;
import ladderGameSolo.domain.Ladder;
import ladderGameSolo.domain.Member;

public class GameView {
    private static final int LEFT_NUMBER = -1;

    public void printLadderInfo(String[] names, String[] inputResult, Ladder ladder) {
        printName(names);
        printLadder(ladder);
        printResult(inputResult);
    }

    public void printGameResult(String[] inputResult, Ladder ladder, GameMembers gameMembers) {
        System.out.println(MessageConstants.MESSAGE_RESULT);

        for (int i = 0; i < gameMembers.getSize(); i++) {
            String result = getResult(ladder, gameMembers.getMemberByIndex(i), inputResult);
            printResult(gameMembers, gameMembers.getMemberByIndex(i), result);
        }
    }

    private String getResult(Ladder ladder, Member member, String[] result) {
        int resultIndex = member.getResultIndex(ladder);
        return result[resultIndex];
    }

    private void printName(String[] names) {
        for (String name : names) {
            System.out.print(String.format(MessageConstants.RESULT_FORMAT, name));
        }
        System.out.println();
    }

    private void printLadder(Ladder ladder) {
        int height = ladder.getHeight();

        for (int i = 0; i < height; i++) {
            System.out.print(String.format(MessageConstants.RESULT_FORMAT, MessageConstants.MESSAGE_COLUMN));
            printBridges(ladder, i);

            System.out.println();
        }
    }

    private void printBridges(Ladder ladder, int directionIndex) {
        for (int i = 1; i < ladder.getLineSize(); i++) {
            int directionMoveResult = ladder.getLineByIndex(i).getDirectionByIndex(directionIndex).move();

            printBridge(directionMoveResult);
        }
    }

    private void printBridge(int directionMoveResult) {
        if (directionMoveResult == LEFT_NUMBER) {
            System.out.print(String.format(MessageConstants.RESULT_FORMAT, MessageConstants.MESSAGE_ROW));
        }

        if (directionMoveResult != LEFT_NUMBER) {
            System.out.print(String.format(MessageConstants.RESULT_FORMAT, MessageConstants.MESSAGE_BLANK));
        }
    }

    private void printResult(GameMembers gameMembers, Member member, String result) {
        if (gameMembers.getSize() > 1) {
            System.out.print(String.format(MessageConstants.RESULT_ALL_FORMAT, member.getName()));
        }

        System.out.println(result);
    }

    private void printResult(String[] inputResult) {
        for (String result : inputResult) {
            System.out.print(String.format(MessageConstants.RESULT_FORMAT, result));
        }
        System.out.println();
    }
}
