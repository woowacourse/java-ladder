package ladder.domain;

import java.util.List;
import java.util.Stack;

public class LineMaker {

    private final BlockGenerator blockGenerator;

    public LineMaker(final BlockGenerator blockGenerator) {
        this.blockGenerator = blockGenerator;
    }

    public Line makeLine(final int playerNumber) {
        final List<Boolean> blocks = makeBlocks(playerNumber - 1);
        return new Line(blocks);
    }

    private List<Boolean> makeBlocks(int blockCount) {
        Stack<Boolean> blocks = new Stack<>();
        blocks.push(blockGenerator.generate());
        while (blocks.size() != blockCount) {
            Boolean block = generateBlock(blocks.peek());
            blocks.push(block);
        }
        return List.copyOf(blocks);
    }

    // TODO: enum으로 처리할 필요 있음.
    private Boolean generateBlock(Boolean previousBlock) {
        if (previousBlock) {
            return false;
        }
        return blockGenerator.generate();
    }
}
