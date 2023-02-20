package view;

import domain.Ladder;
import domain.Line;
import domain.Name;
import domain.Names;
import domain.Point;
import java.io.UnsupportedEncodingException;
import java.nio.charset.StandardCharsets;
import java.util.List;

public class OutputView {

    private static final String EDGE_OF_POINT = "|";
    private static final String PASSABLE_POINT = "----------";
    private static final String BLOCKED_POINT = "          ";
    private static final String ERROR_MESSAGE_PREFIX = "[ERROR] ";
    private static final String BLANK_AFTER_NAME = " ";

    public void printResult(Names names, Ladder ladder) {
        System.out.println("실행결과");

        printFormattedNames(names);
        printLadder(ladder);
    }

    private void printFormattedNames(Names names) {
        int numberOfStandardBlanks = EDGE_OF_POINT.length() + PASSABLE_POINT.length();
        names.stream().forEach(name -> {
            int numberOfBlanksAfterName = getNumberOfBlanksAfterName(name, numberOfStandardBlanks);
            System.out.print(name.value());
            System.out.print(BLANK_AFTER_NAME.repeat(numberOfBlanksAfterName));
        });
        System.out.println();
    }

    private int getNumberOfBlanksAfterName(Name name, int numberOfStandardBlanks) {
        int numberOfKoreanChars = getNumberOfKoreanChars(name);
        return numberOfStandardBlanks - (numberOfKoreanChars / 2) - name.length();
    }

    private int getNumberOfKoreanChars(Name name) {
        try {
            return name.value().getBytes("euc-kr").length - name.length();
        } catch (UnsupportedEncodingException e) {
            printErrorMessage("지원하지 않는 언어 형식으로 이름이 깨져보일 수 있습니다.");
            return name.value().getBytes(StandardCharsets.UTF_8).length - name.length();
        }
    }

    private void printLadder(Ladder ladder) {
        List<Line> lines = ladder.getLines();
        for (Line line : lines) {
            printLine(line);
        }
    }

    private void printLine(Line line) {
        line.getPoints().forEach(this::printPoint);
        System.out.println(EDGE_OF_POINT);
    }

    private void printPoint(Point point) {
        if (point.equals(Point.PASSABLE)) {
            System.out.print(EDGE_OF_POINT + PASSABLE_POINT);
            return;
        }
        System.out.print(EDGE_OF_POINT + BLOCKED_POINT);
    }

    public void printErrorMessage(String message) {
        System.out.println(ERROR_MESSAGE_PREFIX + message);
    }
}
