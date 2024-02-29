package controller;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Function;
import java.util.function.Supplier;
import model.ExecutionResult;
import model.Ladder;
import model.Participants;
import model.ResultInterestedPeople;
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

        outputView.printParticipantsName(captureParticipantsName(participants));
        outputView.printLadder(captureLayerSteps(ladder));
        outputView.printExecutionResultBottomLadder(executionResult);

        gamePrepare(participants, ladder, executionResult);
    }

    private void gamePrepare(Participants participants, Ladder ladder, ExecutionResult executionResult) {
        ResultInterestedPeople resultInterestedPeople =
                repeatUntilSuccess(this::prepareResultInterestedPeople, captureParticipantsName(participants));
        if (resultInterestedPeople.getResultInterestedName().size() != participants.getParticipantsSize()) {
            gameStart(resultInterestedPeople, ladder, executionResult);
            gamePrepare(participants, ladder, executionResult);
            return;
        }
        gameStart(resultInterestedPeople, ladder, executionResult);
    }

    private void gameStart(ResultInterestedPeople resultInterestedPeople, Ladder ladder,
                           ExecutionResult executionResult) {
        resultInterestedPeople.forEachPosition(position -> {
            int positionResult = ladder.move(position);
            String result = executionResult.getExecutionResult().get(positionResult);
            resultInterestedPeople.actualExecutionResult(result);
        });
        outputView.printExecutionResult(resultInterestedPeople);
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
        List<String> resultInterestedPeople = inputView.requestResultInterestedPeople();
        List<String> formattedParticipantsName = participantsNames.stream()
                .map(ParticipantName::name)
                .toList();
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
