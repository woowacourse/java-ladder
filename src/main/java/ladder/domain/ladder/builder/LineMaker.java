package ladder.domain.ladder.builder;

import ladder.domain.ladder.Block;
import ladder.domain.ladder.Line;

import java.util.List;
import java.util.Stack;

public class LineMaker {

    private final BlockGenerator blockGenerator;

    public LineMaker(final BlockGenerator blockGenerator) {
        this.blockGenerator = blockGenerator;
    }

    public Line makeLine(final int playerNumber) {
        final List<Block> blocks = makeBlocks(playerNumber - 1);
        return new Line(blocks);
    }

    private List<Block> makeBlocks(int blockCount) {
        Stack<Block> blocks = new Stack<>();
        blocks.push(blockGenerator.generate());
        while (blocks.size() != blockCount) {
            Block block = generateBlock(blocks.peek());
            blocks.push(block);
        }
        return List.copyOf(blocks);
    }

    private Block generateBlock(Block previousBlock) {
        if (previousBlock.isExistBlock()) {
            return Block.EMPTY;
        }
        return blockGenerator.generate();
    }
}
