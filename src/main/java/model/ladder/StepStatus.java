package model.ladder;

public enum StepStatus {
    CONNECTED(true),
    UNCONNECTED(false);
    
    private final boolean isConnected;

    StepStatus(final boolean isConnected) {
        this.isConnected = isConnected;
    }
}
