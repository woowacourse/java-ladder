package domain.ladder;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

public class BridgeJudgeTest {

    List<Boolean> bridges;

    @Test
    @DisplayName("랜덤값이 true가 나와 다리를 생성하려고 할 때, 가장 왼쪽의 다리이면 다리를 생성할 수 있다.")
    void getTrueIfFlagTrueIndexZero() {
        bridges = new ArrayList<>();
        boolean flag = true;
        int index = bridges.size();

        assertThat(BridgeJudge.canMake(bridges, flag, index)).isTrue();
    }

    @Test
    @DisplayName("랜덤값이 true가 나와 다리를 생성하려고 할 때, 옆에 같은 높이에 다리가 없으면 다리를 생성할 수 있다.")
    void getTrueIfFlagTruePriorIndexFalse() {
        bridges = new ArrayList<>(List.of(true, false));
        boolean flag = true;
        int index = bridges.size();

        assertThat(BridgeJudge.canMake(bridges, flag, index)).isTrue();
    }

    @Test
    @DisplayName("랜덤값이 false가 나오면 다리를 생성할 수 없다.")
    void getFalseIfFlagFalse() {
        bridges = new ArrayList<>(List.of(true, false));
        boolean flag = false;
        int index = bridges.size();

        assertThat(BridgeJudge.canMake(bridges, flag, index)).isFalse();
    }

    @Test
    @DisplayName("랜덤값이 true가 나와 다리를 생성하려고 할 때, 옆에 같은 높이에 다리가 있으면 다리를 생성할 수 없다.")
    void getFalseIfFlagTruePriorIndexTrue() {
        bridges = new ArrayList<>(List.of(false, true));
        boolean flag = true;
        int index = bridges.size();

        assertThat(BridgeJudge.canMake(bridges, flag, index)).isFalse();
    }
}
