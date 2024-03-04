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
    public static final String LADDER_RESULT_MESSAGE = "사다리 결과";
    private static final String GAME_RESULT_MESSAGE = "실행 결과";
    private static final String PRIZE_PER_EACH_PLAYER_MESSAGE = "%s : %s";
    private static final String LINE_SEPARATOR = System.lineSeparator();
    private static final String CONNECTED_LADDER_POINT = "-";
    private static final String NOT_CONNECTED_LADDER_POINT = " ";
    private static final String LADDER_COLUMN = "|";
    private static final String EMPTY_SPACE = " ";

    public static void printLadderResult(Players players, Prizes prizes, Ladder ladder) {
        System.out.println(LINE_SEPARATOR + LADDER_RESULT_MESSAGE + LINE_SEPARATOR);

        final int maxLength = Math.max(players.findMaxNameLength(), prizes.findMaxPrizeLength());
        printPlayerNames(players, maxLength);
        printLadder(ladder, maxLength);
        printPrizes(prizes, maxLength);
    }

    private static void printPlayerNames(Players players, int length) {
        final String result = players.getPlayers()
                .stream()
                .map(player -> alignStringCenter(player.getName(), length))
                .collect(Collectors.joining(EMPTY_SPACE));

        System.out.println(result);
    }

    private static String alignStringCenter(String input, int length) {
        int spaces = length - input.length();
        int left = spaces / 2;
        int right = spaces - left;
        return EMPTY_SPACE.repeat(left) + input + EMPTY_SPACE.repeat(right);
    }

    private static void printLadder(final Ladder ladder, final int length) {
        ladder.getLadderRows()
                .stream()
                .map(LadderRow::getLadderPoints)
                .forEach(ladderPoints -> System.out.println(makeLadderRowText(ladderPoints, length)));
    }

    private static String makeLadderRowText(List<DirectionalPoint> ladderPoints, int length) {
        return EMPTY_SPACE.repeat(length - 1) +
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

    private static void printPrizes(final Prizes prizes, int length) {
        String result = prizes.getPrizes()
                .stream()
                .map(prize -> alignStringCenter(prize.getValue(), length))
                .collect(Collectors.joining(EMPTY_SPACE));

        System.out.println(result);
    }

    public static void printResult(Players players, Prizes prizes, String targetName) {
        System.out.println(LINE_SEPARATOR + GAME_RESULT_MESSAGE);
        if (ALL.equals(targetName)) {
            printTotalGameResult(players.getPlayers(), prizes.getPrizes());
            return;
        }

        final Player targetPlayer = players.findPlayerByName(targetName);
        final Prize prize = prizes.findPrizeByIndex(targetPlayer.getPosition());
        printPrize(prize.getValue());
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
