package domain.ladder;

import domain.booleangenerator.BooleanGenerator;

public enum Point {

    CONNECTION(true),
    SEPARATION(false);

    private static final boolean GENERATE_VALUE = true;

    private final boolean status;


    Point(boolean status) {
        this.status = status;
    }

    public static boolean isGenerated(BooleanGenerator booleanGenerator) {
        return booleanGenerator.generate() == GENERATE_VALUE;
    }

    public boolean getStatus() {
        return status;
    }
}
