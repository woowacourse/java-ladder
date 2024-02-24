package controller;

import domain.Height;
import domain.Ladder;
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
        Height height = retryUntilSuccess(this::inputHeight);

        Ladder ladder = Ladder.of(height, participants.getParticipantsCount(), lineItemGenerator);
        printLadder(ladder, participants);
    }

    private Participants prepareParticipants() {
        String input = inputView.inputName();
        List<String> names = List.of(input.split(","));

        return new Participants(names);
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

    private void printLadder(Ladder ladder, Participants participants) {
        List<String> result = new ArrayList<>();
        List<Line> createdLadder = ladder.getLadder();

        createParticipantsLineUp(result, participants.getParticipants());
        createLadder(result, createdLadder);

        outputView.printResultMessage();
        outputView.printLadder(result);
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

    private void createLine(Line line, StringBuilder stringBuilder) {
        for (LineItem point : line.getLineItems()) {
            stringBuilder.append(point.getShape());
        }
    }
}
