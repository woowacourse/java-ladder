package controller;

import domain.*;
import util.BooleanGenerator;
import view.input.InputView;
import view.output.OutputView;

public class LadderGameController {

    private static final String GET_RESULT_ALL = "all";

    public void play(InputView inputView, OutputView outputView, BooleanGenerator booleanGenerator) {
        Participants participants = setParticipants(inputView);
        Results results = setResults(inputView, participants);
        Ladder ladder = generateLadder(inputView, participants, booleanGenerator);

        LadderGame ladderGame = new LadderGame(participants, results, ladder);
        printLadder(outputView, ladderGame);

        printResult(inputView, outputView, ladderGame);
    }

    private Participants setParticipants(InputView inputView) {
        try {
            String participantNames = inputView.enterParticipantNames();
            return new Participants(participantNames);
        } catch (IllegalArgumentException exception) {
            inputView.printErrorMessage(exception);
            return setParticipants(inputView);
        }
    }

    private Results setResults(InputView inputView, Participants participants) {
        try {
            String results = inputView.enterResults();
            return new Results(results, participants.getParticipantCount());
        } catch (IllegalArgumentException exception) {
            inputView.printErrorMessage(exception);
            return setResults(inputView, participants);
        }
    }

    private Ladder generateLadder(InputView inputView, Participants participants, BooleanGenerator booleanGenerator) {
        try {
            Height height = new Height(inputView.enterHeight());
            Weight weight = new Weight(participants.getParticipantCount());
            return new Ladder(height, weight, booleanGenerator);
        } catch (IllegalArgumentException exception) {
            inputView.printErrorMessage(exception);
            return generateLadder(inputView, participants, booleanGenerator);
        }
    }

    private void printLadder(OutputView outputView, LadderGame ladderGame) {
        outputView.printLadder(ladderGame.getParticipants(), ladderGame.getLadder(),
                ladderGame.getResults());
    }

    private void printResult(InputView inputView, OutputView outputView, LadderGame ladderGame) {
        boolean isContinue = true;
        while (isContinue) {
            isContinue = getResult(inputView, outputView, ladderGame);
        }
    }

    private boolean getResult(InputView inputView, OutputView outputView, LadderGame ladderGame) {
        try {
            String inputResult = inputView.enterGetResult();
            return getResultByInput(outputView, ladderGame, inputResult);
        } catch (IllegalArgumentException exception) {
            inputView.printErrorMessage(exception);
            return true;
        }
    }

    private boolean getResultByInput(OutputView outputView, LadderGame ladderGame, String inputValue) {
        if (GET_RESULT_ALL.equals(inputValue)) {
            outputView.printMatchAllResult(ladderGame.getGameAllResult(),
                    ladderGame.getParticipants());
            return false;
        }

        outputView.printMatchResult(ladderGame.getGameResultByName(inputValue));
        return true;
    }
}
