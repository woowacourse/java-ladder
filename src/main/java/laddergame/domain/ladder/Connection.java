package laddergame.domain.ladder;

public enum Connection {

    CONNECTED(true),
    NOTCONNECTED(false);

    private final boolean isConnect;

    Connection(boolean isConnect){
        this.isConnect=isConnect;
    }
}
