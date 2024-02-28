package controller;

import dto.ParticipantName;
import java.util.List;
import java.util.function.Function;
import java.util.function.Supplier;
import model.GameResults;
import model.Height;
import model.Ladder;
import model.Participants;
import model.Prizes;
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
        GameResults results = prepareGameResults(ladder, participants, prizes);

        printLadder(participants, ladder, prizes);
        printResult(participants, results);
    }

    private Participants prepareParticipants() {
        List<String> names = inputView.requestParticipantsName();
        return new Participants(names);
    }

    private Prizes preparePrizes(Participants participants) {
        List<String> prizes = inputView.requestPrizes();
        int numberOfParticipants = participants.getParticipantsSize();
        return new Prizes(prizes, numberOfParticipants);
    }

    private Ladder prepareLadder(Participants participants) {
        Height ladderHeight = new Height(inputView.requestLadderHeight());
        int numberOfParticipants = participants.getParticipantsSize();
        return new Ladder(ladderHeight, numberOfParticipants);
    }

    private void printLadder(Participants participants, Ladder ladder, Prizes prizes) {
        outputView.printParticipantsName(participants.convertToParticipantsNames());
        outputView.printLadder(ladder.convertToLayerSteps());
        outputView.printPrizeNames(prizes.convertToPrizesName());
    }

    private GameResults prepareGameResults(Ladder ladder, Participants participants, Prizes prizes) {
        return new GameResults(ladder, participants, prizes);
    }

    private void printResult(Participants participants, GameResults results) {
        while (true) {
            ParticipantName participantName = repeatUntilSuccess(this::prepareParticipantName, participants);
            resultView.printResult(results.convertToResultDto(), participantName);
        }
    }

    private ParticipantName prepareParticipantName(Participants participants) {
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
