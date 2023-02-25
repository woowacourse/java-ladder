package domain;

import domain.numbergenerator.NumberGenerator;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Line {

    private static final int GENERATE_NUMBER = 1;
    private static final int INDEX_LOWER_BOUND = 0;

    private final List<Point> line = new ArrayList<>();

    public Line(int personCount, NumberGenerator numberGenerator) {
        generateLine(personCount, numberGenerator);
    }

    private static boolean isGenerated(NumberGenerator numberGenerator) {
        return numberGenerator.generate() == GENERATE_NUMBER;
    }

    private void generateLine(int personCount, NumberGenerator numberGenerator) {
        for (int i = 0; i < personCount - 1; i++) {
            generatePoint(numberGenerator);
        }
    }

    private void generatePoint(NumberGenerator numberGenerator) {
        if (isGenerated(numberGenerator) && !hasAdjacentPoint()) {
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

    public int getPointsSize() {
        return line.size();
    }
}
