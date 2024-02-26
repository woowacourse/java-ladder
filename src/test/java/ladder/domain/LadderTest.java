package ladder.domain;

import static ladder.domain.Direction.RIGHT;
import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;
import static org.junit.jupiter.api.Assertions.assertAll;

import java.util.List;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class LadderTest {

    @DisplayName("사다리는 (입력된 사용자의 수) * (입력된 높이) 사이즈의 사다리를 생성한다.")
    @Test
    void ladderSizeTest() {
        //given
        Players players = new Players(List.of("poby", "honux", "crong", "jk"));
        Height height = new Height(5);
        Ladder ladder = new Ladder(players, height, () -> RIGHT);

        //when
        LadderLevel anyLadderLevel = ladder.stream().findAny().get();

        int actualHeight = (int) ladder.stream().count();
        int actualPlayersCount = (int) anyLadderLevel.stream().count();

        // then
        assertAll(
                () -> assertThat(actualHeight).isEqualTo(height.value()),
                () -> assertThat(actualPlayersCount).isEqualTo(players.count())
        );
    }

    @DisplayName("존재하지 않는 이름을 입력하면 예외를 던진다")
    @Test
    void invalidGetResultLocationTest() {
        Players players = new Players(List.of("poby", "honux"));
        Height height = new Height(3);
        Ladder ladder = new Ladder(players, height, () -> RIGHT);

        assertThatThrownBy(() -> ladder.getResultLocation("zeus"))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage("존재하지 않는 이름입니다.");
    }

    @DisplayName("이름을 입력하면 도착 위치를 반환한다.")
    @Test
    void getResultLocationTest() {
        Players players = new Players(List.of("poby", "honux"));
        Height height = new Height(3);
        Ladder ladder = new Ladder(players, height, () -> RIGHT);

        assertAll(
                () -> assertThat(ladder.getResultLocation("poby")).isEqualTo(1),
                () -> assertThat(ladder.getResultLocation("honux")).isEqualTo(0)
        );
    }

    @DisplayName("Players의 전체 위치를 반환한다.")
    @Test
    void getAllResultLocationTest() {
        Players players = new Players(List.of("poby", "honux"));
        Height height = new Height(3);
        Ladder ladder = new Ladder(players, height, () -> RIGHT);

        List<Player> actual = ladder.getAllResultLocation();

        assertThat(actual).isEqualTo(List.of(
                new Player("poby", 1),
                new Player("honux", 0)
        ));
    }
}
