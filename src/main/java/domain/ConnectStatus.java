package domain;

public enum ConnectStatus {
    CONNECT(true), DISCCONECT(false);

    private final boolean status;

    ConnectStatus(boolean status) {
        this.status = status;
    }

    public static ConnectStatus valueOf(boolean status){
        if(status){
            return CONNECT;
        }
        return DISCCONECT;
    }

    public boolean status(){
        return this.status;
    }
}
