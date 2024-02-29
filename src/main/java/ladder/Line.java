package ladder;

import java.util.List;

public class Line {

    private final List<Direction> directions;

    public Line(Direction... directions) {
        validateDirections(directions);
        this.directions = List.of(directions);
    }

    private void validateDirections(Direction[] directions) {
        for (int i = 1; i < directions.length; i++) {
            if (directions[i].equals(directions[i - 1])) {
                throw new IllegalArgumentException("양 쪽으로 연결될 수 없습니다.");
            }
        }
    }

    // 어디까지 int를 쓰고, 어디부터 Index를 써야 할까?
    public Index move(Index index) {
        return directions.get(index.toInt()).apply(index);
    }
}
