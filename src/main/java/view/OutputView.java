package view;

import java.util.List;
import java.util.stream.Collectors;
import model.Ladder;
import model.Line;
import model.LineState;
import model.Participant;
import model.Participants;

public class OutputView {
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
        if (name.length() < 5) {
            return String.format("%4s ", name);
        }
        return name;
    }

    private StringBuilder getStringBuilder(List<LineState> lineStates) {
        StringBuilder result = new StringBuilder("    ");
        for (int i = 0; i < lineStates.size() - 1; i++) {
            LineState now = lineStates.get(i);
            result.append("|");
            String text = getDelimiterByState(now);
            result.append(text);
        }
        result.append("|");
        return result;
    }

    private String getDelimiterByState(LineState now) {
        if (now == LineState.START) {
            return "-----";
        }
        return "     ";
    }

    public void printErrorMessage(String message) {
        System.out.println(message);
    }
}
