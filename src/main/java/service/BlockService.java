package service;

import java.util.ArrayList;
import java.util.List;
import model.Blocks;
import model.Name;
import model.Names;
import model.Path;
import strategy.PassGenerator;

public class BlockService {

    private static final int HEAD_TO_BLOCK_SIZE = 1;
    private static final int HEAD_TO_LEFT_INDEX = 1;
    private static final int SECOND_BLOCK_INDEX = 1;
    private final PassGenerator generator;

    public BlockService(PassGenerator generator) {
        this.generator = generator;
    }

    public Blocks initBlocks(int peopleCount) {
        Path firstPath = Path.calculatePath(generator.generate());
        List<Path> blocks = new ArrayList<>();
        blocks.add(firstPath);
        return new Blocks(generateBlocks(peopleCount, blocks));
    }

    private List<Path> generateBlocks(int peopleCount, List<Path> blocks) {
        for (int i = SECOND_BLOCK_INDEX; i < peopleCount - HEAD_TO_BLOCK_SIZE; i++) {
            Path leftPath = blocks.get(i - HEAD_TO_LEFT_INDEX);
            Path rightPath = Path.calculatePath(leftPath, generator.generate());
            blocks.add(rightPath);
        }
        return blocks;
    }

    public Names generateNames(List<String> input){
        List<Name> names = new ArrayList<>();
        for (String name : input) {
            names.add(new Name(name));
        }
        return new Names(names);
    }

}
