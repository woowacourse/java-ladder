package ladder.model;

import java.util.Random;

public class LadderCrossbar {

    private static final String HAS_CROSSBAR = "-----";
    private static final String HAS_NOT_CROSSBAR = "     ";

    private boolean crossbar;

    public LadderCrossbar(){
        this.crossbar = generateRandom();
    }

    public LadderCrossbar(boolean crossbar) {
        this.crossbar = crossbar;
    }

    private boolean generateRandom(){
        return new Random().nextBoolean();
    }

    public boolean exist() {
        return crossbar;
    }

    public void changeCrossbarValue(){
        this.crossbar = !this.crossbar;
    }

    @Override
    public String toString() {
        if (crossbar) {
            return HAS_CROSSBAR;
        }
        return HAS_NOT_CROSSBAR;
    }
}
