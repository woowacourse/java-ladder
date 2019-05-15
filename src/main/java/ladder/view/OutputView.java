package ladder.view;

import ladder.domain.Ladder;
import ladder.domain.Line;
import ladder.domain.Participant;

import java.util.List;

public class OutputView {
    private static final String VERTICAL_LINE = "-----";
    private static final String VERTICAL_EMPTY = "     ";
    private static final String HORIZONTAL_LINE = "|";
    private static final int  NAME_CONTAINER_WIDTH = 6;
    public static void printLadderResult(Ladder ladder, List<Participant> participants) {
        drawName(participants);
        drawLadder(ladder);
    }

    private static void drawName(List<Participant> participants) {
        participants.stream().forEach(x -> System.out.print(x.toString() + nameBlank(x.toString().length())));
        System.out.println();
    }

    public static void drawLadder(Ladder ladder) {
        for (Line line : ladder.getLines()) {
            drawLine(line);
            System.out.println();
        }
    }

    private static void drawLine(Line line) {
        for (Boolean t : line.getPoints()) {
            System.out.print(HORIZONTAL_LINE);
            lineOrEmpty(t);
        }
    }

    private static void lineOrEmpty(boolean isPoint) {
        if (isPoint) System.out.print(VERTICAL_LINE);
        else System.out.print(VERTICAL_EMPTY);
    }


    public static String nameBlank(int nameLength) {
        StringBuilder blank = new StringBuilder();
        for (int i = 0; i < NAME_CONTAINER_WIDTH - nameLength; i++) {
            blank.append(" ");
        }
        return blank.toString();
    }
}
