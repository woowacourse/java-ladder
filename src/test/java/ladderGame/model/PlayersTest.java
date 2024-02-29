package ladderGame.model;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThatThrownBy;

class PlayersTest {
    @Test
    @DisplayName("중복된 이름이 있을 시 예외처리 된다.")
    void validateDuplicationName() {
        List<String> names = List.of("초롱", "초롱");
        assertThatThrownBy(() -> new Players(names))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    @DisplayName("이름이 두 명보다 적으면 예외처리 된다.")
    void validateLessThanMinimum() {
        List<String> names = List.of("켬미");
        assertThatThrownBy(() -> new Players(names))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    @DisplayName("index를 알고 싶은 참가자 이름이 존재하지 않으면 예외처리 된다.")
    void indexOfByName() {
        List<String> names = List.of("켬미", "배키");
        Players players = new Players(names);

        assertThatThrownBy(() -> players.indexOfByName("포비"))
                .isInstanceOf(IllegalArgumentException.class);
    }
}
