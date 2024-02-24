package strategy;

import domain.Connection;
import java.util.Random;

public class RandomPointStrategy implements PointStrategy {

    @Override
    public Connection generatePoint() {
        Random random = new Random();
        if (random.nextBoolean()) {
            return Connection.CONNECTED;
        }
        return Connection.DISCONNECTED;
    }
}
