package view;

import domain.Ladder;
import domain.Line;
import domain.Name;
import domain.Names;
import domain.Prize;
import domain.Prizes;
import domain.Scaffold;
import java.util.Map;
import java.util.regex.Pattern;

public class OutputView {
    private static final int FIRST_NAME_INDEX = 0;
    private static final double INIT_SPAN = 0.0;
    private static final int ONE_BLOCK_SIZE = 10;
    private static final double KOREAN_SPAN = 1.5;
    private static final double OTHER_SPAN = 1.0;
    private static final int BLOCK_SIZE_EXCEPT_DELIMITER = 9;
    private static final String KOREAN_MATCH_REGEX = "[ㄱ-ㅎㅏ-ㅣ가-힣]";
    private static final String STRING_FORMAT = "%s";
    private static final String EXIST_SCAFFOLD_MATERIAL = "-";
    private static final String NON_EXIST_SCAFFOLD_MATERIAL = " ";
    private static final String BAR = "|";
    private static final String BLANK = " ";
    private static final String RESULT_COLON = " : ";
    private static final String MATCH_RESULT = "실행 결과";

    private OutputView() {
    }

    public static void printLadderResult(final Ladder ladder, final Names playerNames, final Prizes prizes) {
        printNames(playerNames);
        printLadder(ladder);
        printPrizes(prizes);
    }

    private static void printNames(final Names names) {
        for (Name name : names.getNames()) {
            System.out.print(BLANK.repeat(ONE_BLOCK_SIZE - calculateNameBlank(name)));
            System.out.printf(STRING_FORMAT, name.getValue());
        }
        System.out.println();
    }

    private static int calculateNameBlank(final Name name) {
        double userNameSpan = INIT_SPAN;
        for (Character nameLetter : name.getValue().toCharArray()) {
            userNameSpan += userNameSpanSize(nameLetter);
        }
        return (int) Math.round(userNameSpan);
    }

    private static double userNameSpanSize(final Character name) {
        String detectingLetter = String.valueOf(name);
        if (Pattern.matches(KOREAN_MATCH_REGEX, detectingLetter)) {
            return KOREAN_SPAN;
        }
        return OTHER_SPAN;
    }

    private static void printLadder(final Ladder ladder) {
        for (Line line : ladder.getLines()) {
            printLine(line);
            System.out.println();
        }
    }

    private static void printLine(final Line line) {
        System.out.print(BLANK.repeat(BLOCK_SIZE_EXCEPT_DELIMITER));
        System.out.print(BAR);
        for (Scaffold scaffold : line.getScaffolds()) {
            printScaffold(scaffold);
        }
    }

    private static void printScaffold(final Scaffold scaffold) {
        if (scaffold.getStatus()) {
            System.out.print(EXIST_SCAFFOLD_MATERIAL.repeat(BLOCK_SIZE_EXCEPT_DELIMITER));
            System.out.print(BAR);
            return;
        }
        System.out.print(NON_EXIST_SCAFFOLD_MATERIAL.repeat(BLOCK_SIZE_EXCEPT_DELIMITER));
        System.out.print(BAR);
    }

    private static void printPrizes(final Prizes prizes) {
        for (Prize prize : prizes.getPrizes()) {
            System.out.print(BLANK.repeat(ONE_BLOCK_SIZE - calculatePrizeBlank(prize)));
            System.out.printf(STRING_FORMAT, prize.getValue());
        }
        System.out.println();
    }

    private static int calculatePrizeBlank(final Prize prize) {
        double prizeSpan = INIT_SPAN;
        for (Character prizeLetter : prize.getValue().toCharArray()) {
            prizeSpan += prizeSpanSize(prizeLetter);
        }
        return (int) Math.round(prizeSpan);
    }

    private static double prizeSpanSize(final Character name) {
        String detectingLetter = String.valueOf(name);
        if (Pattern.matches(KOREAN_MATCH_REGEX, detectingLetter)) {
            return KOREAN_SPAN;
        }
        return OTHER_SPAN;
    }

    public static void printSingleMatching(final String matchingResult) {
        System.out.println(MATCH_RESULT);
        System.out.println(matchingResult);
        System.out.println();
    }

    public static void printTotalMatching(final Map<String, String> totalMatchingResult) {
        System.out.println(MATCH_RESULT);
        totalMatchingResult.forEach((key, value) -> System.out.println(key + RESULT_COLON + value));
    }
}
