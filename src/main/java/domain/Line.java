package domain;

import java.util.ArrayList;
import java.util.List;
import utils.booleanGenerator.BooleanGenerator;

public class Line {
    private final BooleanGenerator generator;
    List<Boolean> points = new ArrayList<>();

    public Line(int personNumber, BooleanGenerator generator) {
        this.generator = generator;
        for (int index = 0; index < getPointSize(personNumber); index++) {
            points.add(getPoint(index));
        }
    }

    public List<Boolean> getPoints() {
        return points;
    }

    private static int getPointSize(int personNumber) {
        PersonNumber number = new PersonNumber(personNumber);
        return number.getPersonNumber() - 1;
    }

    private boolean getPoint(int index) {
        if (index > 0 && points.get(index - 1)) {
            return false;
        }
        return generator.generate();
    }

}
