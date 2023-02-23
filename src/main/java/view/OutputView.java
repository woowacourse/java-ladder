package view;

import java.util.List;
import java.util.Map;

import domain.*;

public class OutputView {

    private static final OutputView outputView = new OutputView();

    private final String RESULT_MESSAGE = "실행결과";
    private final String NAME_ERROR_MESSAGE = "사다리 게임에 참여한 플레이어의 이름을 입력해주세요.";
    private final String BLANK = " ";
    private final String LINE_START_FORMAT = "    |";
    private final String OBJECT_START_FORMAT = "  ";
    private final String FORMATTED_DASH = "-----";
    private final String FORMATTED_BLANK = "     ";
    private final String DIVIDER = "|";
    private final int DIVISOR = 2;
    private final int DEFAULT_PADDING = 2;
    private final int FLAG = 1;

    public static OutputView getOutputView() {
        return outputView;
    }

    public void printNames(Players players) {
        System.out.print(OBJECT_START_FORMAT);
        players.getPlayers().stream()
                .map(Player::getName)
                .forEach(outputView::printObject);
        System.out.println();
    }

    private void printObject(String name) {
        String formattedName = generateCentralFormattedObject(name);
        System.out.print(formattedName + BLANK);
    }

    private String generateCentralFormattedObject(String object) {
        int length = object.length();
        int leftPadding = DEFAULT_PADDING - length / DIVISOR;
        int rightPadding = DEFAULT_PADDING - (length - FLAG) / DIVISOR;
        return BLANK.repeat(leftPadding) + object + BLANK.repeat(rightPadding);
    }

    public void printLadder(Ladder ladder) {
        ladder.getLadder().forEach(outputView::printLine);
    }

    private void printLine(Line line) {
        List<Point> points = line.getLine();
        StringBuilder result = new StringBuilder(LINE_START_FORMAT);
        points.forEach(point -> result.append(toFormattedPoint(point)));
        System.out.println(result);
    }

    private String toFormattedPoint(Point point) {
        if (point.getStatus()) {
            return FORMATTED_DASH + DIVIDER;
        }
        return FORMATTED_BLANK + DIVIDER;
    }

    public void printPrizes(Prize prizes) {
        System.out.print(OBJECT_START_FORMAT);
        prizes.getPrizes()
                .forEach(outputView::printObject);
        System.out.println();
    }

    public void printOnePlayerResult(Map<String, String> results, String name) {
        String result = results.get(name);
        if (result == null) {
            throw new IllegalArgumentException(NAME_ERROR_MESSAGE);
        }
        System.out.println(RESULT_MESSAGE);
        System.out.println(result);
        System.out.println();
    }

    public void printAllPlayerResult(Map<String, String> result) {
        System.out.println(RESULT_MESSAGE);
        for (String key : result.keySet()) {
            System.out.println(key + " : " + result.get(key));
        }
        System.out.println();
    }
}
