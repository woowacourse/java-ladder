package view;

import domain.Ladder;
import domain.Line;

import java.util.List;

public class ResultView {

    public static void printNames(String[] userNames) {
        StringBuilder stringBuilder = new StringBuilder();

        stringBuilder.append(String.format("%-5s", userNames[0]));

        for (int i = 1; i < userNames.length - 1; i++) {
            stringBuilder.append(String.format("%6s", userNames[i]));
        }
        stringBuilder.append(String.format("%5s", userNames[userNames.length - 1]));
        System.out.println(stringBuilder);
    }

    public static void printResult(Ladder ladder) {
        for (Line line : ladder.getLadder()) {
            System.out.print("    ");
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
