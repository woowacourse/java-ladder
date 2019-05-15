package ladder.model;

public class LadderCrossbar {
    private boolean crossbar;

    public LadderCrossbar(boolean crossbar) {
        this.crossbar = crossbar;
    }

    public boolean exist() {
        return crossbar;
    }
}
