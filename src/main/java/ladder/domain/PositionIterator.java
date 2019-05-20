package ladder.domain;

import java.util.Iterator;
import java.util.NoSuchElementException;

public class PositionIterator implements Iterable<Position>, Iterator<Position> {
    private final Position first;
    private int begin, end, current; // [begin, end)

    public PositionIterator(Position first) {
        this.first = first;

        this.begin = first.toInt();
        this.end = first.last().toInt();
        this.current = this.begin - 1;
    }

    @Override
    public Iterator<Position> iterator() {
        return this;
    }

    @Override
    public boolean hasNext() {
        return current < end;
    }

    @Override
    public Position next() {
        if (current == end) {
            throw new NoSuchElementException();
        }
        current++;

        return first.plus(current - begin);
    }
}
