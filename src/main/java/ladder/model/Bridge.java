package ladder.model;

public class Bridge {
    private final boolean isConnect;

    Bridge(boolean isConnect){
        this.isConnect=isConnect;
    }

    boolean isConnected(){
        return this.isConnect;
    }
}
