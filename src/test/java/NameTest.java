import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

public class NameTest {
    @Nested
    @DisplayName("이름은 최대 5자여야 한다.")
    class NameLength {

        @DisplayName("이름이 1~5자이면 성공한다.")
        @ParameterizedTest
        @ValueSource(strings = {"1", "12345"})
        void nameLengthValidateSuccess(String source) {
            Assertions.assertThatCode(() -> new Name(source))
                    .doesNotThrowAnyException();
        }

        @DisplayName("이름이 6자 이상이면 실패한다.")
        @Test
        void nameLengthValidateFail() {
            Assertions.assertThatThrownBy(() -> new Name("123456"))
                    .isInstanceOf(IllegalArgumentException.class);
        }
    }
}
