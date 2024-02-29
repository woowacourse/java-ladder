package ladder;

public class Index {

    private final int position;

    private Index(int position) {
        this.position = position;
    }

    public static Index of(int position) {
        return new Index(position);
    }

    public Index increment() {
        return new Index(position + 1);
    }

    public Index decrement() {
        return new Index(position - 1);
    }

    public int toInt() {
        return position;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }

        final Index index = (Index) o;

        return position == index.position;
    }

    @Override
    public int hashCode() {
        return position;
    }
}
