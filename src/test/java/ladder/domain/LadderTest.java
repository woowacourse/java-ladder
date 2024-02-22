package ladder.domain;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatCode;
import static org.junit.jupiter.api.Assertions.assertAll;

import java.util.List;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class LadderTest {
    People people;
    Height height;

    @BeforeEach
    void setUp() {
        people = new People(List.of("poby", "honux", "crong", "jk"));
        height = new Height(5);
    }

    @DisplayName("사다리 생성")
    @Test
    void ladderConstructTest() {
        assertThatCode(() -> new Ladder(people, height))
                .doesNotThrowAnyException();
    }

    @DisplayName("사다리는 입력에 맞는 사이즈의 사다리를 생성한다.")
    @Test
    void ladderSizeTest() {
        //given
        Ladder ladder = new Ladder(people, height);

        // when
        ladder.initialize(new DefaultLineGenerator());

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
