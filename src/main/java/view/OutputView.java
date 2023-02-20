package view;

import domain.Line;
import domain.Players;

import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class OutputView {

    public static final String NAME_FORMAT = "%-9s";
    public static final String VERTICAL_BAR = "|";
    public static final Pattern koreanPattern = Pattern.compile("^[ㄱ-ㅎ가-힣]*$");
    public static final String SPACE = " ";
    public static final double KOREAN_SIZE = 1.3;
    public static final int NAME_SIZE = 8;


    public void printNames(Players players) {
        List<String> names = players.getPlayersName();
        for (int i = 0; i < names.size(); i++) {
            firstPlayerPrint(names, i);
            lastPlayerPrint(names, i);
            middlePlayersPrint(names, i);
        }
    }

    public void printLadders(List<Line> lines, List<String> playerNames) {
        System.out.println();
        for (Line line : lines) {
            printLine(line, playerNames);
        }
    }

    private void firstPlayerPrint(List<String> names, int index) {
        if (isFirstPlayer(index)) {
            System.out.print(String.format(NAME_FORMAT, names.get(index)));
        }
    }

    private static boolean isFirstPlayer(int i) {
        return i == 0;
    }

    private static void middlePlayersPrint(List<String> names, int index) {
        if (isMiddlePlayer(names, index)) {
            System.out.print(String.format(NAME_FORMAT, names.get(index)));
        }
    }

    private static boolean isMiddlePlayer(List<String> names, int index) {
        return 0 < index && index < names.size() - 1;
    }


    private void lastPlayerPrint(List<String> names, int index) {
        if (isLastPlayer(names, index)) {
            System.out.print(String.format(NAME_FORMAT, names.get(index)));
        }
    }

    private static boolean isLastPlayer(List<String> names, int index) {
        return index == names.size() - 1;
    }

    private void printLine(Line line, List<String> playerNames) {
        List<String> ladderLine = BlockType.getBlockTypes(line);
        String firstSpace = calculateFirstSpace(playerNames);
        System.out.print(firstSpace + VERTICAL_BAR);
        for (int i = 0; i < ladderLine.size(); i++) {
            printLadderBlock(playerNames.get(i), playerNames.get(i + 1), ladderLine.get(i));
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
}
