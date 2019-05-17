package ladder.view;

import ladder.domain.Ladder;
import ladder.domain.Line;

import java.util.List;
import java.util.Map;

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

    public static void printItems(List<String> items) {
        for (String item : items) {
            System.out.printf("%6s", item);
        }
        System.out.println();
    }

    public static void printResult(List<String> names, List<String> result, String participant) {
        System.out.println("실행 결과");
        if (participant.equals("all")) {
            for (int i = 0; i < names.size(); i++) {
                System.out.println(names.get(i) + " : " + result.get(i));
            }
        } else {
            System.out.println(participant + " : " + result.get(names.indexOf(participant)));
        }
    }
}
