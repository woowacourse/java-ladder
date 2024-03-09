package model;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class LadderTest {

    @DisplayName("사다리 높이와 사람 수, RandomGenerator을 입력받아 사다리 줄을 설정한다.")
    @Test
    void addLadderLine() {
        Height height = new Height("2");
        int peopleCount = 3;
        RandomGenerator randomGenerator = new RandomGenerator();
        Ladder ladder = new Ladder(height, peopleCount, randomGenerator);
        List<Line> result = ladder.getLines();

        assertThat(result).hasSize(2);
    }

    @DisplayName("사다리를 오르면 결과값이 위치하는 int 인덱스를 반환한다")
    @Test
    void climbLadder() {
        //given
        Height height = new Height("10");
        int peopleCount = 3;
        RandomGenerator randomGenerator = new RandomGenerator();
        Ladder ladder = new Ladder(height, peopleCount, randomGenerator);

        List<Integer> startIndex = List.of(0, 1, 2);
        List<Integer> destinationIndex = new ArrayList<>();

        //when
        for (int start : startIndex) {
            destinationIndex.add(ladder.climbLadder(start));
        }

        //then
        assertThat(destinationIndex).contains(0, 1, 2);
    }
}
