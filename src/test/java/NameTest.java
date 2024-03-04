import domain.Name;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.NullAndEmptySource;
import org.junit.jupiter.params.provider.ValueSource;

import static message.ErrorMessage.*;
import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

public class NameTest {

    @DisplayName("플레이어의 이름객체를 정상적으로 생성한다.")
    @Test
    void createName() {
        assertThat(new Name("dodo").getName()).isEqualTo("dodo");
    }

    @DisplayName("플레이어의 이름이 5자 초과이면 예외가 발생한다.")
    @Test
    void createNameWithOverNameSize() {
        assertThatThrownBy(() -> new Name("dodododo"))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining(INVALID_PLAYER_NAME_SIZE_EXCEPTION.getMessage());

    }

    @DisplayName("플레이어의 이름이 영어가 아닌 경우 예외가 발생한다.")
    @ParameterizedTest
    @ValueSource(strings = {"도도", "c!apy", "123"})
    void createNameWithNotEnglish(String invalidName) {
        assertThatThrownBy(() -> new Name(invalidName))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining(INVALID_PLAYER_NAME_LANGUAGE_EXCEPTION.getMessage());
    }

    @DisplayName("플레이어의 이름이 Null 또는 빈 문자열인 경우 예외가 발생한다.")
    @ParameterizedTest
    @NullAndEmptySource
    void createNameWithBlank(String invalidName) {
        assertThatThrownBy(() -> new Name(invalidName))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining(NO_PLAYER_NAME_EXCEPTION.getMessage());
    }
}
