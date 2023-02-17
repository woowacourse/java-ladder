package util;

import java.util.Arrays;

public enum Status {
    YES_BRIDGE(true),
    NO_BRIDGE(false);

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
