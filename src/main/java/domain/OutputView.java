package domain;

import java.util.List;

public class OutputView {
    public void printResult(Players rawPlayers, List<Line> lines) {
        System.out.println("실행결과");
        printNames(rawPlayers);
        printLadder(lines);
    }

    private void printLadder(List<Line> lines) {
        String bar = "|";
        String lineForm = "";

        for (Line line : lines) {
            String form = "";
            form = form + "    ";
            List<Point> points = line.getPoints();

            for (Point point : points) {
                String step = "";
                if (point.isHasStep()) {
                    step = "-----";
                }
                if (!point.isHasStep()) {
                    step = "     ";
                }
                form = form + bar + step;
            }
            lineForm = lineForm + form + System.lineSeparator();
        }
        System.out.println(lineForm);
    }

    private static void printNames(Players rawPlayers) {
        List<Player> players = rawPlayers.getPlayers();
        String form = "";
        for (Player player : players) {
            String name = player.getName();
            if (name.length() < 5) {
                String leftBlank = " ".repeat(4 - name.length());
                String rightBalnk = " ";
                name = leftBlank + name + rightBalnk;
            }
            name = name + " ";
            form = form + name;
        }
        System.out.println(form);
    }
}
