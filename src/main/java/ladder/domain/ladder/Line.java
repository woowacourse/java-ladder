package ladder.domain.ladder;

import ladder.domain.rule.BlockGenerator;

import java.util.List;
import java.util.Stack;

public class Line {

    private final BlockGenerator blockGenerator;
    private final List<Block> blocks;

    public Line(final int playerNumber, final BlockGenerator blockGenerator) {
        this.blockGenerator = blockGenerator;
        this.blocks = makeBlocks(playerNumber - 1);
    }

    private List<Block> makeBlocks(final int blockCount) {
        Stack<Block> temporaryBlocks = new Stack<>();
        temporaryBlocks.push(blockGenerator.generate());
        while (temporaryBlocks.size() != blockCount) {
            Block block = generateBlock(temporaryBlocks.peek());
            temporaryBlocks.push(block);
        }
        return List.copyOf(temporaryBlocks);
    }

    private Block generateBlock(final Block previousBlock) {
        if (previousBlock.isExistBlock()) {
            return Block.EMPTY;
        }
        return blockGenerator.generate();
    }

    public List<Block> getBlocks() {
        return List.copyOf(blocks);
    }
}
