package ladder.domain;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

import java.util.List;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class PlayersTest {

    @DisplayName("참여자가 2명 미만이면 예외를 발생한다.")
    @Test
    void playerCountTest() {
        assertThatThrownBy(() -> new Players(List.of(new Player("제우스"))))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining("참여자는 최소 2명입니다");
    }

    @DisplayName("중복된 이름이 입력되면 예외를 발생한다.")
    @Test
    void duplicateNameTest() {
        assertThatThrownBy(() -> new Players(List.of(
                new Player("명오"),
                new Player("명오"))))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining("중복된 이름은 입력할 수 없습니다.");
    }

    @DisplayName("사람 수를 반환한다.")
    @Test
    void playersCountTest() {
        Players players = new Players(List.of(
                new Player("명오"),
                new Player("제우스")));
        assertThat(players.count()).isEqualTo(2);
    }
}
