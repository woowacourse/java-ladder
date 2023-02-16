package ladder.domain;

import java.util.Arrays;

public enum Block {
    EMPTY(0),
    EXIST(1);

    private final int status;

    Block(int status) {
        this.status = status;
    }

    public static Block of(int status) {
        return Arrays.stream(Block.values())
                .filter(block -> block.status == status)
                .findFirst()
                .orElseThrow(RuntimeException::new);
    }

    public boolean isExistBlock() {
        return this == Block.EXIST;
    }
}
