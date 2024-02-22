package model;

import java.util.Objects;

public class LadderHeight {
    private final int height;

    public LadderHeight(int height) {
        validateLadderHeightRange(height);
        this.height = height;
    }

    private void validateLadderHeightRange(int ladderHeight) {
        if (ladderHeight < 1) {
            throw new IllegalArgumentException("[ERROR] 사다리 높이는 1 이상의 정수이어야 한다.");
        }
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || getClass() != obj.getClass()) {
            return false;
        }
        LadderHeight objHeight = (LadderHeight) obj;
        return this.height == objHeight.height;
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(height);
    }

    @Override
    public String toString() {
        return "LadderHeight{"
                + "height:" + height
                + "}";
    }

    public int getHeight() {
        return height;
    }
}
