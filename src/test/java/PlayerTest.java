import domain.Player;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import static org.assertj.core.api.Assertions.assertThatIllegalArgumentException;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

public class PlayerTest {
    @ParameterizedTest
    @ValueSource(strings = {"", " ", "baekho"})
    @DisplayName("이름이 1~5자가 아니면 예외를 발생시킨다.")
    void invalidName(String name) {
        assertThatIllegalArgumentException().isThrownBy(() -> new Player(name));
    }

    @DisplayName("참여자의 이름으로 all을 입력받으면 예외를 발생시킨다.")
    @Test
    void nameIsNotAll() {
        assertThatThrownBy(() -> new Player("all"))
                .isInstanceOf(IllegalArgumentException.class);
    }
}
