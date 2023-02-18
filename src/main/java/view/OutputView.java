package view;

import domain.Ladder;
import domain.Line;
import domain.Name;
import domain.Names;
import domain.Scaffold;
import java.util.ArrayList;
import java.util.List;
import java.util.regex.Pattern;
import java.util.stream.Collectors;

public class OutputView {
    private static final int MAX_NAME_SIZE = 5;
    private static final int FIRST_NAME_INDEX = 0;
    private static final double INIT_SPAN = 0.0;
    private static final int ONE_BLOCK_SIZE = 10;
    private static final double KOREAN_SPAN = 1.5;
    private static final double OTHER_SPAN = 1.0;
    private static final int BLOCK_SIZE_EXCEPT_DELIMITER = 9;
    private static final String KOREAN_MATCH_REGEX = "[ㄱ-ㅎㅏ-ㅣ가-힣]";
    private static final String EXIST_SCAFFOLD_MATERIAL = "-";
    private static final String NON_EXIST_SCAFFOLD_MATERIAL = " ";
    private static final String BAR = "|";
    private static final String BLANK = " ";

    private static final StringBuilder stringBuilder = new StringBuilder();

    private OutputView() {
    }

    public static void printResult(final Ladder ladder, final Names playerNames) {
        printNames(playerNames);
        printLadder(ladder);
    }

    private static void printNames(Names names) {
        for (Name name : names.getNames()) {
            System.out.print(BLANK.repeat(ONE_BLOCK_SIZE - calculateBlank(name)));
            System.out.printf("%s", name.getValue());
        }
        System.out.println();
    }

    private static int calculateBlank(Name name) {
        double userNameSpan = INIT_SPAN;
        for (Character nameLetter : name.getValue().toCharArray()) {
            userNameSpan += userNameSpanSize(nameLetter);
        }
        return (int) Math.round(userNameSpan);
    }

    private static double userNameSpanSize(Character name) {
        String detectingLetter = String.valueOf(name);

        if (Pattern.matches(KOREAN_MATCH_REGEX, detectingLetter)) {
            return KOREAN_SPAN;
        }
        return OTHER_SPAN;
    }

    private static void printLadder(Ladder ladder) {
        for (Line line : ladder.getLines()) {
            printLine(line);
            System.out.println();
        }
    }

    private static void printLine(Line line) {
        System.out.print(BLANK.repeat(BLOCK_SIZE_EXCEPT_DELIMITER));
        System.out.print(BAR);
        for (Scaffold scaffold : line.getScaffolds()) {
            printLine(scaffold);
        }
    }

    private static void printLine(Scaffold scaffold) {

        if (scaffold.getStatus()) {
            System.out.print(EXIST_SCAFFOLD_MATERIAL.repeat(BLOCK_SIZE_EXCEPT_DELIMITER));
            System.out.print(BAR);
            return;
        }
        System.out.print(NON_EXIST_SCAFFOLD_MATERIAL.repeat(BLOCK_SIZE_EXCEPT_DELIMITER));
        System.out.print(BAR);
    }

}