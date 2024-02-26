package domain;

import util.generator.LineGenerator;

import java.util.List;

public class Line {

    private final List<Leg> legs;

    private Line(int legCount, LineGenerator lineGenerator) {
        legs = makeLegs(legCount, lineGenerator);
    }

    public static Line of(int legCount, LineGenerator lineGenerator) {
        return new Line(legCount, lineGenerator);
    }

    private List<Leg> makeLegs(int legCount, LineGenerator lineGenerator) {
        return lineGenerator.generate(legCount);
    }

    public List<Leg> getLegs() {
        return List.copyOf(legs);
    }
}
