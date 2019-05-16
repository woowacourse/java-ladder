package ladder.view;

import ladder.domain.Ladder;
import ladder.domain.Line;

import java.util.List;

public class OutputView {
    public static void printNames(List<String> names) {
        System.out.println("실행 결과\n");

        for (String name : names) {
            System.out.printf("%6s", name);
        }
        System.out.println();
    }

    public static void printLadder(Ladder ladder) {
        int height = ladder.getHeight();
        int numberOfPeople = ladder.getNumberOfPeople();

        for (int i = 0; i < height; i++) {
            Line line = ladder.getLine(i);
            StringBuilder stringBuilder = new StringBuilder();
            stringBuilder.append("     ");

            for (int j = 0; j < numberOfPeople - 1; j++) {
                stringBuilder.append("|");

                if (line.isConnected(j)) {
                    stringBuilder.append("-----");
                }
                if (!line.isConnected(j)) {
                    stringBuilder.append("     ");
                }
            }

            stringBuilder.append("|");
            System.out.println(stringBuilder.toString());
        }
    }
}
