package controller;

import model.Ladder;
import model.Line;
import model.Names;
import service.BlockService;
import view.InputView;
import view.OutputView;

public class BlockController {

    private final InputView inputView;
    private final OutputView outputView;
    private final BlockService blockService;

    public BlockController(InputView inputView, OutputView outputView, BlockService blockService) {
        this.inputView = inputView;
        this.outputView = outputView;
        this.blockService = blockService;
    }

    public void run() {
        outputView.noticeInputParticipants();
        Names names = blockService.generateNames(inputView.inputNameOfParticipants());
        outputView.noticeInputHeightOfLadder();
        int heightOfLadder = inputView.inputHeightOfLadder();

        outputView.noticeResult();
        outputView.printNameOfParticipants(names);
        blockService.initLadder(heightOfLadder, names.getNames().size());

        Ladder ladder = blockService.getLadder();
        outputView.printLadder(ladder);
    }
}
