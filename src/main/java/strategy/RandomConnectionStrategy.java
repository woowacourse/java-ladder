package strategy;

import domain.Connection;
import java.util.Random;

public class RandomConnectionStrategy implements ConnectionStrategy {

    @Override
    public Connection generateConnection() {
        Random random = new Random();
        if (random.nextBoolean()) {
            return Connection.CONNECTED;
        }
        return Connection.DISCONNECTED;
    }
}