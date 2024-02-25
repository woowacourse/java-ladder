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
        List<String> output = new ArrayList<>();
        List<Line> createdLadder = ladder.getLadder();

        createParticipantsLineUp(output, participants.getParticipants());
        createLadderOutput(output, createdLadder);
        createResultsOutput(output, results);

        outputView.printLadder(output);
    }

    private void createParticipantsLineUp(List<String> result, List<Participant> participants) {
        StringBuilder stringBuilder = new StringBuilder();
        for (Participant participant : participants) {
            stringBuilder.append(String.format("%5s ", participant.getName()));
        }

        result.add(stringBuilder.toString());
    }

    private void createLadderOutput(List<String> result, List<Line> createdLadder) {
        for (Line line : createdLadder) {
            StringBuilder stringBuilder = new StringBuilder();
            stringBuilder.append("    |");

            createLine(line, stringBuilder);

            result.add(stringBuilder.toString());
        }
    }

    private void createLine(Line line, StringBuilder stringBuilder) {
        for (LadderItem point : line.getPoints()) {
            stringBuilder.append(LadderShape.getShapeByLadderItem(point));
        }
    }

    private void createResultsOutput(List<String> result, Results results) {
        StringBuilder stringBuilder = new StringBuilder();

        for (String gameResult : results.getResults()) {
            stringBuilder.append(String.format("%5s ", gameResult));
        }

        result.add(stringBuilder.toString());
    }

    private void printLadderGameResult(Participants participants, Results results) {
        String name = inputView.inputResultName();
        String result = "";

        if (!name.equals("all")) {
            result = results.getResultByParticipantName(participants.findParticipantByName(name));
        }

        if (name.equals("all")) {
            result = getAllResult(results);
        }

        outputView.printResult(result);
    }

    private String getAllResult(Results results) {
        List<String> allResult = new ArrayList<>();

        for (Map.Entry<Participant, String> result : results.getParticipantsResult().entrySet()) {
            allResult.add(result.getKey().getName() + " : " + result.getValue());
        }

        return String.join("\n", allResult);
    }
}
