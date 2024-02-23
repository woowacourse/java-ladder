package ladder.domain;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatCode;
import static org.junit.jupiter.api.Assertions.assertAll;

import java.util.List;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class LadderTest {
    Players players;
    Height height;

    @BeforeEach
    void setUp() {
        players = new Players(List.of("poby", "honux", "crong", "jk"));
        height = new Height(5);
    }

    @DisplayName("사다리 생성")
    @Test
    void ladderConstructTest() {
        assertThatCode(() -> new Ladder(players, height))
                .doesNotThrowAnyException();
    }

    @DisplayName("사다리는 입력에 맞는 사이즈의 사다리를 생성한다.")
    @Test
    void ladderSizeTest() {
        //given
        Ladder ladder = new Ladder(players, height);

        // when
        ladder.initialize(new LineGenerator());

        LadderLevel anyLadderLevel = ladder.stream().findFirst().get();

        int actualHeight = (int) ladder.stream().count();
        int actualPlayersCount = (int) anyLadderLevel.stream().count();

        // then
        assertAll(
                () -> assertThat(actualHeight).isEqualTo(height.value()),
                () -> assertThat(actualPlayersCount).isEqualTo(players.count())
        );
    }
}
