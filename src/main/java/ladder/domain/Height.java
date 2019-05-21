package ladder.domain;

import ladder.view.ConsoleMessages;

import java.util.Objects;

public class Height {
    private static final int MIN_HEIGHT = 1;

    private final int height;

    public Height(String height) {
        try {
            this.height = Integer.parseInt(height);
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException(ConsoleMessages.ERR_NUMBER_FORMAT.message());
        }
        valid();
    }

    private void valid() {
        if (this.height < MIN_HEIGHT) {
            throw new IllegalArgumentException(ConsoleMessages.ERR_LADDER_RANGE.message());
        }
    }

    public int getHeight() {
        return this.height;
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
