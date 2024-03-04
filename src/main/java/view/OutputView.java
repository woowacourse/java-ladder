package view;

import domain.ladder.Connection;
import domain.ladder.Floor;
import domain.ladder.Ladder;
import domain.player.Player;
import domain.player.Players;
import domain.prize.Prize;
import domain.prize.Prizes;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class OutputView {
    private static final int EMPTY_COUNT = 1;
    private static final String EMPTY_SPACE = " ";
    private static final String DISCONNECTED_CHARACTER = " ";
    private static final String CONNECTED_CHARACTER = "-";
    private static final String LADDER_SIDE_CHARACTER = "|";

    private OutputView() {
    }

    public static void printLadder(Ladder ladder, Players players, Prizes prizes) {
        System.out.println("사다리 결과" + System.lineSeparator());
        int maxLength = Math.max(players.findMaxPlayerNameLength(), prizes.findMaxPrizeNameLength());
        printPlayerNames(players, maxLength);
        printLadder(ladder, maxLength);
        printPrizes(prizes, maxLength);
    }

    private static void printPlayerNames(Players players, int maxLength) {
        players.getPlayerNames().stream()
                .map(name -> alignCenter(name, maxLength + EMPTY_COUNT))
                .forEach(System.out::print);
        System.out.println();
    }

    private static String alignCenter(String name, int length) {
        int spaces = length - name.length();
        int left = spaces / 2;
        int right = spaces - left;
        return EMPTY_SPACE.repeat(left) + name + EMPTY_SPACE.repeat(right);
    }

    private static void printLadder(Ladder ladder, int maxLength) {
        ladder.getFloors()
                .stream()
                .map(Floor::getConnections)
                .forEach(connections ->
                        System.out.printf("%s%s%n", joinConnections(connections, maxLength), LADDER_SIDE_CHARACTER)
                );
    }

    private static String joinConnections(List<Connection> connections, int length) {
        return connections.stream()
                .map(connection -> formatConnection(connection, length))
                .collect(Collectors.joining(LADDER_SIDE_CHARACTER));
    }

    private static String formatConnection(Connection connection, int length) {
        if (connection.isLeft()) {
            return CONNECTED_CHARACTER.repeat(length);
        }
        return DISCONNECTED_CHARACTER.repeat(length);
    }

    private static void printPrizes(Prizes prizes, int maxLength) {
        prizes.getPrizeNames().stream()
                .map(prize -> alignCenter(prize, maxLength + EMPTY_COUNT))
                .forEach(System.out::print);
        System.out.println(System.lineSeparator());
    }

    public static void printErrorMessage(Exception e) {
        System.out.println(e.getMessage());
    }

    public static void printSinglePlayerResult(Prize prize) {
        System.out.println("실행 결과");
        System.out.println(prize.getName());
        System.out.println();
    }

    public static void printAllPlayerResult(Map<Player, Prize> results) {
        System.out.println("실행 결과");
        results.forEach((player, prize) -> System.out.printf("%s : %s%n", player.getName(), prize.getName()));
    }
}
