package laddergame.controller;

import laddergame.domain.game.LadderGame;
import laddergame.domain.game.UserRequest;
import laddergame.domain.ladder.Ladder;
import laddergame.domain.ladder.RandomBooleanGenerator;
import laddergame.domain.participant.Participant;
import laddergame.domain.participant.Participants;
import laddergame.domain.result.Result;
import laddergame.domain.result.Results;
import laddergame.view.InputView;
import laddergame.view.OutputView;

import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class LadderGameController {

    private final InputView inputView;
    private final OutputView outputView;

    public LadderGameController(final InputView inputView, final OutputView outputView) {
        this.inputView = inputView;
        this.outputView = outputView;
    }

    public void start() {
        Participants participants = createParticipants();
        Results results = createResults(participants);
        Ladder ladder = createLadder(participants);

        outputView.printLadderResultGuide();
        List<String> participantNames = getParticipantNames(participants);
        outputView.printParticipantNames(participantNames);
        outputView.printLadder(ladder.getLines(), participantNames);
        List<String> resultNames = getResultNames(results);
        outputView.printResultNames(resultNames);

        LadderGame ladderGame = new LadderGame(participants, ladder, results);
        ladderGame.playGameOfAllParticipants();


        do {
            Map<Participant, Result> resultByParticipants = createRequest(ladderGame);
            outputView.printResultGuide();
            outputView.printResult(resultByParticipants, participants.getAllParticipants());
        } while (ladderGame.isContinuing());
    }

    private Participants createParticipants() {
        return inputView.repeatUntilGettingValidValue(() -> {
            String participantNames = inputView.readParticipantNames();
            return Participants.create(participantNames);
        });
    }

    private Ladder createLadder(final Participants participants) {
        RandomBooleanGenerator randomBooleanGenerator = new RandomBooleanGenerator();
        return inputView.repeatUntilGettingValidValue(() -> {
            String maxLadderHeight = inputView.readMaxLadderHeight();
            return Ladder.create(randomBooleanGenerator, maxLadderHeight, participants.size());
        });
    }

    private Results createResults(final Participants participants) {
        return inputView.repeatUntilGettingValidValue(() -> {
            String resultNames = inputView.readResults();
            return new Results(resultNames, participants.size());
        });
    }

    private Map<Participant, Result> createRequest(LadderGame ladderGame) {
        return inputView.repeatUntilGettingValidValue(() -> {
            UserRequest request = UserRequest.of(inputView.readRequest());
            return ladderGame.getResultByParticipants(request);
        });
    }

    private List<String> getParticipantNames(final Participants participants) {
        return participants.getParticipants().stream()
                .map(Participant::getName)
                .collect(Collectors.toUnmodifiableList());
    }

    private List<String> getResultNames(final Results results) {
        return results.getResultNames();
    }
}
