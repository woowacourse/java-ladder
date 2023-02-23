package domain;

import java.util.Arrays;

public enum LineStep {

    EXIST(true),
    NON_EXIST(false);

    private final boolean status;

    LineStep(boolean status) {
        this.status = status;
    }

    public static LineStep findBy(boolean status) {
        return Arrays.stream(LineStep.values())
                .filter(line -> line.status == status)
                .findAny()
                .orElseThrow(() -> new IllegalArgumentException("[ERROR] boolean 타입의 입력값이 아닙니다"));
    }

    public boolean getStatus() {
        return status;
    }
}
