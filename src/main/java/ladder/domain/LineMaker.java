package ladder.domain;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class LineMaker {

    private final BlockGenerator blockGenerator;

    public LineMaker(final BlockGenerator blockGenerator) {
        this.blockGenerator = blockGenerator;
    }

    public Line makeLine(final int playerNumber) {
        List<Boolean> blocks = makeBlocks(playerNumber);
        return new Line(blocks);
    }

    private List<Boolean> makeBlocks(int blockCount) {
        Stack<Boolean> blocks = new Stack<>();
        blocks.push(blockGenerator.generate());
        do {
            boolean previousBlock = blocks.peek();
            blocks.push(generateBlock(previousBlock));
            blockCount--;
        } while (blockCount != 0);
        return blocks;
    }

    // TODO: enum으로 처리할 필요 있음.
    private Boolean generateBlock(boolean previousBlock) {
        if (previousBlock) {
            return false;
        }
        return blockGenerator.generate();
    }
}
