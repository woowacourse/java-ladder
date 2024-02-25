package ladder.domain;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatCode;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

import java.util.List;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class PlayersTest {

    @DisplayName("이름을 입력하여 Players을 생성한다.")
    @Test
    void playersConstructTest() {
        assertThatCode(() -> new Players(List.of("명오", "제우스")))
                .doesNotThrowAnyException();
    }

    @DisplayName("중복된 이름이 입력되면 예외가 발생한다.")
    @Test
    void duplicatedNameTest() {
        assertThatThrownBy(() -> new Players(List.of("명오", "명오")))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage("중복된 이름은 입력할 수 없습니다: %s".formatted("명오"));
    }

    @DisplayName("입력된 이름이 하나이면 예외가 발생한다.")
    @Test
    void OneNameTest() {
        assertThatThrownBy(() -> new Players(List.of("명오")))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage("참여자는 최소 2명입니다.");
    }

    @DisplayName("count 메서드는 사람 수를 반환한다.")
    @Test
    void playersCountTest() {
        Players players = new Players(List.of("명오", "제우스"));
        assertThat(players.count()).isEqualTo(2);
    }
}
