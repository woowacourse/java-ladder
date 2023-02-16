package controller;

import model.Ladder;
import model.Names;
import model.LadderMaker;
import view.InputView;
import view.OutputView;

public class BlockController {

    private final InputView inputView;
    private final OutputView outputView;
    private final LadderMaker ladderMaker;

    public BlockController(InputView inputView, OutputView outputView, LadderMaker ladderMaker) {
        this.inputView = inputView;
        this.outputView = outputView;
        this.ladderMaker = ladderMaker;
    }

    public void run() {
        outputView.noticeInputParticipants();
        Names names = ladderMaker.generateNames(inputView.inputNameOfParticipants());
        outputView.noticeInputHeightOfLadder();
        int heightOfLadder = inputView.inputHeightOfLadder();

        outputView.noticeResult();
        outputView.printNameOfParticipants(names);
        ladderMaker.initLadder(heightOfLadder, names.getNames().size());

        Ladder ladder = ladderMaker.getLadder();
        outputView.printLadder(ladder);
    }
}
