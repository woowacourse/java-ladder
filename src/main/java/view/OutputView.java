package view;

import java.util.List;
import java.util.stream.Collectors;

import model.*;

public class OutputView {
    private static final int PRINT_NAME_FORMAT = 5;
    private static final String DELIMITER = " ";
    private static final String LADDER_LINE_LENGTH = "|";
    private static final String LADDER_LINE_WIDTH_TRUE = "-----";
    private static final String LADDER_LINE_WIDTH_FALSE = "     ";

    public void printLadderHeader() {
        System.out.println();
        System.out.println("사다리 결과");
        System.out.println();
    }

    public void printParticipantsNames(Participants participants) {
        String result = participants.getParticipants()
                .stream()
                .map(Participant::getName)
                .map(this::alignNameText)
                .collect(Collectors.joining(DELIMITER));
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

    public void printPrizesNames(Prizes prizes) {
        String result = prizes.getPrizes()
                .stream()
                .map(Prize::getName)
                .map(this::alignNameText)
                .collect(Collectors.joining(DELIMITER));
        System.out.println(result);
    }

    public void printSoloResult(Prize prize) {
        System.out.println(prize.getName());
    }

    public void printEntireResult(Participants participants, List<Prize> prizes) {
        for (int i = 0; i < participants.getSize(); i++) {
            System.out.println(
                    participants.getParticipants().get(i).getName() + " : " + prizes.get(i).getName());
        }
    }

    public void printResultHeader() {
        System.out.println();
        System.out.println("실행 결과");
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
