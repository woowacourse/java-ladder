package controller;

import model.Blocks;
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
        calculateLadderResult(names, heightOfLadder);
    }

    private void calculateLadderResult(Names names, int heightOfLadder) {
        for (int i = 0; i < heightOfLadder; i++) {
            Blocks blocks = blockService.initBlocks(names.getNames().size());
            outputView.printBlocks(blocks);
        }
    }
}
