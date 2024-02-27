package controller;

import model.Height;
import model.Ladder;
import model.LadderRowGenerator;
import model.Participants;
import model.RandomBooleanGenerator;
import view.InputView;
import view.OutputView;

public class LadderController {

    private final InputView inputView;
    private final OutputView outputView;

    public LadderController(InputView inputView, OutputView outputView) {
        this.inputView = inputView;
        this.outputView = outputView;
    }

    public void play() {
        Participants participants = new Participants(inputView.inputParticipantsName());
        Height height = new Height(inputView.inputLadderHeight());
        Ladder ladder = new Ladder(height, new LadderRowGenerator(new RandomBooleanGenerator()), participants);
        outputView.printResult();
        outputView.printParticipantsName(participants);
        outputView.printLadder(ladder);
    }
}
