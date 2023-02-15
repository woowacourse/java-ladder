import java.util.Random;

public class RandomLineGenerator implements LineGenerator {

    private final Random random = new Random();
    @Override
    public boolean generate() {
        return random.nextBoolean();
    }
}
