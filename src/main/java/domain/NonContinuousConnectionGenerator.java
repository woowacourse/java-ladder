package domain;

import static domain.ConnectionStatus.DISCONNECTED;

import util.RandomElementSelector;

public class NonContinuousConnectionGenerator implements ConnectionGenerator {

    @Override
    public ConnectionStatus generateByPreviousStatus(ConnectionStatus previous) {
        if (previous.isConnect()) {
            return DISCONNECTED;
        }
        return RandomElementSelector.selectRandomConstant(ConnectionStatus.class);
    }
}
