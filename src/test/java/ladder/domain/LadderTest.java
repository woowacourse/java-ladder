package ladder.domain;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertAll;

import static ladder.domain.Direction.RIGHT;

import java.util.List;

import org.junit.jupiter.api.Test;

public class LadderTest {

    @Test
    void ladderTest() {
        // given
        People people = new People(List.of("poby", "honux", "crong", "jk"));
        Height height = new Height(5);

        // when
        Ladder ladder = new Ladder(people, height);
        ladder.initialize(() -> RIGHT);

        LadderLevel anyLadderLevel = ladder.stream().findFirst().get();

        int actualHeight = (int) ladder.stream().count();
        int actualPeopleCount = (int) anyLadderLevel.stream().count();

        // then
        assertAll(
                () -> assertThat(actualHeight).isEqualTo(height.value()),
                () -> assertThat(actualPeopleCount).isEqualTo(people.count())
        );
    }
}
