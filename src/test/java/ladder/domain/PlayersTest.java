package ladder.domain;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatCode;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

import java.util.List;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class PlayersTest {

    @DisplayName("이름을 입력하여 People을 생성한다.")
    @Test
    void peopleConstructTest() {
        assertThatCode(() -> new Players(List.of("명오", "제우스")))
                .doesNotThrowAnyException();
    }

    @DisplayName("중복된 이름이 입력되면 예외가 발생한다.")
    @Test
    void duplicateNameTest() {
        assertThatThrownBy(() -> new Players(
                List.of("명오", "명오")
        ))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("사람 수를 반환한다.")
    @Test
    void peopleCountTest() {
        Players players = new Players(List.of("명오", "제우스"));
        assertThat(players.count()).isEqualTo(2);
    }
}
