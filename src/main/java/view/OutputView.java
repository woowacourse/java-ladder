package view;

import domain.Point;
import java.io.UnsupportedEncodingException;
import java.nio.charset.StandardCharsets;
import java.util.List;
import java.util.Map;

public class OutputView {

    private static final String EDGE_OF_POINT = "|";
    private static final String PASSABLE_POINT = "----------";
    private static final String BLOCKED_POINT = "          ";
    private static final String ERROR_MESSAGE_PREFIX = "[ERROR] ";
    private static final String BLANK_AFTER_NAME = " ";
    public static final String GAME_RESULT_MESSAGE = System.lineSeparator() + "실행결과";
    public static final String NAME_RESULT_DELIMITER = " : ";

    public void printCreatedLadderGame(List<String> names, List<List<Point>> ladder, List<String> results) {
        printFormattedLadderNodes(names);
        printLadder(ladder);
        printFormattedLadderNodes(results);
    }

    public void printFormattedLadderNodes(List<String> ladderNodes) {
        int numberOfStandardBlanks = EDGE_OF_POINT.length() + PASSABLE_POINT.length();
        ladderNodes.forEach(ladderNode -> printFormattedLadderNode(ladderNode, numberOfStandardBlanks));
        System.out.println();
    }

    private void printFormattedLadderNode(String target, int numberOfStandardBlanks) {
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

    private void printLadder(List<List<Point>> ladder) {
        ladder.forEach(this::printLine);
    }

    private void printLine(List<Point> line) {
        line.forEach(this::printPoint);
        System.out.println(EDGE_OF_POINT);
    }

    private void printPoint(Point point) {
        if (point.equals(Point.PASSABLE)) {
            System.out.print(EDGE_OF_POINT + PASSABLE_POINT);
            return;
        }
        System.out.print(EDGE_OF_POINT + BLOCKED_POINT);
    }

    public void printOneResult(String result) {
        System.out.println(GAME_RESULT_MESSAGE);
        System.out.println(result);
    }

    public void printAllNamesAndResults(Map<String, String> allNamesAndResults) {
        allNamesAndResults.forEach((name, result) -> System.out.println(name + NAME_RESULT_DELIMITER + result));
    }

    public void printErrorMessage(String message) {
        System.out.println(ERROR_MESSAGE_PREFIX + message);
    }
}
