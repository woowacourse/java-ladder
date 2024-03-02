package domain.strategy;


import domain.ladder.Bridge;

/**
 * 연속한 Bridge를 생성하지 않는 다리 생성 전략
 */
public abstract class BridgeMakingStrategy {
    /**
     * 연속된 Bridge를 생성하는 것을 방지
     * 일반적인 상황에서 사용하는 것을 권장함
      */
    public Bridge get(final Bridge previous) {
        if (previous == null || previous.isExist()) {
            return Bridge.EMPTY;
        }
        return makeBridge();
    }

    /**
     * Row의 첫 Bridge를 생성할 때만 사용하는 것을 권장함
      */
    public abstract Bridge getFirst();

     protected abstract Bridge makeBridge();
}
