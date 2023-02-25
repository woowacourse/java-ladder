package model.domain;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;
import static org.assertj.core.api.AssertionsForClassTypes.assertThatNoException;

import model.vo.LadderHeight;
import model.vo.Name;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;

public class LadderTest {
    List<Name> names;
    Players players;
    LadderHeight ladderHeight;

    @BeforeEach
    void beforeTest() {
        names = List.of(new Name("pobi"), new Name("neo"), new Name("hiiro"));
        players = new Players(names);
        ladderHeight = new LadderHeight(5);
    }

    @Test
    @DisplayName("Ladder 객체 생성 성공 테스트")
    void createLadderTest() {
        assertThatNoException().isThrownBy(() -> new Ladder(players, ladderHeight));
    }

    @Test
    @DisplayName("사다리 높이에 맞게 라인을 생성하는 기능 테스트 ")
    void makeLinesByLadderHeightTest() {
        //given
        Ladder ladder = new Ladder(players, ladderHeight);

        //then
        assertThat(ladder.getHeight()).isEqualTo(5);
    }
}
