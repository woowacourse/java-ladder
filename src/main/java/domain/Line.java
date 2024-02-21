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
        legs.add(generate());
        for (int i = 1; i < legCount; i++) {
            decideLegExist(i);
        }
    }

    private void decideLegExist(int legIndex) {
        if(legs.get(legIndex - 1)){
            legs.add(false);
            return;
        }
        legs.add(generate());
    }

    protected Boolean generate(){
        return RandomGenerator.generateRandomBoolean();
    }

    public List<Boolean> getLegs() {
        return legs;
    }
}
