package ladder.domain.ladder;

import java.util.List;

/**
 * 원하는대로 연결 혹은 연결되지 않음을 판단하는 클래스
 * <p>
 * 생성자에서 원하는대로 연결 혹은 연결되지 않음을 판단하는 boolean 값을 받아서 judge() 메서드를 호출하면 해당 boolean 값을 반환한다.
 */
public class MockConnectionJudgement implements ConnectionJudgement {

    private boolean expected;
    private List<Boolean> expecteds;
    private int index = 0;

    public MockConnectionJudgement(boolean expected) {
        this.expected = expected;
    }

    public MockConnectionJudgement(List<Boolean> expected) {
        expecteds = expected;
    }

    @Override
    public boolean judge() {
        if (expecteds != null) {
            return expecteds.get(index++);
        }
        return expected;
    }
}
