package domain.ladder;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

public class BridgeJudgeTest {

    List<Boolean> bridges;

    @Test
    @DisplayName("flag가 true이고 인덱스가 0이면 true가 반환된다")
    void getTrueIfFlagTrueIndexZero() {
        bridges = new ArrayList<>();
        boolean flag = true;
        int index = bridges.size();

        assertThat(BridgeJudge.canMake(bridges, flag, index)).isTrue();
    }

    @Test
    @DisplayName("flag가 true이고 이전 인덱스의 flag가 false이면 true가 반환된다.")
    void getTrueIfFlagTruePriorIndexFalse() {
        bridges = new ArrayList<>(List.of(true, false));
        boolean flag = true;
        int index = bridges.size();

        assertThat(BridgeJudge.canMake(bridges, flag, index)).isTrue();
    }

    @Test
    @DisplayName("flag가 false이면 반드시 false가 반환된다")
    void getFalseIfFlagFalse() {
        bridges = new ArrayList<>(List.of(true, false));
        boolean flag = false;
        int index = bridges.size();

        assertThat(BridgeJudge.canMake(bridges, flag, index)).isFalse();
    }

    @Test
    @DisplayName("flag가 true이고 이전 인덱스의 flag가 true이면 false가 반환된다.")
    void getFalseIfFlagTruePriorIndexTrue() {
        bridges = new ArrayList<>(List.of(false, true));
        boolean flag = true;
        int index = bridges.size();

        assertThat(BridgeJudge.canMake(bridges, flag, index)).isFalse();
    }
}
