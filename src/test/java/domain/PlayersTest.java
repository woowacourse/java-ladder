package domain;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class PlayersTest {

    @Test
    @DisplayName("중복된 이름의 참가자가 생성되지 않는지 확인")
    void validateDuplicateName() {
        Assertions.assertThatThrownBy(() -> Players.of("robin", "robin"))
                .isInstanceOf(IllegalStateException.class)
                .hasMessage("이름이 같은 참가자는 있을 수 없습니다.");
    }

}
