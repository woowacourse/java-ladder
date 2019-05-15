package ladder.view;

import ladder.domain.Ladder;
import ladder.domain.Line;

public class OutputView {
    public static void printLadder(Ladder ladder) {
        System.out.println("\n실행결과\n");
        String[] names = ladder.getNames();
        for (String name : names) {
            System.out.printf("%-7s", name);
        }
        System.out.println();
        for (Line line : ladder.getLines()) {
            for (boolean point : line.getPoints()){
                if(point){
                    System.out.print("|------");
                    continue;
                }
                System.out.print("|      ");
            }
            System.out.println("|");
        }
    }
}
