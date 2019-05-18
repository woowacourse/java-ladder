package ladder.util;

public class RandomBooleanGenerator {
    public static boolean generateRandomBoolean() {
        return (int)(Math.random() * 2) == 0;  // Math.random() * 2 is 0 or 1
    }
}
