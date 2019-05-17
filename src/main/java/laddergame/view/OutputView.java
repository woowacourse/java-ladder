package laddergame.view;

import laddergame.domain.ladder.Ladder;
import laddergame.domain.player.Players;
import laddergame.domain.result.Destination;
import laddergame.domain.result.Destinations;

public class OutputView {

    private OutputView() {

    }

    private static void showMessageOfExecution() {
        System.out.println("실행 결과");
    }

    public static void showPlayers(Players players) {
        showMessageOfExecution();
        System.out.println(players);
    }

    public static void showLadder(Ladder ladder) {
        System.out.println(ladder);
    }

    public static void showDestinations(Destinations destinations) {
        System.out.println(destinations);
    }

    public static void showResult(Destination result) {
        showMessageOfExecution();
        System.out.println(result);
    }

    public static void showAllResult(Players players, Destinations destinations, Ladder ladder) {
        for (int i = 1; i <= players.getNumberOfPlayers(); i++) {
            System.out.print(players.getNameOfIndex(i));
            System.out.println("\t:\t" + destinations.getDestination(ladder.findDestinationPosition(i)));
        }
    }
}
