package domain;

import static org.assertj.core.api.Assertions.assertThatCode;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

public class NameTest {

    @DisplayName("플레이어의 이름객체를 정상적으로 생성한다.")
    @Test
    void createName() {
        assertThatCode(() -> new Name("dodo"))
                .doesNotThrowAnyException();
    }

    @DisplayName("플레이어의 이름이 5자 초과이면 예외가 발생한다.")
    @Test
    void createNameWithOverNameSize() {
        assertThatThrownBy(() -> new Name("dodododo"))
                .isInstanceOf(IllegalArgumentException.class);

    }

    @DisplayName("플레이어의 이름이 영어가 아닌 경우 예외가 발생한다.")
    @ParameterizedTest
    @ValueSource(strings = {"도도", "c!apy", "123"})
    void createNameWithNotEnglish(String invalidName) {
        assertThatThrownBy(() -> new Name(invalidName))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("플레이어의 이름이 빈 문자열인 경우 예외가 발생한다.")
    @Test
    void createNameWithBlank() {
        assertThatThrownBy(() -> new Name(""))
                .isInstanceOf(IllegalArgumentException.class);
    }
}
