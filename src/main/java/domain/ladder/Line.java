package domain.ladder;

import domain.booleangenerator.BooleanGenerator;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Line {

    private static final boolean GENERATE_VALUE = true;
    private static final int INDEX_LOWER_BOUND = 0;

    private final List<Point> line;

    public Line(int personCount, BooleanGenerator booleanGenerator) {
        line = new ArrayList<>();
        generateLine(personCount, booleanGenerator);
    }

    private static boolean isGenerated(BooleanGenerator booleanGenerator) {
        return booleanGenerator.generate() == GENERATE_VALUE;
    }

    private void generateLine(int personCount, BooleanGenerator booleanGenerator) {
        for (int i = 0; i < personCount - 1; i++) {
            generatePoint(booleanGenerator);
        }
    }

    private void generatePoint(BooleanGenerator booleanGenerator) {
        if (isGenerated(booleanGenerator) && !hasAdjacentPoint()) {
            line.add(Point.CONNECTION);
            return;
        }
        line.add(Point.SEPARATION);
    }

    private boolean hasAdjacentPoint() {
        return !line.isEmpty() && line.get(line.size() - 1).getStatus();
    }

    public boolean isConnected(int index) {
        validateIndex(index);
        return line.get(index) == Point.CONNECTION;
    }

    private void validateIndex(int index) {
        if (isInvalidIndex(index)) {
            throw new IllegalArgumentException("사다리 가로줄의 번호는 0부터 플레이어 수 - 1까지의 범위를 갖는 정수로 입력해주세요.");
        }
    }

    private boolean isInvalidIndex(int index) {
        return index >= line.size() || index < INDEX_LOWER_BOUND;
    }

    public List<Point> getLine() {
        return Collections.unmodifiableList(line);
    }

    public int getLineSize() {
        return line.size();
    }
}
