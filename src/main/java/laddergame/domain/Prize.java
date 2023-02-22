package laddergame.domain;

import laddergame.constant.ErrorCode;

public class Prize {

    private final LadderLabel value;

    public Prize(String value) {
        this.value = new LadderLabel(value);
    }

    public String getValue() {
        return value.getValue();
    }
}
