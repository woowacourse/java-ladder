package controller;

import model.Ladder;
import model.LadderGame;
import model.LadderHeight;
import model.Participants;
import model.RandomGenerator;
import view.InputView;
import view.OutputView;

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
