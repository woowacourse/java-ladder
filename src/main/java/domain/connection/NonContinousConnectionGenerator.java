package domain.connection;

import static domain.connection.Connection.DISCONNECTION;
import static domain.connection.Connection.LEFT_CONNECTION;
import static domain.connection.Connection.RIGHT_CONNECTION;

import util.RandomElementSelector;

public class NonContinousConnectionGenerator implements ConnectionGenerator {

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
