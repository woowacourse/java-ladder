package ladder.view;

import ladder.domain.Result;
import ladder.domain.ladder.Ladder;
import ladder.domain.ladder.Line;
import ladder.domain.Participant;
import ladder.domain.ladder.LineDTO;

import java.util.HashMap;
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
        for (LineDTO lineDTO : ladder.getLineDTO()) {
            drawLine(lineDTO);
            System.out.println();
        }
    }

    private static void drawLine(LineDTO lineDTO) {
        for (Boolean t : lineDTO.getPoints()) {
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

    public static void printGameResult(Result result){
        result.getResult(InputView.inputResultNames()).entrySet().stream()
                .forEach(entry -> printResult(entry.getKey(), entry.getValue()));

    }
    public static void printResult(String name, String reward){
        System.out.println(name + " : " + reward);
    }

}
