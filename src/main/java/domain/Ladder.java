package domain;

import java.util.ArrayList;
import java.util.List;

public class Ladder {
    private final List<Line> ladder;
    private final BooleanCreator booleanCreator;

    public Ladder(int ladderHeight, Players players, BooleanCreator booleanCreator) {
        this.booleanCreator = booleanCreator;
        this.ladder = createLadder(ladderHeight, players);
    }

    public List<Line> createLadder(int ladderHeight, Players players) {
        List<Line> list = new ArrayList<>();
        for (int i = 0; i < ladderHeight; i++) {
            Line line = createLine(players);
            list.add(line);
        }
        return list;
    }

    private Line createLine(Players players) {
        Block preBlock = new Block(booleanCreator.generate());
        List<Block> blocks = createBlocks(players, preBlock);
        return new Line(players, blocks);
    }

    private List<Block> createBlocks(Players players, Block preBlock) {
        List<Block> blocks = new ArrayList<>(List.of(preBlock));

        int bound = players.getPlayersSize() - 1;
        for (int i = 1; i < bound; i++) {
            Block nextBlock = new Block(booleanCreator.generate());
            nextBlock.comparePreBlock(preBlock);
            blocks.add(nextBlock);
            preBlock = nextBlock;
        }
        return blocks;
    }

    public List<Line> getLadder() {
        return ladder;
    }
}
