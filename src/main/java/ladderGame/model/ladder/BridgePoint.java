package ladderGame.model.ladder;

public class BridgePoint {
    private boolean drawn;

    BridgePoint(boolean drawn) {
        this.drawn = drawn;
    }

    public void setTrue() {
        drawn = true;
    }

    public boolean isTrue() {
        return drawn == true;
    }
}
