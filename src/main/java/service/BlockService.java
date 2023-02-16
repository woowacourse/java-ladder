package service;

import java.util.ArrayList;
import java.util.List;
import model.Ladder;
import model.Line;
import model.Name;
import model.Names;
import model.Path;
import strategy.PassGenerator;

public class BlockService {

    private static final int HEAD_TO_BLOCK_SIZE = 1;
    private static final int HEAD_TO_LEFT_INDEX = 1;
    private static final int SECOND_BLOCK_INDEX = 1;

    private final PassGenerator generator;
    private Ladder ladder;

    public BlockService(PassGenerator generator) {
        this.generator = generator;
    }

    public Line initBlocks(int peopleCount) {
        Path firstPath = Path.calculatePath(generator.generate());
        List<Path> blocks = new ArrayList<>();
        blocks.add(firstPath);
        return new Line(generateBlocks(peopleCount, blocks));
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

    public void initLadder(int height, int peopleCount) {
        List<Line> lines = new ArrayList<>();

        while (height-- > 0) {
            lines.add(initLine(peopleCount));
        }
        ladder = new Ladder(lines);
    }

    private Line initLine(int peopleCount) {
        List<Path> paths = new ArrayList<>();

        while (--peopleCount > 0) {
            paths.add(generatePath(paths));
        }
        return new Line(paths);
    }

    private Path generatePath(List<Path> paths) {
        int size = paths.size();

        if (size > 0) {
            return Path.calculatePath(paths.get(size - 1), generator.generate());
        }
        return Path.calculatePath(generator.generate());
    }

    public Ladder getLadder() {
        return ladder;
    }
}
