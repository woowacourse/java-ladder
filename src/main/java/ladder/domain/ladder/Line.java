package ladder.domain.ladder;

import ladder.domain.ladder.generator.BlockGenerator;
import ladder.domain.player.Position;

import java.util.List;
import java.util.Stack;

public class Line {

    private final List<Block> blocks;

    private Line(final List<Block> blocks) {
        this.blocks = blocks;
    }

    public static Line of(final BlockGenerator blockGenerator, final int playerNumber) {
        final int blockCount = playerNumber - 1;
        Stack<Block> blocks = new Stack<>();
        blocks.push(blockGenerator.generate());
        while (blocks.size() != blockCount) {
            Block block = generateBlock(blockGenerator, blocks.peek());
            blocks.push(block);
        }
        return new Line(blocks);
    }

    private static Block generateBlock(final BlockGenerator blockGenerator, final Block previousBlock) {
        if (previousBlock.isExistBlock()) {
            return Block.EMPTY;
        }
        return blockGenerator.generate();
    }

    public Block getBlockByIndex(final int index) {
        return blocks.get(index);
    }

    public List<Block> getBlocks() {
        return List.copyOf(blocks);
    }
}
