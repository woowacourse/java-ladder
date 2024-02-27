package util;

import domain.Leg;
import util.generator.LineGenerator;

import java.util.List;

public class CustomLineGenerator implements LineGenerator {
    @Override
    public List<Leg> generate(int legCount) {
        return List.of(Leg.from(true), Leg.from(false), Leg.from(true));
    }
}
