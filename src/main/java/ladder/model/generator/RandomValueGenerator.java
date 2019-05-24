package ladder.model.generator;

public class RandomValueGenerator {
    private static final int MAX_BOUND = 2;

    public static int generateRandomValue() {
        return (int) (Math.random() * MAX_BOUND);
    }
}
