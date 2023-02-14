package service;

import java.util.ArrayList;
import java.util.List;
import model.Block;
import model.Blocks;
import strategy.PassGenerator;

public class BlockService {

    private final PassGenerator generator;

    public BlockService(PassGenerator generator) {
        this.generator = generator;
    }

    public Blocks initBlocks(int peopleCount) {
        List<Block> blocks = new ArrayList<>();

        Block leftBlock = new Block(generator.generate());
        blocks.add(leftBlock);

        for (int i = 1; i < peopleCount - 1; i++) {
            leftBlock = blocks.get(i - 1);

            Block nowBlock = new Block(generator.generate());

            while (nowBlock.isLeftBlockHavePass(leftBlock)) {
                nowBlock = new Block(generator.generate());
            }
            blocks.add(nowBlock);
        }

        return new Blocks(blocks);
    }
}
