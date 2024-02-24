package util;

import domain.LineItem;
import java.util.Random;

public class RandomLineItemGenerator implements LineItemGenerator {

    private final Random random = new Random();

    @Override
    public LineItem generate() {
        boolean isConnected = random.nextBoolean();
        return LineItem.valueOf(isConnected);
    }
}
