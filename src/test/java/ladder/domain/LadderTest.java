package ladder.domain;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatCode;
import static org.junit.jupiter.api.Assertions.assertAll;

import java.util.List;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class LadderTest {

    @DisplayName("사다리를 생성한다.")
    @Test
    void ladderConstructTest() {
        Players players = new Players(List.of("poby", "honux", "crong", "jk"));
        Height height = new Height(5);
        assertThatCode(() -> new Ladder(players, height))
                .doesNotThrowAnyException();
    }

    @DisplayName("사다리는 입력에 맞는 사이즈의 사다리를 생성한다.")
    @Test
    void ladderSizeTest() {
        //given
        Players players = new Players(List.of("poby", "honux", "crong", "jk"));
        Height height = new Height(5);
        Ladder ladder = new Ladder(players, height);

        //when
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
