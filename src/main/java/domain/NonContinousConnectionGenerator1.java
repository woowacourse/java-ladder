package domain;

import static domain.Connection.DISCONNECTED;
import static domain.Connection.LEFT_CONNECTED;
import static domain.Connection.RIGHT_CONNECTED;
import static domain.Direction.RIGHT;

import util.RandomElementSelector;

public class NonContinousConnectionGenerator1 implements ConnectionGenerator1 {

    @Override
    public Connection generate(Connection previous) {
        if (previous.getDirection() == RIGHT) {
            return LEFT_CONNECTED;
        }
        return RandomElementSelector.selectRandomFrom(RIGHT_CONNECTED, DISCONNECTED);
    }
}
