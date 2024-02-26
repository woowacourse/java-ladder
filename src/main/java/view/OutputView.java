package view;

import java.util.List;
import java.util.stream.Collectors;
import model.Ladder;
import model.Line;
import model.LineState;
import model.Participant;
import model.Participants;

public class OutputView {
    private final int PRINT_NAME_FORMAT = 5;
    private final String LADDER_LINE_LENGTH = "|";
    private final String LADDER_LINE_WIDTH_TRUE = "-----";
    private final String LADDER_LINE_WIDTH_FALSE = "     ";

    public void printResultHeader() {
        System.out.println();
        System.out.println("실행결과");
        System.out.println();
    }

    public void printParticipantsNames(Participants participants) {
        String result = participants.getParticipants()
                .stream()
                .map(Participant::getName)
                .map(this::alignNameText)
                .collect(Collectors.joining(" "));
        System.out.println(result);
    }

    public void printLadder(Ladder ladder) {
        List<Line> lines = ladder.getLines();
        for (Line line : lines) {
            List<LineState> lineStates = line.getLineStates();
            StringBuilder result = getStringBuilder(lineStates);
            System.out.println(result);
        }
    }

    private String alignNameText(String name) {
        if (name.length() < PRINT_NAME_FORMAT) {
            return String.format("%4s ", name);
        }
        return name;
    }

    private StringBuilder getStringBuilder(List<LineState> lineStates) {
        StringBuilder result = new StringBuilder("    ");
        for (int i = 0; i < lineStates.size() - 1; i++) {
            LineState now = lineStates.get(i);
            result.append(LADDER_LINE_LENGTH);
            String text = getDelimiterByState(now);
            result.append(text);
        }
        result.append(LADDER_LINE_LENGTH);
        return result;
    }

    private String getDelimiterByState(LineState now) {
        if (now == LineState.START) {
            return LADDER_LINE_WIDTH_TRUE;
        }
        return LADDER_LINE_WIDTH_FALSE;
    }

    public void printErrorMessage(String message) {
        System.out.println(message);
    }
}
