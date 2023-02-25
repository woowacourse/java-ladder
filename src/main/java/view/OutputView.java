package view;

import domain.Ladder;
import domain.LadderGameResult;
import domain.Line;
import domain.Player;
import domain.Players;

import domain.Prize;
import domain.Prizes;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class OutputView {

    private static final String NAME_FORMAT = "%-9s";
    private static final String VERTICAL_BAR = "|";
    private static final Pattern koreanPattern = Pattern.compile("^[ㄱ-ㅎ가-힣]*$");
    private static final String SPACE = " ";
    private static final double KOREAN_SIZE = 1.3;
    private static final int NAME_SIZE = 8;
    private static final String RESULT_MESSAGE = "실행 결과";
    private static final int SECOND_PRIZE = 1;
    private static final String LADDER_RESULT_MESSAGE = "사다리 결과";

    public void printResult() {
        System.out.println();
        System.out.println(LADDER_RESULT_MESSAGE);
        System.out.println();
    }

    public void printNames(Players players) {
        List<String> names = players.getPlayersName();
        for (int i = 0; i < names.size(); i++) {
            firstPlayerPrint(names, i);
            lastPlayerPrint(names, i);
            middlePlayersPrint(names, i);
        }
    }

    public void printLadders(Ladder ladder, List<String> playerNames) {
        System.out.println();
        for (Line line : ladder.getLines()) {
            printLine(line, playerNames);
        }
    }

    public void printPrize(Prizes prizes, Players players) {
        List<String> prizeNames = prizes.getPrizeName();
        List<String> playerNames = players.getPlayersName();
        printFirstPrize(playerNames, prizeNames.get(0));
        printOtherPrize(prizeNames, playerNames);
        System.out.println();
    }

    public void printIndividualResult(LadderGameResult result, Player player) {
        printResultMessage();
        Prize prize = result.getPrizeOfPlayer(player);
        System.out.println(prize.getPrize());
    }

    public void printAllResult(LadderGameResult result) {
        printResultMessage();
        for (Player player : result.getResult().keySet()) {
            Prize prize = result.getPrizeOfPlayer(player);
            System.out.println(player.getName() + " : " + prize.getPrize());
        }
    }


    private void firstPlayerPrint(List<String> names, int index) {
        if (isFirstPlayer(index)) {
            System.out.printf(NAME_FORMAT, names.get(index));
        }
    }

    private static boolean isFirstPlayer(int i) {
        return i == 0;
    }

    private static void middlePlayersPrint(List<String> names, int index) {
        if (isMiddlePlayer(names, index)) {
            System.out.printf(NAME_FORMAT, names.get(index));
        }
    }

    private static boolean isMiddlePlayer(List<String> names, int index) {
        return 0 < index && index < names.size() - 1;
    }


    private void lastPlayerPrint(List<String> names, int index) {
        if (isLastPlayer(names, index)) {
            System.out.printf(NAME_FORMAT, names.get(index));
        }
    }

    private static boolean isLastPlayer(List<String> names, int index) {
        return index == names.size() - 1;
    }

    private void printLine(Line line, List<String> playerNames) {
        List<BlockType> ladderLine = BlockType.getBlockTypes(line);
        printFirstPrize(playerNames, VERTICAL_BAR);
        for (int i = 0; i < ladderLine.size(); i++) {
            printLadderBlock(playerNames.get(i), playerNames.get(i + 1), ladderLine.get(i).getType());
        }
        System.out.println();
    }

    private String calculateFirstSpace(List<String> playerNames) {
        if (isKorean(playerNames.get(0))) {
            return SPACE.repeat((int) Math.round(playerNames.get(0).length() * KOREAN_SIZE));
        }
        return SPACE.repeat(playerNames.get(0).length());
    }

    private void printLadderBlock(String prePlayerName, String currentPlayerNames, String ladderLineBlock) {
        System.out.print(ladderLineBlock.repeat(repeatCount(prePlayerName, currentPlayerNames)) + VERTICAL_BAR);
    }

    private int repeatCount(String preName, String currentName) {
        if (isKorean(currentName)) {
            return (int) Math.round(currentName.length() * KOREAN_SIZE + calculateNameSpace(preName));
        }
        return currentName.length() + calculateNameSpace(preName);
    }

    private boolean isKorean(String name) {
        Matcher koreanMatcher = koreanPattern.matcher(name);
        return koreanMatcher.matches();
    }

    private int calculateNameSpace(String name) {
        return NAME_SIZE - name.length();
    }

    private void printResultMessage() {
        System.out.println();
        System.out.println(RESULT_MESSAGE);
    }

    private void printOtherPrize(List<String> prizeNames, List<String> playerNames) {
        for(int i = SECOND_PRIZE; i < prizeNames.size(); i++) {
            int preIndex = i - 1;
            int spaceSize = calculateNameSpace(playerNames.get(preIndex)) + playerNames.get(i).length();
            System.out.print(SPACE.repeat(spaceSize) + prizeNames.get(i));
        }
    }

    private void printFirstPrize(List<String> playerNames, String prizeNames) {
        String firstSpace = calculateFirstSpace(playerNames);
        System.out.print(firstSpace + prizeNames);
    }
}
