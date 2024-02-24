package controller;

import java.util.List;
import java.util.function.Function;
import java.util.function.Supplier;
import model.Ladder;
import model.Participants;
import view.InputView;
import view.OutputView;

public class LadderController {
    private final InputView inputView;
    private final OutputView outputView;

    public LadderController(InputView inputView, OutputView outputView) {
        this.inputView = inputView;
        this.outputView = outputView;
    }

    public void run() {
        Participants participants = repeatUntilSuccess(this::prepareParticipants);
        Ladder ladder = repeatUntilSuccess(this::prepareLadder, participants);
        outputView.printParticipantsName(participants.captureParticipantsName());
        outputView.printLadder(ladder.captureLayerSteps());
    }

    private Participants prepareParticipants() {
        List<String> names = inputView.requestParticipantsName();
        return new Participants(names);
    }

    private Ladder prepareLadder(Participants participants) {
        int ladderHeight = inputView.requestLadderHeight();
        int numberOfParticipants = participants.getParticipantsSize();
        return new Ladder(ladderHeight, numberOfParticipants);
    }

    private <T> T repeatUntilSuccess(Supplier<T> supplier) {
        try {
            return supplier.get();
        } catch (IllegalArgumentException e) {
            outputView.printErrorMessage(e.getMessage());
            return repeatUntilSuccess(supplier);
        }
    }

    private <T, R> R repeatUntilSuccess(Function<T, R> function, T input) {
        try {
            return function.apply(input);
        } catch (IllegalArgumentException e) {
            outputView.printErrorMessage(e.getMessage());
            return repeatUntilSuccess(function, input);
        }
    }
}
