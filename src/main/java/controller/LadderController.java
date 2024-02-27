package controller;

import dto.ParticipantName;
import java.util.List;
import java.util.function.Function;
import java.util.function.Supplier;
import model.Height;
import model.Ladder;
import model.Participants;
import model.Prizes;
import model.Results;
import view.InputView;
import view.OutputView;
import view.ResultView;

public class LadderController {
    private final InputView inputView;
    private final OutputView outputView;
    private final ResultView resultView;

    public LadderController(InputView inputView, OutputView outputView, ResultView resultView) {
        this.inputView = inputView;
        this.outputView = outputView;
        this.resultView = resultView;
    }

    public void run() {
        Participants participants = repeatUntilSuccess(this::prepareParticipants);
        Prizes prizes = repeatUntilSuccess(this::preparePrizes, participants);
        Ladder ladder = repeatUntilSuccess(this::prepareLadder, participants);
        outputView.printParticipantsName(participants.captureParticipantsName());
        outputView.printLadder(ladder.captureLayerSteps());
        outputView.printPrizeNames(prizes.capturePrizesName());

        Results results = new Results(ladder, participants);
        ParticipantName participantName = repeatUntilSuccess(this::prepareParticipant, participants);
        resultView.printResult(results.captureResult(), participantName, prizes.capturePrizesName());
    }

    private Participants prepareParticipants() {
        List<String> names = inputView.requestParticipantsName();
        return new Participants(names);
    }

    private Ladder prepareLadder(Participants participants) {
        Height ladderHeight = new Height(inputView.requestLadderHeight());
        int numberOfParticipants = participants.getParticipantsSize();
        return new Ladder(ladderHeight, numberOfParticipants);
    }

    private Prizes preparePrizes(Participants participants) {
        List<String> prizes = inputView.requestPrizes();
        int numberOfParticipants = participants.getParticipantsSize();
        return new Prizes(prizes, numberOfParticipants);
    }

    private ParticipantName prepareParticipant(Participants participants) {
        String name = inputView.requestFindName();
        return participants.findByName(name);
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
