package ladder.domain;

import java.util.concurrent.ThreadLocalRandom;

/**
 * 사다리가 연결되는지, 연결되지 않는지를 판단하는 클래스
 * <p>
 * ThreadLocalRandom 을 사용하여 랜덤한 boolean 값을 반환한다.
 * <p>
 * ThreadLocalRandom 은 ThreadLocal 을 사용하여 Thread 별로 Random 객체를 생성하기에, 멀티 스레드 환경에서도 안전하기에 선택하였습니다
 */
public class RandomConnectionJudgement implements ConnectionJudgement {

    private final ThreadLocalRandom threadLocalRandom = ThreadLocalRandom.current();

    @Override
    public boolean judge() {
        return threadLocalRandom.nextBoolean();
    }
}
