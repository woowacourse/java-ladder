package ladder.domain.ladder;

public class Step {

    private boolean buildStatus;

    public Step() {
        this.buildStatus = false;
    }

    public void build() {
        buildStatus = true;
    }

    public boolean getBuildStatus() {
        return buildStatus;
    }
}
