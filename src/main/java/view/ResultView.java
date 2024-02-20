package view;

import domain.Ladder;
import domain.Line;

import java.util.List;

public class ResultView {

    public static void printNames(String[] userNames) {
        StringBuilder stringBuilder = new StringBuilder();

        for (String name : userNames) {
            stringBuilder.append(String.format("%5s", name));
        }
        System.out.println(stringBuilder);
        System.out.println();
    }

    public static void printResult(Ladder ladder) {
        for (Line line : ladder.getLadder()) {
            System.out.print("|");
            for (Boolean point : line.getPoints()) {
                if(point){
                    System.out.print("-".repeat(5));
                    System.out.print("|");
                    continue;
                }
                System.out.print(" ".repeat(5));
                System.out.print("|");
            }
            System.out.println();
        }
    }
}
