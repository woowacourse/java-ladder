package view;

import domain.Ladder;
import domain.Line;

import java.util.List;

public class OutputView {

    public void printResult(List<String> participantsName, Ladder ladder) {
        System.out.println("\n실행결과\n");
        printNames(participantsName);
        printLadder(ladder);
    }

    private void printNames(List<String> participantsName) {
        for (String name : participantsName) {
            System.out.printf("%5s ", name);
        }
        System.out.println();
    }

    private void printLadder(Ladder ladder) {
        List<Line> lines = ladder.getLines();
        for (Line line : lines) {
            printOneLine(line);
        }
    }

    private void printOneLine(Line line) {
        List<Boolean> points = line.getPoints();
        System.out.print("    |");
        for (Boolean point : points) {
            printOnePoint(point);
        }
        System.out.println();
    }

    private void printOnePoint(Boolean point) {
        if (point) {
            System.out.print("-----|");
            return;
        }
        System.out.print("     |");
    }
}
