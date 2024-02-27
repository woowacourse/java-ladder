package controller;

import domain.Height;
import domain.Ladder;
import domain.LadderResults;
import domain.Line;
import domain.Participant;
import domain.Participants;
import view.LineItem;
import util.LineItemGenerator;
import view.InputView;
import view.OutputView;
import java.util.ArrayList;
import java.util.List;
import java.util.function.Supplier;

public class LadderGame {

    private final InputView inputView;
    private final OutputView outputView;
    private final LineItemGenerator lineItemGenerator;

    public LadderGame(InputView inputView, OutputView outputView, LineItemGenerator lineItemGenerator) {
        this.inputView = inputView;
        this.outputView = outputView;
        this.lineItemGenerator = lineItemGenerator;
    }

    public void start() {
        Participants participants = retryUntilSuccess(this::prepareParticipants);
        LadderResults ladderResults = retryUntilSuccess(() -> inputLadderResults(participants.getParticipantsCount()));
        Height height = retryUntilSuccess(this::inputHeight);

        Ladder ladder = Ladder.of(height, participants.getParticipantsCount(), lineItemGenerator);
        printLadder(ladder, participants, ladderResults);

        printLadderGameResult(ladder, participants, ladderResults);
    }

    private Participants prepareParticipants() {
        String input = inputView.inputName();
        List<String> names = List.of(input.split(","));

        return new Participants(names);
    }

    private LadderResults inputLadderResults(int columnLength) {
        String input = inputView.inputLadderResults();
        List<String> ladderResults = List.of(input.split(","));
        return new LadderResults(ladderResults, columnLength);
    }

    private Height inputHeight() {
        return new Height(inputView.inputHeight());
    }

    private <T> T retryUntilSuccess(Supplier<T> supplier) {
        while (true) {
            try {
                return supplier.get();
            } catch (IllegalArgumentException e) {
                System.out.println(e.getMessage());
            }
        }
    }

    private void printLadder(Ladder ladder, Participants participants, LadderResults ladderResults) {
        List<String> result = new ArrayList<>();
        List<Line> createdLadder = ladder.getLadder();

        createParticipantsLineUp(result, participants.getParticipants());
        createLadder(result, createdLadder);
        createLadderResults(result, ladderResults.getLadderResults());

        outputView.printLadderResultMessage();
        outputView.printLadder(result);
    }

    private void printLadderGameResult(Ladder ladder, Participants participants, LadderResults ladderResults) {
        String resultName = inputView.inputResultName();

        outputView.printResultMessage();
        if (resultName.equals("all")) {
            for (Participant participant : participants.getParticipants()) {
                String name = participant.getName();
                int playerPosition = participants.findIndexOfParticipant(name);
                int resultPosition = ladder.playLadderGame(playerPosition);
                System.out.println(name + " : " + ladderResults.findLadderResultByPosition(resultPosition));
            }
            return;
        }

        int playerPosition = participants.findIndexOfParticipant(resultName);
        int resultPosition = ladder.playLadderGame(playerPosition);
        System.out.println(ladderResults.findLadderResultByPosition(resultPosition));
    }

    private void createParticipantsLineUp(List<String> result, List<Participant> participants) {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("\n");
        for (Participant participant : participants) {
            stringBuilder.append(String.format("%5s ", participant.getName()));
        }

        result.add(stringBuilder.toString());
    }

    private void createLadder(List<String> result, List<Line> createdLadder) {
        for (Line line : createdLadder) {
            StringBuilder stringBuilder = new StringBuilder();
            stringBuilder.append("    |");

            createLine(line, stringBuilder);

            result.add(stringBuilder.toString());
        }
    }

    private void createLadderResults(List<String> result, List<String> ladderResults) {
        StringBuilder stringBuilder = new StringBuilder();
        for (String ladderResult : ladderResults) {
            stringBuilder.append(String.format("%5s ", ladderResult));
        }

        result.add(stringBuilder.toString());
    }

    private void createLine(Line line, StringBuilder stringBuilder) {
        for (LineItem point : line.getLineItems()) {
            stringBuilder.append(point.getShape());
        }
    }
}
