package utils;

public class FixedNumberGenerator implements NumberGenerator {
    private final int inputNum;

    public FixedNumberGenerator(int inputNum) {
        this.inputNum = inputNum;
    }

    @Override
    public boolean isPoint(boolean point) {
        return inputNum == 1;
    }
}
