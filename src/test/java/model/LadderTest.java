package model;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;
import static org.assertj.core.api.AssertionsForClassTypes.assertThatNoException;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class LadderTest {
    @Test
    @DisplayName("Ladder 객체 생성 성공 테스트")
    void createLadderTest() {
        //given
        Names names = new Names("pobi, neo, hiiro");
        Players players = new Players(names);
        LadderHeight ladderHeight = new LadderHeight(5);

        //then
        assertThatNoException().isThrownBy(() -> {
            new Ladder(players, ladderHeight);
        });
    }

    @Test
    @DisplayName("사다리 높이에 맞게 라인을 생성하는 기능 테스트 ")
    void makeLinesByLadderHeightTest() {
        //given
        Names names = new Names("pobi, neo, hiiro");
        Players players = new Players(names);
        LadderHeight ladderHeight = new LadderHeight(5);
        Ladder ladder = new Ladder(players, ladderHeight);

        //then
        assertThat(ladder.getHeight()).isEqualTo(5);
    }
}
