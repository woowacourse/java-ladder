package ladder.model;

import ladder.utils.BooleanGenerator;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.IntStream;

public class Line {
    private static List<Boolean> row = null;

    private Line(List<Boolean> row) {
        this.row = row;
    }

    public static Line of(int length, BooleanGenerator bg) {
        List<Boolean> row = new ArrayList<>();

        for (int i = 0; i < length; i++) {
            row.add(makePath(row, i, bg));
        }

        return new Line(row);
    }

    public static boolean isLeftPathExist(List<Boolean> row, int position) {
        if (position == 0) {
            return false;
        }
        return row.get(position - 1);
    }

    private static boolean makePath(List<Boolean> row, int position, BooleanGenerator bg) {
        if (isLeftPathExist(row, position)) {
            return false;
        }
        return bg.generate();
    }

    public int size() {
        return row.size();
    }

    public List<Boolean> getRow() {
        return row;
    }
}
