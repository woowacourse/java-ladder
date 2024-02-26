package laddergame.controller;

import laddergame.model.Ladder;
import laddergame.model.LadderGame;
import laddergame.model.LadderHeight;
import laddergame.model.Participants;
import laddergame.model.RandomGenerator;
import laddergame.view.InputView;
import laddergame.view.OutputView;

public class LadderGameController {
    private final InputView inputView;
    private final OutputView outputView;

    public LadderGameController(InputView inputView, OutputView outputView) {
        this.inputView = inputView;
        this.outputView = outputView;
    }

    public void run() {
        Participants participants = inputView.readParticipantNames();
        LadderHeight height = inputView.readLadderHeight();

        Ladder ladder = createLadder(height, participants);

        printResult(participants, ladder);
    }

    private Ladder createLadder(LadderHeight height, Participants participants) {
        RandomGenerator generator = new RandomGenerator();
        LadderGame ladderGame = new LadderGame(height, participants, generator);
        return ladderGame.createLadder();
    }

    private void printResult(Participants participants, Ladder ladder) {
        outputView.printResultHeader();
        outputView.printParticipantsNames(participants);
        outputView.printLadder(ladder);
    }
}
