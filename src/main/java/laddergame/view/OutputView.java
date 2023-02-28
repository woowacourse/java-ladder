package laddergame.view;

import laddergame.domain.*;

import java.util.List;

import static java.util.stream.Collectors.joining;
import static laddergame.view.LadderElement.BLANK;
import static laddergame.view.LadderElement.VERTICAL_LINE;

public class OutputView {

    private static final int HALF = 2;

    public static void printPlayerAll(final Players players) {
        System.out.println(System.lineSeparator() + "실행결과" + System.lineSeparator());

        final String allPlayerName = players.getPlayerName().stream()
                .map(player -> makeNameFormat(players.findMaxNameLength(), player))
                .collect(joining(BLANK.getLadderElement()));

        System.out.println(allPlayerName);
    }

    public static void printLadder(final Players players, final Ladder ladder) {
        StringBuilder result = new StringBuilder();
        ladder.getLadder().forEach(layer -> result.append(makeLadderFormat(layer.getLayer(), players)));
        System.out.print(result);
    }

    public static void printWinningPrizeAll(final WinningPrizes winningPrizes, final Players players) {
        final String allWinningPrize = winningPrizes.getWinningPrizes().stream()
                .map(winningPrize -> makeNameFormat(players.findMaxNameLength(), winningPrize.getWinningPrize()))
                .collect(joining(BLANK.getLadderElement()));

        System.out.println(allWinningPrize);
    }

    public static void printAllResult(final GameResult gameResult) {
        final StringBuilder result = new StringBuilder();
        final List<Player> players = gameResult.getGameResult();
        final WinningPrizes winningPrizes = gameResult.getWinningPrizes();
        for (int i = 0; i < players.size(); i++) {

            result.append(String.format("%s : %s%n", players.get(i).getName(), winningPrizes.getIndexPrize(i).getWinningPrize()));
        }
        System.out.println("실행 결과");
        System.out.println(result + System.lineSeparator());
    }

    public static void printResult(final String message) {
        System.out.println("실행 결과");
        System.out.println(message);

    }

    public static void printMessage(final String message) {
        System.out.println("[ERROR] " + message + System.lineSeparator());
    }

    private static String makeNameFormat(final int maxNameLength, final String name) {
        int count = maxNameLength - name.length();
        final String repeat = BLANK.getLadderElement().repeat(count);

        return String.format("%s%s", name, repeat);
    }

    private static String makeLadderFormat(final List<Link> layer, final Players names) {
        final StringBuilder result = new StringBuilder(setUpLadder(names.getFirstNameLength()));

        layer.forEach(link -> result.append(visualizeLink(link, names.findMaxNameLength())));
        result.append(System.lineSeparator());

        return result.toString();
    }

    private static String setUpLadder(final int firstNameLength) {
        final int leftBlankCount = Math.round(firstNameLength / HALF);
        return String.format("%s%s", BLANK.getLadderElement().repeat(leftBlankCount), VERTICAL_LINE.getLadderElement());
    }

    private static String visualizeLink(final Link link, final int maxNameLength) {
        return String.format("%s%s", LadderElement.convertFormat(link).repeat(maxNameLength), VERTICAL_LINE.getLadderElement());
    }
}


