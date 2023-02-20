package controller;

import model.Ladder;
import model.Names;
import strategy.PassGenerator;
import view.InputView;
import view.OutputView;

public class BlockController {

    private final InputView inputView;
    private final OutputView outputView;
    private final PassGenerator passGenerator;

    public BlockController(InputView inputView, OutputView outputView, PassGenerator passGenerator) {
        this.inputView = inputView;
        this.outputView = outputView;
        this.passGenerator = passGenerator;
    }

    public void run() {
        outputView.noticeInputParticipants();
        Names names = new Names(inputView.inputNameOfParticipants());
        outputView.noticeInputHeightOfLadder();
        int height = inputView.inputHeightOfLadder();
        Ladder ladder = new Ladder(height, names, passGenerator);
        outputView.noticeResult();
        outputView.printNames(names.getNames());
        outputView.printLadder(ladder.getLadderString());
    }
}
