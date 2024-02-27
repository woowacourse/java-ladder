package view;

import domain.*;

import java.util.List;

public class OutputView {

    public void printLadder(Players players, Ladder ladder) {
        System.out.println("실행결과");

        printPlayerNames(players);
        printLadder(ladder);
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
}
