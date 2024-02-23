package domain;

import domain.booleangenerator.BooleanGenerator;

public enum Bridge {
    EXIST,
    BLANK;

    public static Bridge of(BooleanGenerator booleanGenerator) {
        if (booleanGenerator.generate()) {
            return EXIST;
        }
        return BLANK;
    }
}
