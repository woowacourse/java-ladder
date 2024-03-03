package view;

import static common.ReservedKeywords.ALL;
import static domain.ladder.DirectionalPoint.RIGHT;

import domain.ladder.DirectionalPoint;
import domain.ladder.Ladder;
import domain.ladder.LadderRow;
import domain.player.Player;
import domain.player.Players;
import domain.prize.Prize;
import domain.prize.Prizes;
import java.util.List;
import java.util.stream.Collectors;

public class OutputView {
    private static final String LINE_SEPARATOR = System.lineSeparator();
    private static final String GAME_RESULT_MESSAGE = "실행 결과";
    private static final String PRIZE_PER_EACH_PLAYER_MESSAGE = "%s : %s";
    private static final String CONNECTED_LADDER_POINT = "-";
    private static final String NOT_CONNECTED_LADDER_POINT = " ";
    private static final String LADDER_COLUMN = "|";
    private static final String SPACE = " ";

    public static void printLadderResult(Players players, Prizes prizes, Ladder ladder, int length) {
        System.out.println(LINE_SEPARATOR + "사다리 결과" + LINE_SEPARATOR);
        printPlayerNames(players);
        printLadder(ladder, length);
        printPrizes(prizes);
    }

    private static void printPlayerNames(Players players) {
        StringBuilder stringBuilder = new StringBuilder();

        players.getPlayers()
                .stream()
                .map(player -> alignStringCenter(player.getName()))
                .forEach(stringBuilder::append);

        System.out.println(stringBuilder);
    }

    private static String alignStringCenter(String input) {
        int spaces = 6 - input.length();
        int left = spaces / 2;
        int right = spaces - left;
        return SPACE.repeat(left) + input + SPACE.repeat(right);
    }

    private static void printLadder(final Ladder ladder, final int length) {
        ladder.getLadderRows()
                .stream()
                .map(LadderRow::getLadderPoints)
                .forEach(ladderPoints -> System.out.println(makeLadderRowText(ladderPoints, length)));
    }

    private static String makeLadderRowText(List<DirectionalPoint> ladderPoints, int length) {
        return SPACE.repeat(length) +
                ladderPoints.stream()
                        .limit(ladderPoints.size() - 1)
                        .map(point -> makeLadderPointText(point, length))
                        .collect(Collectors.joining(LADDER_COLUMN, LADDER_COLUMN, LADDER_COLUMN));
    }

    private static String makeLadderPointText(DirectionalPoint point, int length) {
        if (point == RIGHT) {
            return CONNECTED_LADDER_POINT.repeat(length);
        }
        return NOT_CONNECTED_LADDER_POINT.repeat(length);
    }

    private static void printPrizes(final Prizes prizes) {
        StringBuilder stringBuilder = new StringBuilder();

        prizes.getPrizes()
                .stream()
                .map(prize -> alignStringCenter(prize.getValue()))
                .forEach(stringBuilder::append);

        System.out.println(stringBuilder);
    }

    public static void printResult(Players players, Prizes prizes, String targetName) {
        System.out.println(LINE_SEPARATOR + GAME_RESULT_MESSAGE);
        if (ALL.equals(targetName)) {
            printTotalGameResult(players.getPlayers(), prizes.getPrizes());
            return;
        }

        final Prize resultByPlayer = prizes.findPrizeByPlayer(players.findPlayerByName(targetName));
        printPrize(resultByPlayer.getValue());
    }

    private static void printPrize(final String prize) {
        System.out.println(prize);
    }

    private static void printTotalGameResult(final List<Player> players, final List<Prize> prizes) {
        players.forEach(player -> {
            final int playerPosition = player.getPosition();
            final Prize prize = prizes.get(playerPosition);
            System.out.println(String.format(PRIZE_PER_EACH_PLAYER_MESSAGE, player.getName(), prize.getValue()));
        });
    }

    public static void printErrorMessage(Exception e) {
        System.out.println(e.getMessage());
    }
}
