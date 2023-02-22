package controller;

import domain.*;
import util.BooleanGenerator;
import view.input.InputView;
import view.output.OutputView;

public class LadderGameController {

    public void play(InputView inputView, OutputView outputView, BooleanGenerator booleanGenerator) {
        Participants participants = setParticipants(inputView);
        Results results = setResults(inputView, participants);
        Ladder ladder = generateLadder(inputView, participants, booleanGenerator);
        printLadder(outputView, participants, ladder, results);
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

    private void printLadder(OutputView outputView, Participants participants, Ladder ladder,
                             Results results) {
        outputView.printMap(participants, ladder, results.get());
    }
}
