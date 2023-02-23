package ladder.domain.ladder;

import ladder.domain.ladder.generator.BlockGenerator;

import java.util.List;
import java.util.Stack;

public class Line {

    private final List<Block> blocks;

    public Line(final BlockGenerator blockGenerator, final int playerNumber) {
        this.blocks = makeBlocks(blockGenerator, playerNumber - 1);
    }

    private List<Block> makeBlocks(final BlockGenerator blockGenerator, int blockCount) {
        Stack<Block> blocks = new Stack<>();
        blocks.push(blockGenerator.generate());
        while (blocks.size() != blockCount) {
            Block block = generateBlock(blockGenerator, blocks.peek());
            blocks.push(block);
        }
        return List.copyOf(blocks);
    }

    private Block generateBlock(final BlockGenerator blockGenerator, final Block previousBlock) {
        if (previousBlock.isExistBlock()) {
            return Block.EMPTY;
        }
        return blockGenerator.generate();
    }

    public List<Block> getBlocks() {
        return List.copyOf(blocks);
    }
}
