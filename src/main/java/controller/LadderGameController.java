package controller;

import domain.*;
import util.BooleanGenerator;
import view.input.InputView;
import view.output.OutputView;

public class LadderGameController {

    public void play(InputView inputView, OutputView outputView, BooleanGenerator booleanGenerator) {
        Participants participants = makeParticipants(inputView);
        Results results = makeResults(inputView, participants);
        Ladder ladder = generateMap(inputView, participants, booleanGenerator);
        showMap(outputView, participants, ladder, results);
    }

    private Participants makeParticipants(InputView inputView) {
        try {
            String participantNames = inputView.enterParticipantNames();
            return new Participants(participantNames);
        } catch (IllegalArgumentException exception) {
            inputView.printErrorMessage(exception);
            return makeParticipants(inputView);
        }
    }

    private Results makeResults(InputView inputView, Participants participants) {
        try {
            String results = inputView.enterResults();
            return new Results(results, participants.getParticipantCount());
        } catch (IllegalArgumentException exception) {
            inputView.printErrorMessage(exception);
            return makeResults(inputView, participants);
        }
    }

    private Ladder generateMap(InputView inputView, Participants participants, BooleanGenerator booleanGenerator) {
        try {
            Height height = new Height(inputView.enterHeight());
            Weight weight = new Weight(participants.getParticipantCount());
            return new Ladder(height, weight, booleanGenerator);
        } catch (IllegalArgumentException exception) {
            inputView.printErrorMessage(exception);
            return generateMap(inputView, participants, booleanGenerator);
        }
    }

    private void showMap(OutputView outputView, Participants participants, Ladder ladder,
                         Results results) {
        outputView.printMap(participants, ladder, results.get());
    }

    private void getResult(InputView inputView, OutputView outputView) {

    }
}
