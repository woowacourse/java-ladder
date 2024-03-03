package domain;

import java.util.Objects;

class BridgeIndex {

    public static final int MAXIMUM_INDEX = Players.MAXIMUM_PLAYER_SIZE - 2;

    private final int index;

    BridgeIndex(int index) {
        if (MAXIMUM_INDEX < index) {
            throw new IllegalArgumentException(
                    String.format("최대 다리 인덱스 %d 보다 큰 수로 생성할 수 없습니다. 입력값: %d", MAXIMUM_INDEX, index));
        }
        this.index = index;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (!(o instanceof BridgeIndex that)) {
            return false;
        }
        return index == that.index;
    }

    @Override
    public int hashCode() {
        return Objects.hash(index);
    }
}
