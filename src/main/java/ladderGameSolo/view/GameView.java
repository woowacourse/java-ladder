package ladderGameSolo.view;

import ladderGameSolo.constant.MessageConstants;
import ladderGameSolo.domain.GameMembers;
import ladderGameSolo.domain.Ladder;
import ladderGameSolo.domain.Member;

import java.util.List;

public class GameView {
    private static final int LEFT_NUMBER = -1;

    public static void printLadderInfo(String[] names, String[] inputResult, Ladder ladder) {
        printName(names);
        printLadder(ladder);
        printResult(inputResult);
    }

    public static void printGameResult(GameMembers gameMembers, List<String> result) {
        System.out.println(MessageConstants.MESSAGE_RESULT);

        for (int i = 0; i < gameMembers.getSize(); i++) {
            printResult(gameMembers, gameMembers.getMemberByIndex(i), result.get(i));
        }
    }

    private static void printName(String[] names) {
        for (String name : names) {
            System.out.print(String.format(MessageConstants.RESULT_FORMAT, name));
        }
        System.out.println();
    }

    private static void printLadder(Ladder ladder) {
        int height = ladder.getHeight();

        for (int i = 0; i < height; i++) {
            System.out.print(String.format(MessageConstants.RESULT_FORMAT, MessageConstants.MESSAGE_COLUMN));
            printBridges(ladder, i);

            System.out.println();
        }
    }

    private static void printBridges(Ladder ladder, int directionIndex) {
        for (int i = 1; i < ladder.getLineSize(); i++) {
            int directionMoveResult = ladder.getLineByIndex(i).getDirectionByIndex(directionIndex).move();

            printBridge(directionMoveResult);
        }
    }

    private static void printBridge(int directionMoveResult) {
        if (directionMoveResult == LEFT_NUMBER) {
            System.out.print(String.format(MessageConstants.RESULT_FORMAT, MessageConstants.MESSAGE_ROW));
        }

        if (directionMoveResult != LEFT_NUMBER) {
            System.out.print(String.format(MessageConstants.RESULT_FORMAT, MessageConstants.MESSAGE_BLANK));
        }
    }

    private static void printResult(GameMembers gameMembers, Member member, String result) {
        if (gameMembers.getSize() > 1) {
            System.out.print(String.format(MessageConstants.RESULT_ALL_FORMAT, member.getName()));
        }

        System.out.println(result);
    }

    private static void printResult(String[] inputResult) {
        for (String result : inputResult) {
            System.out.print(String.format(MessageConstants.RESULT_FORMAT, result));
        }
        System.out.println();
    }
}
