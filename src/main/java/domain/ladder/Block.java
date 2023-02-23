package domain.ladder;

public class Block {

    private final boolean connectStatus;

    public Block(boolean connectStatus) {
        this.connectStatus = connectStatus;
    }

    public boolean isConnected() {
        return connectStatus;
    }
}
