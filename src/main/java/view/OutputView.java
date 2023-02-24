package view;

import domain.Ladder;
import domain.Line;
import domain.Names;
import domain.Point;
import domain.Result;
import domain.Results;
import java.io.UnsupportedEncodingException;
import java.nio.charset.StandardCharsets;
import java.util.List;

public class OutputView {

    private static final String EDGE_OF_POINT = "|";
    private static final String PASSABLE_POINT = "----------";
    private static final String BLOCKED_POINT = "          ";
    private static final String ERROR_MESSAGE_PREFIX = "[ERROR] ";
    private static final String BLANK_AFTER_NAME = " ";
    public static final String GAME_RESULT_MESSAGE = System.lineSeparator() + "실행결과";
    public static final String NAME_RESULT_DELIMITER = " : ";

    public void printCreatedLadderGame(Names names, Ladder ladder, Results results) {
        printFormattedNames(names);
        printLadder(ladder);
        printFormattedResults(results);
    }

    public void printFormattedResults(Results results) {
        int numberOfStandardBlanks = EDGE_OF_POINT.length() + PASSABLE_POINT.length();
        results.forEach(result -> printFormattedString(result.value(), numberOfStandardBlanks));
        System.out.println();
    }

    public void printFormattedNames(Names names) {
        int numberOfStandardBlanks = EDGE_OF_POINT.length() + PASSABLE_POINT.length();
        names.forEach(name -> printFormattedString(name.value(), numberOfStandardBlanks));
        System.out.println();
    }

    private void printFormattedString(String target, int numberOfStandardBlanks) {
        int numberOfBlanks = getNumberOfBlanks(target, numberOfStandardBlanks);
        System.out.print(target);
        System.out.print(BLANK_AFTER_NAME.repeat(numberOfBlanks));
    }

    private int getNumberOfBlanks(String string, int numberOfStandardBlanks) {
        int numberOfKoreanChars = getNumberOfKoreanChars(string);
        return numberOfStandardBlanks - (numberOfKoreanChars / 2) - string.length();
    }

    private int getNumberOfKoreanChars(String string) {
        try {
            return string.getBytes("euc-kr").length - string.length();
        } catch (UnsupportedEncodingException e) {
            printErrorMessage("지원하지 않는 언어 형식으로 이름이 깨져보일 수 있습니다.");
            return string.getBytes(StandardCharsets.UTF_8).length - string.length();
        }
    }

    private void printLadder(Ladder ladder) {
        List<Line> lines = ladder.lines();
        lines.forEach(this::printLine);
    }

    private void printLine(Line line) {
        line.points().forEach(this::printPoint);
        System.out.println(EDGE_OF_POINT);
    }

    private void printPoint(Point point) {
        if (point.equals(Point.PASSABLE)) {
            System.out.print(EDGE_OF_POINT + PASSABLE_POINT);
            return;
        }
        System.out.print(EDGE_OF_POINT + BLOCKED_POINT);
    }

    public void printOneResult(Result result) {
        System.out.println(GAME_RESULT_MESSAGE);
        System.out.println(result.value());
    }

    public void printAllResult(Names names, Results allResult) {
        System.out.println(GAME_RESULT_MESSAGE);
        for (int i = 0; i < names.size(); i++) {
            System.out.println(names.get(i).value() + NAME_RESULT_DELIMITER + allResult.get(i).value());
        }
    }

    public void printErrorMessage(String message) {
        System.out.println(ERROR_MESSAGE_PREFIX + message);
    }
}
