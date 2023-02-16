package utils;

import java.util.Random;

public class FixedNumberGenerator implements NumberGenerator {
    private final int inputNum;

    public FixedNumberGenerator(int inputNum) {
        this.inputNum = inputNum;
    }

    @Override
    public boolean isPoint() {
        return inputNum == 1;
    }
}
