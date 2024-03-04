package controller;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Function;
import java.util.function.Supplier;
import model.ExecutionResult;
import model.Ladder;
import model.LadderGame;
import model.Participants;
import model.ResultInterestedPeople;
import model.dto.GamePrize;
import model.dto.LayerSteps;
import model.dto.ParticipantName;
import model.vo.Height;
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
        ExecutionResult executionResult = repeatUntilSuccess(this::prepareExecutionResult, participants);
        Ladder ladder = repeatUntilSuccess(this::prepareLadder, participants);
        printCreatedLadderGame(participants, ladder, executionResult);

        ResultInterestedPeople resultInterestedPeople =
                repeatUntilSuccess(this::prepareResultInterestedPeople, captureParticipantsName(participants));

        LadderGame ladderGame = new LadderGame(ladder, executionResult);
        ladderGame.gameStart(captureParticipantsName(participants));
        outputView.printExecutionResult(resultInterestedPeople, new GamePrize(ladderGame));
    }

    private void printCreatedLadderGame(Participants participants, Ladder ladder, ExecutionResult executionResult) {
        outputView.printParticipantsName(captureParticipantsName(participants));
        outputView.printLadder(captureLayerSteps(ladder));
        outputView.printExecutionResultBottomLadder(executionResult);
    }

    private Participants prepareParticipants() {
        List<String> names = inputView.requestParticipantsName();
        return new Participants(names);
    }

    private ExecutionResult prepareExecutionResult(Participants participants) {
        List<String> executionResult = inputView.requestExecutionResult();
        int numberOfParticipants = participants.getParticipantsSize();
        return new ExecutionResult(executionResult, numberOfParticipants);
    }

    private Ladder prepareLadder(Participants participants) {
        Height height = new Height(inputView.requestLadderHeight());
        int numberOfParticipants = participants.getParticipantsSize();
        return new Ladder(height.getValue(), numberOfParticipants);
    }

    private ResultInterestedPeople prepareResultInterestedPeople(List<ParticipantName> participantsNames) {
        List<String> formattedParticipantsName = participantsNames.stream()
                .map(ParticipantName::name)
                .toList();
        List<String> resultInterestedPeople = inputView.requestResultInterestedPeople(participantsNames);
        return new ResultInterestedPeople(resultInterestedPeople, formattedParticipantsName);
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

    private List<ParticipantName> captureParticipantsName(Participants participants) {
        List<ParticipantName> participantNames = new ArrayList<>();
        participants.forEachParticipant(
                participant -> participantNames.add(new ParticipantName(participant)));
        return participantNames;
    }

    private List<LayerSteps> captureLayerSteps(Ladder ladder) {
        List<LayerSteps> layerSteps = new ArrayList<>();
        ladder.forEachLayer(layer -> layerSteps.add(new LayerSteps(layer)));
        return layerSteps;
    }
}
