package domain.db;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import static org.assertj.core.api.Assertions.assertThatCode;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

class NameTest {

    @ParameterizedTest
    @ValueSource(strings = {"a", "abcde", "wq21 3", "1 2 3 4 5 "})
    @DisplayName("정상적인 이름은 예외를 발생하지 않는다")
    void normal_name_doesnt_throw_exception(String name) {
        assertThatCode(() -> new Name(name)).doesNotThrowAnyException();
    }

    @ParameterizedTest
    @ValueSource(strings = {"", " ", "acsbdd", "ds sd d d"})
    @DisplayName("공백을 제거하고 길이 정책에 어긋나면 예외가 발생한다")
    void throw_exception_if_conflict_with_length_policy_after_remove_blank(String name) {
        assertThatThrownBy(() -> new Name(name))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContainingAll("이름의 길이는", "자 이어야 합니다.");
    }

    @ParameterizedTest
    @ValueSource(strings = {"망크", "+"})
    @DisplayName("이름이 영어와 숫자가 아니라면 예외가 발생한다")
    void name_not_alphanumeric_throw_exception(String name) {
        assertThatThrownBy(() -> new Name(name))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage("이름은 영어와 숫자만 허용합니다.");
    }
}
