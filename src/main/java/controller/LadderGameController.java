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
        Names names = saveNames();
        Goals goals = saveGoals(names.count());
        Ladder ladder = buildLadder(names, goals);

        printLadder(ladder);
        rideLadder(ladder, names);
    }

    private void rideLadder(Ladder ladder, Names names) {
        String participantName = getNameToRide();
        if (participantName.equals(Command.ALL.getCommand())) {
            rideAllLadder(ladder);
            return;
        }
        if (!names.has(participantName)) {
            outputView.printErrorMessage("등록되지 않은 사용자 이름입니다.");
            rideLadder(ladder, names);
            return;
        }
        rideLadderByParticipantName(participantName, ladder);
        rideLadder(ladder, names);
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

    private Ladder buildLadder(final Names names, final Goals goals) {
        Height height = saveHeight();
        Ladder ladder = Ladder.of(booleanGenerator, names, goals);
        ladder.build(height, names.count());
        return ladder;
    }

    private void printLadder(final Ladder ladder) {
        outputView.printLadder(ladder.getNames(), ladder, ladder.getGoals());
    }

    private Names saveNames() {
        try {
            outputView.printRequestNames();
            return Names.ofValues(inputView.getNames());
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
