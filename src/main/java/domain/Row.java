package domain;

import java.util.ArrayList;
import java.util.List;

public class Row {

    private static final int MIN_SIZE = 2;
    private final List<Direction> row;


    public Row(final int size, final LadderStrategy strategy) {
        validationSize(size);

        this.row = new ArrayList<>();
        while (row.size() < size - 1) {
            addDirection(strategy.creatable());
        }
    }

    public int goDown(final int index) {
        return index + row.get(index).getDirection();
    }

    public List<Direction> getRow() {
        return row;
    }

    private void validationSize(final int size) {
        if (size < MIN_SIZE) {
            throw new IllegalArgumentException("사람은 2명 이상이어야 한다.");
        }
    }

    private void addDirection(final boolean creatable) {
        if (isPreviousDirectionRight()) {
            this.row.add(Direction.LEFT);
            return;
        }

        if (creatable) {
            this.row.add(Direction.RIGHT);
            return;
        }

        this.row.add(Direction.INPLACE);
    }

    private boolean isPreviousDirectionRight() {
        if (row.isEmpty()) {
            return false;
        }

        return row.get(row.size() - 1) == Direction.RIGHT;
    }
}
