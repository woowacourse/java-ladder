package laddergame.controller;

import laddergame.domain.game.LadderGame;
import laddergame.domain.game.UserRequestedParticipants;
import laddergame.domain.ladder.Ladder;
import laddergame.domain.ladder.RandomBooleanGenerator;
import laddergame.domain.participant.Participant;
import laddergame.domain.participant.Participants;
import laddergame.domain.result.Result;
import laddergame.domain.result.Results;
import laddergame.view.InputView;
import laddergame.view.OutputView;

import java.util.Map;

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
        LadderGame ladderGame = new LadderGame(participants, ladder, results);

        ladderGame.playGameOfAllParticipants();

        print(participants, ladder, results);
        printGameResultUntilTheEnd(ladderGame, participants);
    }

    private Participants createParticipants() {
        return inputView.repeatUntilGettingValidValue(() -> {
            String participantNames = inputView.readParticipantNames();
            return Participants.create(participantNames);
        });
    }

    private Results createResults(final Participants participants) {
        return inputView.repeatUntilGettingValidValue(() -> {
            String resultNames = inputView.readResults();
            return new Results(resultNames, participants.size());
        });
    }

    private Ladder createLadder(final Participants participants) {
        RandomBooleanGenerator randomBooleanGenerator = new RandomBooleanGenerator();
        return inputView.repeatUntilGettingValidValue(() -> {
            String maxLadderHeight = inputView.readMaxLadderHeight();
            return new Ladder(randomBooleanGenerator, maxLadderHeight, participants.size());
        });
    }

    private void print(final Participants participants, final Ladder ladder, final Results results) {
        outputView.printLadderResultGuide();
        outputView.printParticipantNames(participants.getParticipants());
        outputView.printLadder(ladder.getLines(), participants.getParticipants());
        outputView.printResultNames(results.getResults());
    }

    private void printGameResultUntilTheEnd(final LadderGame ladderGame, final Participants participants) {
        do {
            Map<Participant, Result> resultByParticipants = readRequestAndGetResultByParticipants(ladderGame);
            outputView.printResultGuide();
            outputView.printResult(resultByParticipants, participants.getParticipants());
        } while (ladderGame.isContinuing());
    }

    private Map<Participant, Result> readRequestAndGetResultByParticipants(LadderGame ladderGame) {
        return inputView.repeatUntilGettingValidValue(() -> {
            UserRequestedParticipants request = UserRequestedParticipants.from(inputView.readRequest());
            return ladderGame.getResultByParticipants(request);
        });
    }
}
