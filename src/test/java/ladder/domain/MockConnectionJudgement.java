package ladder.domain;

/**
 * 원하는대로 연결 혹은 연결되지 않음을 판단하는 클래스
 * <p>
 * 생성자에서 원하는대로 연결 혹은 연결되지 않음을 판단하는 boolean 값을 받아서 judge() 메서드를 호출하면 해당 boolean 값을 반환한다.
 */
public class MockConnectionJudgement implements ConnectionJudgement {

    private final boolean expected;

    MockConnectionJudgement(boolean expected) {
        this.expected = expected;
    }

    @Override
    public boolean judge() {
        return expected;
    }
}
