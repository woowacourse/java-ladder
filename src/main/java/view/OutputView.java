package view;

import domain.LadderGame;
import domain.ladder.Ladder;
import domain.ladder.Line;
import domain.ladder.Point;
import domain.player.Player;
import domain.player.Players;
import domain.prize.Prize;
import domain.prize.Prizes;
import domain.prize.Results;

import java.util.List;

public class OutputView {

    private static final OutputView outputView = new OutputView();
    private static final String RESULT_MESSAGE = "실행결과";
    private static final String NAME_ERROR_MESSAGE = "사다리 게임에 참여한 플레이어의 이름을 입력해주세요.";
    private static final String BLANK = " ";
    private static final String LINE_START_FORMAT = "    |";
    private static final String OBJECT_START_FORMAT = "  ";
    private static final String FORMATTED_DASH = "-----";
    private static final String FORMATTED_BLANK = "     ";
    private static final String DIVIDER = "|";
    private static final int DIVISOR = 2;
    private static final int DEFAULT_PADDING = 2;
    private static final int FLAG = 1;

    public static OutputView getInstance() {
        return outputView;
    }

    public void printLadderGame(LadderGame ladderGame) {
        printNames(ladderGame.getPlayers());
        printLadder(ladderGame.getLadder());
        printPrizes(ladderGame.getPrizes());
    }

    private void printNames(Players players) {
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

    private void printLadder(Ladder ladder) {
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

    private void printPrizes(Prizes prizes) {
        System.out.print(OBJECT_START_FORMAT);
        prizes.getPrizes().stream()
                .map(prize -> prize.getPrize())
                .forEach(outputView::printObject);
        System.out.println();
    }

    public void printOnePlayerResult(Results results, String name) {
        Prize result = results.getPrizeByPlayer(Player.from(name));
        if (result == null) {
            throw new IllegalArgumentException(NAME_ERROR_MESSAGE);
        }
        System.out.println(RESULT_MESSAGE);
        System.out.println(result.getPrize());
        System.out.println();
    }

    public void printAllPlayerResult(Results result) {
        System.out.println(RESULT_MESSAGE);
        for (Player player : result.getPlayers()) {
            System.out.println(player.getName() + " : " + result.getPrizeByPlayer(player).getPrize());
        }
        System.out.println();
    }
}
