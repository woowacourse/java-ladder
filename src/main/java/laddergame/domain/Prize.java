package laddergame.domain;

import laddergame.vo.LadderLabel;

public class Prize {

    private final LadderLabel value;

    public Prize(String value) {
        this.value = new LadderLabel(value);
    }

    public String getValue() {
        return value.getValue();
    }
}
