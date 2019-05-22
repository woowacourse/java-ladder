package ladder.model;

import java.util.Random;

public class LadderCrossBar {

    private boolean crossbar;

    public LadderCrossBar(){
        crossbar = generateRandom();
    }

    public LadderCrossBar(LadderCrossBar beforeCrossbar) {
        crossbar = generateRandom(beforeCrossbar);
    }

    public boolean isCrossbar() {
        return crossbar;
    }

    private boolean generateRandom() {
        return new Random().nextBoolean();
    }

    private boolean generateRandom(LadderCrossBar beforeCrossbar) {
        return !beforeCrossbar.isCrossbar() && new Random().nextBoolean();
    }

}
