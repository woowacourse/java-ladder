package ladder.model;

import java.util.Random;

public class Bridge {
    private static final Random RANDOM = new Random();
    private static final boolean DISCONNECTED = false;
    private final boolean isConnect;

    private Bridge(boolean isConnect) {
        this.isConnect = isConnect;
    }

    public static Bridge firstBridge() {
        return new Bridge(RANDOM.nextBoolean());
    }

    public static Bridge nextBridge(Bridge previousBridge) {
        if (previousBridge.isConnect() == DISCONNECTED) {
            return new Bridge(RANDOM.nextBoolean());
        }
        return new Bridge(DISCONNECTED);
    }

    public boolean isConnect() {
        return this.isConnect;
    }

    boolean isBridgesConnected(Bridge previousBridge) {
        return previousBridge.isConnect() && this.isConnect;
    }
}
