import java.util.Random;

public class RandomTrueAndFalseGenerator implements TrueAndFalseGenerator {

    private static final Random random = new Random();
    @Override
    public Boolean generate() {
        return random.nextBoolean();
    }
}
