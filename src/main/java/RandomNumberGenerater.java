import java.util.Random;

public class RandomNumberGenerater implements NumberGenerater {

    private static final Random random = new Random();
    @Override
    public int generate() {
        return random.nextInt(2);
    }
}
