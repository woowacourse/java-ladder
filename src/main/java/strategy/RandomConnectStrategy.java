package strategy;

import domain.Connection;
import java.util.Random;

public class RandomConnectStrategy implements ConnectStrategy {

    private final Random random;

    public RandomConnectStrategy() {
        this.random = new Random();
    }

    @Override
    public Connection generate() {
        if (random.nextBoolean()) {
            return Connection.CONNECTED;
        }
        return Connection.DISCONNECTED;
    }
}
