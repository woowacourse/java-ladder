package controller;

import domain.*;
import util.BooleanGenerator;
import view.InputView;
import view.OutputView;

public class LadderGameController {

    private static final String GET_RESULT_ALL = "all";

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
        try {
            String participantNames = inputView.enterParticipantNames();
            return new Participants(participantNames);
        } catch (IllegalArgumentException exception) {
            inputView.printErrorMessage(exception);
            return setParticipants();
        }
    }

    private Results setResults(Participants participants) {
        try {
            String results = inputView.enterResults();
            return new Results(results, participants.getParticipantCount());
        } catch (IllegalArgumentException exception) {
            inputView.printErrorMessage(exception);
            return setResults(participants);
        }
    }

    private Ladder generateLadder(Participants participants, BooleanGenerator booleanGenerator) {
        try {
            Height height = new Height(inputView.enterHeight());
            Weight weight = new Weight(participants.getParticipantCount());
            return new Ladder(height, weight, booleanGenerator);
        } catch (IllegalArgumentException exception) {
            inputView.printErrorMessage(exception);
            return generateLadder(participants, booleanGenerator);
        }
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
            inputView.printErrorMessage(exception);
            return true;
        }
    }

    private boolean getResultByInput(LadderGame ladderGame, String inputValue) {
        if (GET_RESULT_ALL.equals(inputValue)) {
            outputView.printMatchAllResult(ladderGame.getGameAllResult(),
                    ladderGame.getParticipants());
            return false;
        }

        outputView.printMatchResult(ladderGame.getGameResultByName(inputValue));
        return true;
    }
}
