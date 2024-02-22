package view;

import domain.Ladder;
import domain.Line;
import domain.Players;
import domain.Stick;

import java.util.List;

public class OutputView {

    public void printLadder(Players players, Ladder ladder) {
        System.out.println("실행결과");

        printPLayerNames(players);
        printLadder(ladder);
    }

    private void printLadder(Ladder ladder) {
        List<Line> lines = ladder.getLines();

        for (Line line : lines) {
            System.out.print("     |");
            List<Stick> sticks = line.getSticks();
            for (Stick stick : sticks) {
                String shape = stick.getShape();
                System.out.print(shape.repeat(5));
                System.out.print("|");
            }
            System.out.println();
        }
    }

    private void printPLayerNames(Players players) {
        players.getPlayers().forEach(player -> {
            String name = player.getName();
            System.out.printf("%5s ", name);
        });

        System.out.println();
    }
}
