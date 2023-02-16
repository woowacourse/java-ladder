package domain;

import java.util.Arrays;

public enum LineStatus {
    EXIST(true),
    NON_EXIST(false);

    private final boolean status;

    LineStatus(boolean status) {
        this.status = status;
    }

    public static LineStatus findBy(boolean status) {
        return Arrays.stream(LineStatus.values())
                .filter(line -> line.status == status)
                .findAny()
                .orElseThrow(() -> new IllegalArgumentException("[ERROR] boolean 타입의 입력값이 아닙니다"));
    }

    public boolean getStatus() {
        return status;
    }
}
