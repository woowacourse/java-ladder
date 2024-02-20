package ladderGame.model;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThatCode;
import static org.assertj.core.api.Assertions.assertThatThrownBy;
import static org.junit.jupiter.api.Assertions.*;

class PlayersTest {

    @Test
    @DisplayName("문자열 리스트를 인자로 받아서 참여자들을 생성한다.")
    void createPlayers() {
        List<String> names = List.of("켬미", "초롱");
        assertThatCode(() -> new Players(names));
    }

    @Test
    @DisplayName("중복된 이름이 있을 시 예외처리 된다.")
    void validateDuplicationName() {
        List<String> names = List.of("초롱","초롱");
        assertThatThrownBy(() -> new Players(names))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage("참여자들의 이름은 중복될 수 없습니다.");
    }

    @Test
    @DisplayName("이름이 두 명보다 적으면 예외처리 된다.")
    void validateLessThanMinimum() {
        List<String> names = List.of("켬미");
        assertThatThrownBy(() -> new Players(names))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage("참여자의 이름은 두 개 이상이어야 합니다.");
    }

}