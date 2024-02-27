package domain;

import java.util.ArrayList;
import java.util.List;

public class Row {

    private final List<Direction> row;
    private final int MIN_SIZE = 2;

    public Row(int size, LadderStrategy strategy) {
        validationSize(size);

        this.row = new ArrayList<>();
        while (row.size() < size) {
            addDirection(size, strategy.creatable());
        }
    }

    public int goDown(int index) {
        return index + row.get(index).getDirection();
    }

    private void validationSize(int size) {
        if (size < MIN_SIZE) {
            throw new IllegalArgumentException("사람은 2명 이상이어야 한다.");
        }
    }

    // TODO: 메서드 리팩터링
    private void addDirection(int size, boolean creatable) {
        if (creatable && !isPreviousDirectionRight() && row.size() != size - 1) {
            this.row.add(Direction.RIGHT);
            this.row.add(Direction.LEFT);
        }

        if (row.size() < size) {
            this.row.add(Direction.INPLACE);
        }
    }

    private boolean isPreviousDirectionRight() {
        if (row.isEmpty()) {
            return false;
        }

        return row.get(row.size() - 1) == Direction.RIGHT;
    }
}
