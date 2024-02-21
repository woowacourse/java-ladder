package view;

import domain.Ladder;
import domain.Line;

import java.util.List;

public class OutputView {

    public void printResult(List<String> participantsName, Ladder ladder) {
        System.out.println("\n실행결과\n");
        for (String name : participantsName) {
            System.out.printf("%5s ", name);
        }
        System.out.println();

        List<Line> lines = ladder.getLines();
        for (Line line : lines) {
            List<Boolean> points = line.getPoints();
            System.out.print("    |");
            for (Boolean point : points) {
                if (point) {
                    System.out.print("-----|");
                    continue;
                }
                System.out.print("     |");
            }
            System.out.println();
        }
    }
}
