package domain;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class RandomBridgeGenerator implements BridgeGenerator {

    private static final Random random = new Random();

    /**
     * 이 생성전략은 (사람수 - 1) 길이, 랜덤한 true와 false값을 리스트로 반환한다.
     *
     * <p>
     *     랜덤을 생성하면서, 연속된 true값은 나올 수 없다.
     *     이전 요소값이 true이면 현재 요소값은 무조건 false를 삽입한다.
     *     그렇지 않다면 랜덤값을 삽입한다.
     * </p>
     *
     * @param count 사람수; 0 이상이어야 한다.
     * @return (사람수 - 1) 길이의 true와 false 요소값을 가지는 리스트를 반환한다.
     */
    @Override
    public List<Boolean> generate(int count) {
        List<Boolean> result = new ArrayList<>(count);
        result.add(random.nextBoolean());
        for (int i = 1; i < count - 1; i++) {
            updateResult(result, result.get(i - 1));
        }
        return result;
    }

    private void updateResult(List<Boolean> result, Boolean previousValue) {
        if (previousValue) {
            result.add(Boolean.FALSE);
            return;
        }
        result.add(random.nextBoolean());
    }
}
