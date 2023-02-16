package model;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;
import static org.assertj.core.api.AssertionsForClassTypes.assertThatNoException;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.stream.IntStream;

public class LadderTest {

    @Test
    @DisplayName("Ladder 객체 생성 성공 테스트")
    void createLadderTest() {
        //Given
        Names names = new Names("pobi, neo, hiiro");
        Players players = new Players(names);
        LadderHeight ladderHeight = new LadderHeight(5);

        //Then
        assertThatNoException().isThrownBy(() -> {
            Ladder ladder = new Ladder(players, ladderHeight);
        });
    }

    @Test
    @DisplayName("사다리 높이에 맞게 라인을 생성하는 기능 테스트 ")
    void makeLinesByLadderHeightTest() {
        //Given
        Names names = new Names("pobi, neo, hiiro");
        Players players = new Players(names);
        LadderHeight ladderHeight = new LadderHeight(5);
        Ladder ladder = new Ladder(players, ladderHeight);

        //Then
        IntStream.range(0, ladder.size()).forEach(
                index -> assertThat(ladder.getLine(index)).isInstanceOf(Line.class)
        );
    }
}
