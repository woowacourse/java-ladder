package ladder.view;

import ladder.model.LadderGame;
import ladder.model.Member;
import ladder.model.Result;
import ladder.model.Row;

import java.util.List;

public class Output {
    private static final String SINGLE_BLANK = " ";
    private static final String NEW_LINE = "\n";
    private static final String GAME_RESULT = "실행 결과";
    private static final int MAX_NAME_LENGTH = 5;

    public static void printLadder(LadderGame game) {
        StringBuilder result = new StringBuilder();
        setPrintName(game, result);
        setPrintLadder(game, result);
        setPrintResults(game, result);
        System.out.println(result);
    }

    private static void setPrintName(LadderGame game, StringBuilder sb) {
        for (Member member : game.getMembers()) {
            sb
                    .append(makePrettyName(member.getName()))
                    .append(SINGLE_BLANK);
        }
    }

    private static void setPrintResults(LadderGame game, StringBuilder sb) {
        for (String result : game.getResults()) {
            sb
                    .append(makePrettyName(result))
                    .append(SINGLE_BLANK);
        }
    }

    private static String makePrettyName(String name) {
        StringBuilder sb = new StringBuilder();
        int blankLength = MAX_NAME_LENGTH - name.length();
        sb.append(name);

        for (int i = 1; i <= blankLength; i++) {
            addBlank(sb, i);
        }

        return sb.toString();
    }

    private static boolean isEven(int number) {
        return number % 2 == 0;
    }

    private static boolean isOdd(int number) {
        return !isEven(number);
    }

    private static void addBlank(StringBuilder sb, int index) {
        if (isEven(index)) {
            sb.append(SINGLE_BLANK);
        }
        if (isOdd(index)) {
            sb.insert(0, SINGLE_BLANK);
        }
    }

    private static void setPrintLadder(LadderGame game, StringBuilder sb) {
        sb.append(NEW_LINE);
        for (Row row : game.getLadder().getLadder()) {
            sb.append(row.toString() + NEW_LINE);
        }
    }

    public static void memberResult(Result result) {
        System.out.println(GAME_RESULT);
        System.out.println(result);
    }

    public static void allResult(List<Result> results) {
        System.out.println(GAME_RESULT);
        results.forEach(System.out::println);
    }
}
