package domain;

import java.util.List;
import java.util.stream.Collectors;

public class Line {
    public static final String LINE_LENGTH_ERROR_MESSAGE = "[ERROR] 사다리 블록의 수는 플레이어의 수보다 하나 작아야합니다";

    private List<Block> blocks;

    public Line(int playerCount, List<Block> blocks) {
        validateLineLength(playerCount, blocks);
        this.blocks = blocks;
    }

    public List<Boolean> getLine() {
        return blocks.stream()
                .map(Block::getIsCross)
                .collect(Collectors.toList());
    }

    private void validateLineLength(int playerCount, List<Block> blocks) {
        if (blocks.size() != playerCount - 1) {
            throw new IllegalArgumentException(LINE_LENGTH_ERROR_MESSAGE);
        }
    }
}
