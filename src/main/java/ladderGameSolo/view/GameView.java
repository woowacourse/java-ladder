package ladderGameSolo.view;

import ladderGameSolo.controller.LadderGame;
import ladderGameSolo.constant.MessageContants;
import ladderGameSolo.domain.Ladder;
import ladderGameSolo.domain.Member;

import java.util.List;

public class GameView {
    private static final int LEFT_NUMBER = -1;

    public void run() {
        String[] names = InputView.inputName().split(MessageContants.DELIMITER_COMMA);
        String[] inputResult = InputView.inputResult(names.length).split(MessageContants.DELIMITER_COMMA);
        int height = InputView.inputHeight();
        Ladder ladder = LadderGame.getLadders(names.length, height);

        printLadderInfo(names, inputResult, height, ladder);

        String targetName = InputView.inputTargetName(names);
        List<Member> members = LadderGame.makeMembers(names, targetName, height);
        printGameResult(inputResult, ladder, members);
    }

    private void printLadderInfo(String[] names, String[] inputResult, int height, Ladder ladder) {
        printName(names);
        printLadder(ladder, height);
        printResult(inputResult);
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

    private void printGameResult(String[] inputResult, Ladder ladder, List<Member> members) {
        System.out.println(MessageContants.MESSAGE_RESULT);

        for (Member member : members) {
            String result = LadderGame.getResult(ladder, member, inputResult);
            printResult(members, member, result);
        }
    }

    private void printResult(List<Member> members, Member member, String result) {
        if (members.size() > 1) {
            System.out.print(String.format(MessageContants.RESULT_ALL_FORMAT, member.getName()));
        }

        System.out.println(result);
    }

    private void printResult(String[] inputResult) {
        for (String result : inputResult) {
            System.out.print(String.format(MessageContants.RESULT_FORMAT, result));
        }
        System.out.println();
    }
}
