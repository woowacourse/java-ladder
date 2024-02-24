package domain;

import strategy.PointStrategy;

public enum Connection {

    CONNECTED,
    DISCONNECTED;

    Connection() {
    }

    public Connection makeNextConnection(PointStrategy pointStrategy) {
        if (this == CONNECTED) {
            return DISCONNECTED;
        }
        return pointStrategy.generatePoint();
    }
}
