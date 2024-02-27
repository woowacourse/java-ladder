package ladder.controller;

import ladder.domain.generator.LadderStepGenerator;
import ladder.domain.generator.RandomLadderStepGenerator;
import ladder.domain.ladder.Height;
import ladder.domain.ladder.Ladder;
import ladder.domain.result.GameResults;
import ladder.domain.result.LadderGamePrize;
import ladder.domain.participant.Participants;
import ladder.domain.result.PersonalGameResult;
import ladder.exception.ExceptionHandler;
import ladder.view.InputView;
import ladder.view.OutputView;

import java.util.List;
import java.util.Objects;

public class LadderGame {
    private static final String FINISH_COMMAND = "all";

    private final InputView inputView;
    private final OutputView outputView;
    private final ExceptionHandler exceptionHandler;

    public LadderGame(
            final InputView inputView,
            final OutputView outputView,
            final ExceptionHandler exceptionHandler) {
        this.inputView = inputView;
        this.outputView = outputView;
        this.exceptionHandler = exceptionHandler;
    }

    public void run() {
        final Participants participants = exceptionHandler.retryOnException(this::createParticipants);
        final LadderGamePrize ladderGamePrize = exceptionHandler.retryOnException(this::readLadderGameResult);
        final int width = participants.getNecessaryLadderWidth();
        final Ladder ladder = createLadder(width);
        printLadder(participants, ladder, ladderGamePrize);

        participants.playAll(ladder);
        final GameResults gameResults = ladderGamePrize.determinePersonalResult(participants);
        printGameResult(gameResults);

        inputView.closeResource();
    }

    private Participants createParticipants() {
        final List<String> participantsName = inputView.readParticipantsName();
        return new Participants(participantsName);
    }

    private Ladder createLadder(final int stepWidth) {
        final Height height = exceptionHandler.retryOnException(this::readLadderHeight);
        final LadderStepGenerator ladderStepGenerator = new RandomLadderStepGenerator();
        return new Ladder(height, stepWidth, ladderStepGenerator);
    }

    private LadderGamePrize readLadderGameResult() {
        final List<String> ladderGameResult = inputView.readLadderGameResult();
        return new LadderGamePrize(ladderGameResult);
    }

    private Height readLadderHeight() {
        final int ladderHeight = inputView.readLadderHeight();
        return new Height(ladderHeight);
    }

    private void printLadder(
            final Participants participants,
            final Ladder ladder,
            final LadderGamePrize ladderGamePrize) {
        outputView.printLadderPrefix();
        outputView.printParticipants(participants);
        outputView.printLadder(ladder);
        outputView.printLadderGamePrize(ladderGamePrize);
    }

    private void printGameResult(final GameResults gameResults) {
        boolean retry = true;
        while (retry) {
            retry = exceptionHandler.retryOnException(() -> printGameResultByCommand(gameResults));
        }
    }

    private boolean printGameResultByCommand(final GameResults gameResults) {
        final String gameResultTarget = inputView.readGameResultTarget();
        if (Objects.equals(gameResultTarget, FINISH_COMMAND)) {
            outputView.printAllGameResults(gameResults);
            return false;
        }
        final PersonalGameResult personalGameResult = gameResults.findByName(gameResultTarget);
        outputView.printPersonalGameResult(personalGameResult);
        return true;
    }
}
