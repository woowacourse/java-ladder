package ladder.domain;

public class Step {

    private boolean buildStatus;

    public Step() {
        this.buildStatus = false;
    }

    public void changeStatus() {
        buildStatus = true;
    }

    public boolean getBuildStatus() {
        return buildStatus;
    }

    public String getStatusToSymbol() {
        return LadderStepSymbol.changeStatusToSymbol(buildStatus);
    }
}
