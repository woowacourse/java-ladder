package ladder.domain;

import static ladder.domain.Direction.RIGHT;
import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertAll;

import java.util.List;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class LadderTest {
    @DisplayName("사다리는 (입력된 사용자의 수) * (입력된 높이) 사이즈의 사다리를 생성한다.")
    @Test
    void ladderSizeTest() {
        //given
        Ladder ladder = new Ladder(new Width(4), new Height(5), () -> RIGHT);

        //when
        LadderLevel anyLadderLevel = ladder.stream().findAny().get();

        int actualHeight = (int) ladder.stream().count();
        int actualPlayersCount = (int) anyLadderLevel.stream().count();

        // then
        assertAll(
                () -> assertThat(actualHeight).isEqualTo(5),
                () -> assertThat(actualPlayersCount).isEqualTo(4)
        );
    }

    @DisplayName("Players의 전체 위치를 반환한다.")
    @Test
    void getAllResultLocationTest() {
        Players players = new Players(List.of("poby", "honux"));
        Width width = new Width(2);
        Height height = new Height(3);
        Ladder ladder = new Ladder(width, height, () -> RIGHT);

        List<Player> actual = ladder.findAllResultPlayers(players);

        assertThat(actual).isEqualTo(List.of(
                new Player("poby", new Location(1)),
                new Player("honux", new Location(0))
        ));
    }
}
