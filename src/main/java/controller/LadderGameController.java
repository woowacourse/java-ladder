package controller;

import domain.*;
import util.BooleanGenerator;
import util.Task;
import view.InputView;
import view.OutputView;

public class LadderGameController {

    private static final String RESULT_ALL = "all";

    private final InputView inputView;
    private final OutputView outputView;
    private final BooleanGenerator booleanGenerator;

    public LadderGameController(InputView inputView, OutputView outputView,
                                BooleanGenerator booleanGenerator) {
        this.inputView = inputView;
        this.outputView = outputView;
        this.booleanGenerator = booleanGenerator;
    }

    public void play() {
        Participants participants = setParticipants();
        Results results = setResults(participants);
        Ladder ladder = generateLadder(participants, booleanGenerator);

        LadderGame ladderGame = new LadderGame(participants, results, ladder);
        printLadder(ladderGame);

        printResult(ladderGame);
    }

    private Participants setParticipants() {
        return Task.retryUntilSuccess(() -> {
            String participantNames = inputView.enterParticipantNames();
            return new Participants(participantNames);
        }, outputView);
    }

    private Results setResults(Participants participants) {
        return Task.retryUntilSuccess(() -> {
            String results = inputView.enterResults();
            return new Results(results, participants.getParticipantCount());
        }, outputView);
    }

    private Ladder generateLadder(Participants participants, BooleanGenerator booleanGenerator) {
        return Task.retryUntilSuccess(() -> {
            Height height = new Height(inputView.enterHeight());
            Weight weight = new Weight(participants.getParticipantCount());
            return new Ladder(height, weight, booleanGenerator);
        }, outputView);
    }

    private void printLadder(LadderGame ladderGame) {
        outputView.printLadder(ladderGame.getParticipants(), ladderGame.getLadder(),
                ladderGame.getResults());
    }

    private void printResult(LadderGame ladderGame) {
        boolean isContinue = true;
        while (isContinue) {
            isContinue = getResult(ladderGame);
        }
    }

    private boolean getResult(LadderGame ladderGame) {
        try {
            String inputResult = inputView.enterGetResult();
            return getResultByInput(ladderGame, inputResult);
        } catch (IllegalArgumentException exception) {
            outputView.printErrorMessage(exception);
            return true;
        }
    }

    private boolean getResultByInput(LadderGame ladderGame, String inputValue) {
        if (RESULT_ALL.equals(inputValue)) {
            outputView.printMatchAllResult(ladderGame.getGameAllResult(),
                    ladderGame.getParticipants());
            return false;
        }

        outputView.printMatchResult(ladderGame.getGameResultByName(inputValue));
        return true;
    }
}
