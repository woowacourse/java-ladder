package ladderGame.model;

import static org.assertj.core.api.Assertions.assertThatThrownBy;

import java.util.List;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class PrizesTest {

    @Test
    @DisplayName("실행 결과의 수가 참가자의 수와 일치하지 않는 경우 예외처리 된다.")
    void validatePrizesCount() {
        List<String> prizes = List.of("꽝", "5000", "꽝");
        assertThatThrownBy(() -> new Prizes(prizes, 4))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage("실행 결과의 수는 참가자의 수와 일치해야 합니다.");
    }
}
