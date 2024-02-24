package controller;

import domain.Ladder;
import view.LineItem;
import domain.Line;
import domain.Participant;
import domain.Participants;
import util.LineItemGenerator;
import view.InputView;
import view.OutputView;
import java.util.ArrayList;
import java.util.List;

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
        Participants participants = prepareParticipants();
        Ladder ladder = new Ladder(inputView.inputHeight());

        ladder.makeLadder(participants.getParticipantsCount(), lineItemGenerator);
        printLadder(ladder, participants);
    }

    private Participants prepareParticipants() {
        String input = inputView.inputName();
        List<String> names = List.of(input.split(","));

        return new Participants(names);
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
        for (LineItem point : line.getPoints()) {
            stringBuilder.append(point.getShape());
        }
    }
}
