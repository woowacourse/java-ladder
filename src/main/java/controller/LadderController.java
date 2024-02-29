package controller;

import model.ladder.Height;
import model.ladder.Ladder;
import model.ladder.LadderGame;
import model.ladder.LadderGenerateStrategy;
import model.participant.Participant;
import model.participant.Participants;
import model.result.ParticipantsResult;
import model.result.Results;
import view.InputView;
import view.OutputView;

import java.util.function.Supplier;

public class LadderController {

    private final InputView inputView;
    private final OutputView outputView;

    public LadderController(InputView inputView, OutputView outputView) {
        this.inputView = inputView;
        this.outputView = outputView;
    }

    public void run() {
        Participants participants = attempt(() -> new Participants(
                attempt(() -> inputView.inputParticipantsName()))
        );
        Results results = attempt(() -> new Results(
                attempt(() -> inputView.inputResults()), participants.size())
        );
        Ladder ladder = new Ladder(new LadderGenerateStrategy(),
                attempt(() -> new Height(inputView.inputLadderHeight())), participants);
        LadderGame ladderGame = new LadderGame(ladder, participants, results);
        outputView.printLadder(ladderGame);
        outputView.printLadderGameResult(attempt(() -> play(ladderGame)));
    }

    private ParticipantsResult play(LadderGame ladderGame) {
        String participantName = inputView.inputParticipantName();
        while (!participantName.equals(InputView.ENTIRE_PARTICIPANTS)) {
            outputView.printParticipantResult(ladderGame.matchResult(new Participant(participantName)));
            participantName = inputView.inputParticipantName();
        }
        return ladderGame.matchAllResults();
    }

    private <T> T attempt(Supplier<T> inputSupplier) {
        try {
            return inputSupplier.get();
        } catch (IllegalArgumentException e) {
            outputView.printException(e.getMessage());
            return attempt(inputSupplier);
        }
    }
}
