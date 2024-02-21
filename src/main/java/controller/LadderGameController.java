package controller;

import model.Ladder;
import model.LadderGame;
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
        int ladderHeight = inputView.readLadderHeight();

        RandomGenerator generator = new RandomGenerator();
        LadderGame ladderGame = new LadderGame(ladderHeight, participants, generator);
        Ladder ladder = ladderGame.createLadder();

        outputView.printResultHeader();
        outputView.printParticipantsNames(participants);
        outputView.printLadder(ladder);
    }
}
