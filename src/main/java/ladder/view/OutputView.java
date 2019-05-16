package ladder.view;

import ladder.domain.Ladder;
import ladder.domain.Line;

public class OutputView {

    private static final String GAME_RESULT_MSG = "\n실행결과\n";
    private static final String LINE_COMPONENT = "|------";
    private static final String NONE_LINE_COMPONENT = "|      ";

    public static void printLadder(Ladder ladder) {
        System.out.println(GAME_RESULT_MSG);
        String[] names = ladder.getNames();
        for (String name : names) {
            System.out.printf("%-7s", name);
        }
        System.out.println();
        for (Line line : ladder.getLines()) {
            printLine(line);
        }
    }

    private static void printLine(Line line) {
        for (int point : line.getPoints()) {
            printLineComponent(point);
        }
        System.out.println();
    }

    private static void printLineComponent(int point) {
        if (point == 1) {
            System.out.print(LINE_COMPONENT);
            return;
        }
        System.out.print(NONE_LINE_COMPONENT);
    }
}
