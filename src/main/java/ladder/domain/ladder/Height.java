package ladder.domain.ladder;

import java.util.Objects;

public class Height {

    private static final int MINIMUM_HEIGHT = 1;

    private final int height;

    public Height(int height) {
        this.height = height;
    }

    public int getHeight() {
        return height;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Height height1 = (Height) o;
        return height == height1.height;
    }

    @Override
    public int hashCode() {
        return Objects.hash(height);
    }

}
