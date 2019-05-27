package laddergame.view;

import laddergame.domain.AbstractName;
import laddergame.domain.NameList;
import laddergame.domain.ladder.Ladder;
import laddergame.domain.ladder.Line;
import laddergame.domain.ladder.Point;
import laddergame.domain.result.GameResultFormat;

import java.util.List;

public class OutputView {
    public static final int BOUND_OF_NAME_LENGTH = 5;
    private static final String BARS = "-----";

    private OutputView() {

    }

    public static void showMessageOfExecution() {
        System.out.println("실행 결과");
    }

    public static void showPlayers(final NameList players) {
        showMessageOfExecution();
        showNameList(players);
        System.out.println();
    }

    public static void showRewards(final NameList rewards) {
        showNameList(rewards);
        System.out.println();
    }

    private static void showNameList(final NameList names) {
        for (AbstractName name : names.getNames()) {
            System.out.print(String.format("%-" + BOUND_OF_NAME_LENGTH + "s", name.getName()) + " ");
        }
    }

    public static void showLadder(Ladder ladder) {
        List<Line> lines = ladder.getLadderFormat();
        for (Line line : lines) {
            showLine(line);
            System.out.println();
        }
    }

    private static void showLine(Line line) {
        List<Point> points = line.getLineFormat();
        for (Point point : points) {
            showPoint(point);
            System.out.print("|");
        }
    }

    private static void showPoint(Point point) {
        if (point.hasBridge()) {
            System.out.print(BARS);
            return;
        }
        System.out.print("     ");
    }

    public static void showAllResult(List<GameResultFormat> gameResult) {
        for (GameResultFormat gameResultFormat : gameResult) {
            showResult(gameResultFormat);
        }
    }

    public static void showResult(GameResultFormat gameResultFormat) {
        System.out.print(String.format("%-" + BOUND_OF_NAME_LENGTH + "s", gameResultFormat.getPlayerName()));
        System.out.print(" : ");
        System.out.println(String.format("%-" + BOUND_OF_NAME_LENGTH + "s", gameResultFormat.getRewardName()));
    }

    public static void quitGame() {
        System.out.println("게임을 종료합니다");
    }
}
