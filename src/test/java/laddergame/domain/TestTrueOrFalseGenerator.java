package laddergame.domain;

import laddergame.util.TrueOrFalseGenerator;

import java.util.List;

class TestTrueOrFalseGenerator implements TrueOrFalseGenerator {
    List<Boolean> points;

    TestTrueOrFalseGenerator(List<Boolean> points) {
        this.points = points;
    }

    @Override
    public boolean generate() {
        return points.remove(0);
    }
}
