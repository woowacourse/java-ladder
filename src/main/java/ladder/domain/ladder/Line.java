package ladder.domain.ladder;

import ladder.domain.ladder.builder.BlockGenerator;

import java.util.List;
import java.util.Stack;

public class Line {

    private final List<Block> blocks;
    private final BlockGenerator blockGenerator;

    public Line(final int playerNumber, BlockGenerator blockGenerator) {
        this.blockGenerator = blockGenerator;
        this.blocks = makeBlocks(playerNumber - 1);
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

    public List<Block> getBlocks() {
        return List.copyOf(blocks);
    }
}
