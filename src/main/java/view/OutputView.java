package view;

import domain.ladder.Ladder;
import domain.ladder.Line;
import domain.ladder.Stick;
import domain.player.Player;
import domain.player.Players;
import domain.result.Result;
import domain.result.Results;

import java.util.List;

public class OutputView {

    public void printLadder(Players players, Ladder ladder, Results results) {
        System.out.println("사다리 결과");

        printPlayerNames(players);
        printLadder(ladder);
        printResults(results);
    }

    public void printError(String message) {
        System.out.printf("[ERROR] %s%n", message);
    }

    private void printPlayerNames(Players players) {
        players.getPlayers().forEach(this::printEachPlayerName);

        System.out.println();
    }

    private void printEachPlayerName(Player player) {
        System.out.printf("%5s ", player.getName());
    }

    private void printLadder(Ladder ladder) {
        ladder.getLines().forEach(this::printLine);
    }

    private void printLine(Line line) {
        StringBuilder sb = new StringBuilder();
        List<Stick> sticks = line.getSticks();
        for (Stick stick : sticks) {
            String shape = stick.getShape();
            sb.append(shape.repeat(5));
            sb.append("|");
        }

        System.out.printf("     |%s%n", sb);
    }

    private void printResults(Results results) {
        results.getResults().forEach(this::printEachResultValue);
    }

    private void printEachResultValue(Result result) {
        System.out.printf("%5s ", result.getValue());
    }

}
