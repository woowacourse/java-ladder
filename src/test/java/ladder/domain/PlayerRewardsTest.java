package ladder.domain;

import org.junit.jupiter.api.Test;

import java.util.HashMap;
import java.util.Map;

import static org.junit.jupiter.api.Assertions.assertThrows;

public class PlayerRewardsTest {
    //쉼표로 구분
    //레더게임이 여기서 입력된 수와 그 원래 사람의 수를 비교한다.


    @Test
    void 사이즈0_체크() {
        Map<Integer, String> input = new HashMap<>();
        assertThrows(IllegalArgumentException.class,()->{
           new PlayerRewards(input);
        });
    }
}
