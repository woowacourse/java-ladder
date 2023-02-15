package service;

import java.util.ArrayList;
import java.util.List;
import model.Block;
import model.Blocks;
import model.Name;
import model.Names;
import strategy.PassGenerator;

public class BlockService {

    public static final int HEAD_TO_BLOCK_SIZE = 1;
    public static final int HEAD_TO_LEFT_INDEX = 1;
    public static final int SECOND_BLOCK_INDEX = 1;
    private final PassGenerator generator;

    public BlockService(PassGenerator generator) {
        this.generator = generator;
    }

    public Blocks initBlocks(int peopleCount) {
        Block firstBlock = new Block(generator.generate());
        List<Block> blocks = new ArrayList<>();
        blocks.add(firstBlock);
        return new Blocks(generateBlocks(peopleCount, blocks));
    }

    private List<Block> generateBlocks(int peopleCount, List<Block> blocks) {
        for (int i = SECOND_BLOCK_INDEX; i < peopleCount - HEAD_TO_BLOCK_SIZE; i++) {
            Block leftBlock = blocks.get(i - HEAD_TO_LEFT_INDEX);
            Block rightBlock = new Block(generator.generate());
            rightBlock = generateBlock(leftBlock, rightBlock);
            blocks.add(rightBlock);
        }
        return blocks;
    }

    private Block generateBlock(Block leftBlock, Block rightBlock) {
        while (rightBlock.isLeftBlockHavePass(leftBlock)) {
            rightBlock = new Block(generator.generate());
        }
        return rightBlock;
    }

    public Names generateNames(List<String> input){
        List<Name> names = new ArrayList<>();
        for (String name : input) {
            names.add(new Name(name));
        }
        return new Names(names);
    }

}
