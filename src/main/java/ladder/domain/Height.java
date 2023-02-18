package ladder.domain;

import java.util.Objects;

public class Height {

    private static final int MINIMUM_HEIGHT = 1;

    private final int height;

    private Height(int height) {
        this.height = height;
    }

    public static Height create(int maxHeight, RandomGenerator randomGenerator) {
        int height = randomGenerator.generateNumber(MINIMUM_HEIGHT, maxHeight);

        return new Height(height);
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
