package util;

import java.util.Arrays;

public enum Status {
    BRIDGE_EXIST(true),
    BRIDGE_DOES_NOT_EXIST(false);

    private final boolean status;

    Status(boolean status) {
        this.status = status;
    }

    public static Status findStatus(Boolean move){
        return Arrays.stream(Status.values())
                .filter(status -> status.getStatus()==move)
                .findAny()
                .get();
    }


    public boolean getStatus(){
        return status;
    }
}
