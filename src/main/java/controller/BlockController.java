package controller;

import java.util.List;
import model.Blocks;
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
        List<String> names = inputView.inputNameOfParticipants();
        outputView.noticeInputHeightOfLadder();
        int heightOfLadder = inputView.inputHeightOfLadder();
        outputView.noticeResult();
        outputView.printNameOfParticipants(names);
        for (int i = 0; i < heightOfLadder; i++) {
            Blocks blocks = blockService.initBlocks(names.size());
            outputView.printBlocks(blocks, names);
        }
    }
}
