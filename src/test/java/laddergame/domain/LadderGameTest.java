package laddergame.domain;

import static org.assertj.core.api.Assertions.assertThatThrownBy;

import java.util.List;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class LadderGameTest {

    @Test
    @DisplayName("참여자 수가 2 미만이면 예외를 던진다.")
    void should_ThrowException_When_PlayersCountLessThan2() {
        assertThatThrownBy(() -> new LadderGame(List.of("name")))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining("참여자는 2명 이상이어야 합니다.");
    }
}
