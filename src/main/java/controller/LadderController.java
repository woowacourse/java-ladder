package controller;

import model.LadderRowElementGenerator;
import model.LadderRowGenerator;
import model.Height;
import model.Ladder;
import model.Participants;
import view.InputView;
import view.OutputView;

import java.io.IOException;

public class LadderController {

    private final InputView inputView;
    private final OutputView outputView;

    public LadderController(InputView inputView, OutputView outputView) {
        this.inputView = inputView;
        this.outputView = outputView;
    }

    public void play() throws IOException {
        Participants participants = new Participants(inputView.inputParticipantsName());
        LadderRowGenerator booleansGenerator
                = new LadderRowGenerator(participants.getParticipantsSize(), new LadderRowElementGenerator());
        Height height = new Height(inputView.inputLadderHeight());

        Ladder ladder = new Ladder(height, booleansGenerator);
        outputView.printResult();
        outputView.printParticipantsName(participants);
        outputView.printLadder(ladder);
    }
}
