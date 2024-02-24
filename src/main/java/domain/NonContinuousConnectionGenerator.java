package domain;

import static domain.ConnectionStatus.CONNECTED;
import static domain.ConnectionStatus.DISCONNECTED;

public class NonContinuousConnectionGenerator implements ConnectionGenerator {

    @Override
    public ConnectionStatus generateByPreviousStatus(ConnectionStatus previous) {
        if (previous.isConnect()) {
            return CONNECTED;
        }
        return DISCONNECTED;
    }
}
