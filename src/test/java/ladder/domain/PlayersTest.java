package ladder.domain;

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
        List<Player> dummy = List.of(new Player("주노"));

        assertThatThrownBy(() -> new Players(dummy))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining("참가자는 2명 이상이어야 합니다.");
    }
}
