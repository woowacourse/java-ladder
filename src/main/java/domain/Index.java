package domain;

import java.util.Objects;

public class Index {
    private final int index;

    public Index(final int index) {
        this.index = index;
    }

    public Index increase() {
        return new Index(index + 1);
    }

    public Index decrease() {
        return new Index(index - 1);
    }

    @Override
    public boolean equals(final Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        final Index index1 = (Index) o;
        return index == index1.index;
    }

    @Override
    public int hashCode() {
        return Objects.hash(index);
    }
}
