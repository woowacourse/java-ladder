package view;

import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import model.*;

public class OutputView {
    private static final int PRINT_NAME_LENGTH_STANDARD = 5;
    private static final String NAME_DELIMITER = " ";
    private static final String LADDER_LINE_LENGTH = "|";
    private static final String LADDER_LINE_WIDTH_TRUE = "-----";
    private static final String LADDER_LINE_WIDTH_FALSE = "     ";

    public void printGame(Participants participants, Prizes prizes, Ladder ladder) {
        printLadderHeader();
        printParticipantsNames(participants);
        printLadder(ladder);
        printPrizesNames(prizes);
    }

    private void printLadderHeader() {
        System.out.println();
        System.out.println("사다리 결과");
        System.out.println();
    }

    private void printParticipantsNames(Participants participants) {
        String result = participants.getParticipants()
                .stream()
                .map(Participant::getName)
                .map(this::alignNameText)
                .collect(Collectors.joining(NAME_DELIMITER));
        System.out.println(result);
    }

    private void printLadder(Ladder ladder) {
        List<Line> lines = ladder.getLines();
        for (Line line : lines) {
            List<LineState> lineStates = line.getLineStates();
            StringBuilder result = getStringBuilder(lineStates);
            System.out.println(result);
        }
    }

    private void printPrizesNames(Prizes prizes) {
        String result = prizes.getPrizes()
                .stream()
                .map(Prize::getName)
                .map(this::alignNameText)
                .collect(Collectors.joining(NAME_DELIMITER));
        System.out.println(result);
    }

    public void printSoloResult(Prize prize) {
        System.out.println(prize.getName());
    }

    public void printResultAll(Map<Participant, Prize> gameResult) {
        for (Participant key : gameResult.keySet()) {
            String keyName = key.getName();
            String valueName = gameResult.get(key).getName();

            System.out.println(keyName + " : " + valueName);
        }
    }

    public void printResultHeader() {
        System.out.println();
        System.out.println("실행 결과");
    }

    private String alignNameText(String name) {
        if (name.length() < PRINT_NAME_LENGTH_STANDARD) {
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
