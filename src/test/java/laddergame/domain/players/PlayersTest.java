package laddergame.domain.players;

import static org.assertj.core.api.Assertions.assertThatThrownBy;

import java.util.List;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.DisplayNameGeneration;
import org.junit.jupiter.api.DisplayNameGenerator;
import org.junit.jupiter.api.Test;

@DisplayNameGeneration(DisplayNameGenerator.ReplaceUnderscores.class)
class PlayersTest {

    @Test
    @DisplayName("참여자 수가 2명 미만이면 예외를 던진다.")
    void should_ThrowException_When_CountLessThan2() {
        List<String> names = List.of("주노");

        assertThatThrownBy(() -> Players.of(names))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining("참여자는 2명 이상이어야 합니다.");
    }

    @Test
    @DisplayName("중복 이름이 존재하면 예외를 던진다.")
    void should_ThrowException_When_NamesDuplicated() {
        List<String> names = List.of("주노", "주노");

        assertThatThrownBy(() -> Players.of(names))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining("참여자 간 이름은 중복되지 않아야 합니다.");
    }
}
