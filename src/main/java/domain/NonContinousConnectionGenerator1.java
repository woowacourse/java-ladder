package domain;

import static domain.Connection.DISCONNECTION;
import static domain.Connection.LEFT_CONNECTION;
import static domain.Connection.RIGHT_CONNECTION;

import util.RandomElementSelector;

public class NonContinousConnectionGenerator1 implements ConnectionGenerator1 {

    @Override
    public Connection generate(Connection previous) {
        if (previous == RIGHT_CONNECTION) {
            return LEFT_CONNECTION;
        }
        return RandomElementSelector.selectRandomFrom(RIGHT_CONNECTION, DISCONNECTION);
    }

    @Override
    public Connection generateLastConnection(Connection previous) {
        if (previous == RIGHT_CONNECTION) {
            return LEFT_CONNECTION;
        }
        return DISCONNECTION;
    }
}
