package controller;

import model.Ladder;
import model.LadderRow;
import model.Participant;
import view.InputView;
import view.OutputView;

import java.io.IOException;
import java.util.List;

public class LadderController {

    private final InputView inputView;
    private final OutputView outputView;

    public LadderController(InputView inputView, OutputView outputView) {
        this.inputView = inputView;
        this.outputView = outputView;
    }

    public void play() throws IOException {
        List<Participant> participants = inputView.inputParticipantsName().stream().map(Participant::new).toList();
        Ladder ladder = new Ladder(inputView.inputLadderHeight(), participants.size());
        ladder.createRows();
        outputView.printResult();
        outputView.printParticipantsName(participants);
        outputView.printLadder(ladder);
    }
}
