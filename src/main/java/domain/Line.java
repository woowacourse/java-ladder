package domain;

import exception.InvalidLineSizeException;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class Line {

    private static final String LINE_LENGTH_ERROR_MESSAGE = "사다리 블록의 수는 플레이어의 수보다 하나 작아야합니다";
    private static final int SECOND_BLOCK = 1;

    private final List<Block> blocks;

    public Line(Players players, List<Block> blocks) {
        validateLineLength(players.getPlayersSize(), blocks);
        this.blocks = blocks;
    }

    public static Line generateLine(BooleanGenerator booleanGenerator, Players players) {
        Block block = Block.createBlock(booleanGenerator.generate());
        List<Block> blocks = new ArrayList<>();
        blocks.add(block);

        int LineSize = players.getPlayersSize() - 1;
        for (int i = SECOND_BLOCK; i < LineSize; i++) {
            Block nextBlock = Block.createNextBlock(blocks.get(i - 1), booleanGenerator);
            blocks.add(nextBlock);
        }

        return new Line(players, blocks);
    }

    public List<Boolean> getLine() {
        return blocks.stream()
            .map(Block::getIsCross)
            .collect(Collectors.toUnmodifiableList());
    }

    public boolean isCross(int position) {
        if (position < 0 || position >= blocks.size()) {
            return false;
        }
        return blocks.get(position).getIsCross();
    }

    private void validateLineLength(int playerCount, List<Block> blocks) {
        if (blocks.size() != playerCount - 1) {
            throw new InvalidLineSizeException(LINE_LENGTH_ERROR_MESSAGE);
        }
    }
}
