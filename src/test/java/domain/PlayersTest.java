package domain;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import java.util.List;

public class PlayersTest {

    @Test
    @DisplayName("중복된 닉네임을 입력하면 예외 발생")
    void validateDuplicateName() {
        Assertions.assertThatThrownBy(() -> new Players(List.of("a", "b", "a")))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage("[ERROR] 중복된 이름입니다.");
    }
}
