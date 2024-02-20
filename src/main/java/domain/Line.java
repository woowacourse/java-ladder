package domain;

import java.util.ArrayList;
import java.util.List;
import util.RandomGenerator;

public class Line {

    private List<Boolean> legs;

    public Line() {
        legs = new ArrayList<>();
    }

    public void makeLeg(int legCount) {
        for (int i = 0; i < legCount; i++) {
            legs.add(RandomGenerator.generateRandomBoolean());
        }
    }

    public List<Boolean> getLegs() {
        return legs;
    }
}
