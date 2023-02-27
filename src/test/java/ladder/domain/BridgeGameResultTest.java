package ladder.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.HashMap;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

class BridgeGameResultTest {

    @Test
    @DisplayName("유저 이름으로 BridgeGameResult에게서 보상 정보를 얻어낸다.")
    void getRewardOf() {
        final HashMap<User, String> userStringHashMap = new HashMap<>();
        final User one = new User("one");
        final User two = new User("two");

        userStringHashMap.put(one, "rewardOne");
        userStringHashMap.put(two, "rewardTwo");

        final BridgeGameResult bridgeGameResult = new BridgeGameResult(userStringHashMap);
        assertThat(bridgeGameResult.getRewardOf("two")).isEqualTo("rewardTwo");
        assertThat(bridgeGameResult.getRewardOf("one")).isEqualTo("rewardOne");
    }

    @Test
    @DisplayName("BridgeGameResult에 없는 사람의 이름으로 결과를 얻으려 하면 예외가 발생한다.")
    void getRewardOfExceptionTest() {
        final HashMap<User, String> userStringHashMap = new HashMap<>();
        final User one = new User("one");
        final User two = new User("two");

        userStringHashMap.put(one, "rewardOne");
        userStringHashMap.put(two, "rewardTwo");

        final BridgeGameResult bridgeGameResult = new BridgeGameResult(userStringHashMap);
        assertThatThrownBy(()-> bridgeGameResult.getRewardOf("없는 이름"))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage("해당 유저는 존재하지 않습니다,");

    }
}
