package controller;

import domain.*;
import domain.ladder.Ladder;
import util.BooleanGenerator;
import view.Command;
import view.InputView;
import view.OutputView;

public class LadderGameController {

    private final BooleanGenerator booleanGenerator;
    private final InputView inputView;
    private final OutputView outputView;

    public LadderGameController(BooleanGenerator booleanGenerator, InputView inputView, OutputView outputView) {
        this.booleanGenerator = booleanGenerator;
        this.inputView = inputView;
        this.outputView = outputView;
    }

    public void run() {
        Players players = saveNames();
        Goals goals = saveGoals(players.count());
        Ladder ladder = buildLadder(players, goals);

        printLadder(ladder);
        rideLadder(ladder);
    }

    private void rideLadder(Ladder ladder) {
        try {
            String participantName = getNameToRide();
            if (participantName.equals(Command.ALL.getCommand())) {
                rideAllLadder(ladder);
                return;
            }
            rideLadderByParticipantName(participantName, ladder);
            rideLadder(ladder);
        } catch (IllegalArgumentException e) {
            outputView.printErrorMessage(e.getMessage());
            rideLadder(ladder);
        }
    }

    private String getNameToRide() {
        outputView.printRequestNameToRide();
        return inputView.getName();
    }

    private void rideAllLadder(Ladder ladder) {
        for (String name : ladder.getNames().getNames()) {
            rideLadderByParticipantName(name, ladder);
        }
    }

    private void rideLadderByParticipantName(String participantName, Ladder ladder) {
        String goalName = ladder.ride(participantName);
        outputView.printResult(participantName, goalName);
    }

    private Goals saveGoals(int participantsSize) {
        try {
            outputView.printRequestGoals();
            return Goals.of(participantsSize, inputView.getGoals());
        } catch (IllegalArgumentException e) {
            outputView.printErrorMessage(e.getMessage());
            return saveGoals(participantsSize);
        }
    }

    private Ladder buildLadder(final Players players, final Goals goals) {
        Height height = saveHeight();
        Ladder ladder = Ladder.of(booleanGenerator, players, goals);
        ladder.build(height, players.count());
        return ladder;
    }

    private void printLadder(final Ladder ladder) {
        outputView.printLadder(ladder.getNames(), ladder, ladder.getGoals());
    }

    private Players saveNames() {
        try {
            outputView.printRequestNames();
            return Players.ofValues(inputView.getNames());
        } catch (IllegalArgumentException e) {
            outputView.printErrorMessage(e.getMessage());
            return saveNames();
        }
    }

    private Height saveHeight() {
        try {
            outputView.printRequestLadderHeight();
            return Height.of(inputView.getHeight());
        } catch (IllegalArgumentException e) {
            outputView.printErrorMessage(e.getMessage());
            return saveHeight();
        }
    }
}
