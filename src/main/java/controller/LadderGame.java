package controller;

import domain.*;
import util.BooleanGenerator;
import view.InputView;
import view.LadderShape;
import view.OutputView;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class LadderGame {

    private static final String OUTPUT_FORMAT = "%5s ";

    private final InputView inputView;
    private final OutputView outputView;
    private final BooleanGenerator booleanGenerator;

    public LadderGame(InputView inputView, OutputView outputView, BooleanGenerator booleanGenerator) {
        this.inputView = inputView;
        this.outputView = outputView;
        this.booleanGenerator = booleanGenerator;
    }

    public void start() {
        Participants participants = new Participants(inputName());
        Results results = new Results(inputView.inputResults(), participants.getParticipantsCount());
        Ladder ladder = new Ladder(inputView.inputHeight());

        ladder.makeLadder(participants.getParticipantsCount(), booleanGenerator);
        printLadder(ladder, participants, results);

        ladder.playLadder(results, participants);

        printLadderGameResult(participants, results);
    }

    private List<String> inputName() {
        String input = inputView.inputName();

        return List.of(input.split(","));
    }

    private void printLadder(Ladder ladder, Participants participants, Results results) {
        printParticipantsLineUp(participants);
        printLadderOutput(ladder);
        printResultsOutput(results);
    }

    private void printParticipantsLineUp(Participants participants) {
        StringBuilder stringBuilder = new StringBuilder();

        for (int initPosition = 0; initPosition < participants.getParticipantsCount(); initPosition++) {
            String name = participants.findParticipantByInitPosition(initPosition).getName();

            stringBuilder.append(String.format(OUTPUT_FORMAT, name));
        }

        outputView.printParticipantLineUp(stringBuilder.toString());
    }

    private void printLadderOutput(Ladder ladder) {
        List<String> output = new ArrayList<>();

        for (Line line : ladder.getLadder()) {
            StringBuilder stringBuilder = new StringBuilder();
            stringBuilder.append("    |");

            createLineOutput(line, stringBuilder);

            output.add(stringBuilder.toString());
        }

        outputView.printLadderOutput(output);
    }

    private void createLineOutput(Line line, StringBuilder stringBuilder) {
        for (LadderItem point : line.getPoints()) {
            stringBuilder.append(LadderShape.getShapeByLadderItem(point));
        }
    }

    private void printResultsOutput(Results results) {
        StringBuilder stringBuilder = new StringBuilder();

        for (String gameResult : results.getResults()) {
            stringBuilder.append(String.format(OUTPUT_FORMAT, gameResult));
        }

        outputView.printResultsOutput(stringBuilder.toString());
    }

    private void printLadderGameResult(Participants participants, Results results) {
        boolean keepInput = true;

        while (keepInput) {
            String name = inputView.inputResultName();

            keepInput = !name.isEmpty();

            if (keepInput) {
                outputView.printResultsOutput(getLadderGameResult(name, participants, results));
            }
        }
    }

    private String getLadderGameResult(String name, Participants participants, Results results) {
        if (name.equals("all")) {
            return getAllResult(results);
        }

        return results.getResultByParticipant(participants.findParticipantByName(name));
    }

    private String getAllResult(Results results) {
        List<String> allResult = new ArrayList<>();

        for (Map.Entry<Participant, String> result : results.getParticipantsResult().entrySet()) {
            allResult.add(result.getKey().getName() + " : " + result.getValue());
        }

        return String.join("\n", allResult);
    }
}
