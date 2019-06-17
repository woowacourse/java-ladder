package ladder.view;

import ladder.model.Game;
import ladder.model.Ladder;
import ladder.model.Line;

import java.util.List;

public class Output {
    private static final String NEW_LINE;
    private static final String VERTICAL_LINE;
    private static final String LINKED_LINE;
    private static final String BLANK_LINE;
    private static final String SINGLE_BLANK;
    private static final String DOUBLE_BLANK;
    private static final String COLON;
    private static final String GAME_RESULT;
    private static final String ALL;
    private static final String EXCEPTION_WRONG_INPUT;
    private static final int MAX_NAME_LENGTH;

    static {
        EXCEPTION_WRONG_INPUT = "이름을 잘못 입력하셨습니다.";
        MAX_NAME_LENGTH = 5;
        COLON = " : ";
        SINGLE_BLANK = " ";
        DOUBLE_BLANK = "  ";
        NEW_LINE = "\n";
        VERTICAL_LINE = "|";
        LINKED_LINE = "-----";
        BLANK_LINE = "     ";
        GAME_RESULT = "실행 결과";
        ALL = "ALL";
    }

    public static void GameResult(Game game) {
        names(game.getNames());
        ladder(game.getLadder());
        names(game.getOutcomes());
    }

    private static void names(List<String> names) {
        StringBuilder sb = new StringBuilder();
        for (String name : names) {
            sb.append(makePrettyName(name));
            sb.append(SINGLE_BLANK);
        }
        System.out.println(sb);
    }

    private static void ladder(Ladder ladder) {
        List<Line> lines = ladder.getLines();
        StringBuilder sb = new StringBuilder();
        for (Line line : lines) {
            sb.append(oneLine(line));
            sb.append(NEW_LINE);
        }
        System.out.print(sb);
    }

    private static StringBuilder oneLine(Line line) {
        StringBuilder sb = new StringBuilder();
        sb.append(DOUBLE_BLANK);
        for (boolean row : line.getHorizontalPattern()) {
            sb.append(VERTICAL_LINE);
            sb.append(row ? LINKED_LINE : BLANK_LINE);
        }
        return sb;
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

    public static void endResult(Game game, String name) throws Exception {
        List<String> names = game.getNames();
        List<String> results = game.getResults();
        int nameIndex = names.indexOf(name);
        endResultNameCheck(names, name);
        System.out.println(GAME_RESULT);
        endResultPrint(names, results, nameIndex);
    }

    private static void endResultNameCheck(List<String> names, String name) throws Exception {
        if (names.indexOf(name) < 0 && !name.toUpperCase().equals(ALL)) {
            throw new Exception(EXCEPTION_WRONG_INPUT);
        }
    }

    private static void endResultPrint(List<String> names, List<String> results, int nameIndex) {
        if (nameIndex >= 0) {
            System.out.println(names.get(nameIndex) + COLON + results.get(nameIndex));
            return;
        }
        for (int i = 0; i < names.size(); i++) {
            System.out.println(names.get(i) + COLON + results.get(i));
        }
    }
}
