package laddergame;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.List;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class LadderTest {

    @DisplayName("사다리를 생성한다.")
    @Test
    void createLadder() {
        // given
        int height = 5;
        int personSize = 4;

        // when
        Ladder ladder = Ladder.create(height, personSize, new RandomBooleanGenerator());

        // then
        assertThat(ladder.getHeight()).isEqualTo(height);
    }

    @DisplayName("사다리 폭 길이를 반환한다.")
    @Test
    void ladderWidth() {
        // given
        Ladder ladder = Ladder.create(5, 4, new RandomBooleanGenerator());
        Names names = new Names(List.of(new Name("pobi"),
                new Name("honux"),
                new Name("crong"),
                new Name("jk")));

        // when
        final int width = ladder.getWidth(names);

        // then
        assertThat(width).isEqualTo(5);
    }
}
