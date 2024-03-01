package domain.strategy;


import domain.ladder.Bridge;

public abstract class BridgeMakingStrategy {
    public Bridge get(Bridge previous) {
        if (previous == null || previous.isExist()) {
            return Bridge.EMPTY;
        }
        return makeBridge();
    }

    public abstract Bridge get();

    protected abstract Bridge makeBridge();
}
