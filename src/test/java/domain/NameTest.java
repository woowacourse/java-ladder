package domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import static org.assertj.core.api.Assertions.assertThatNoException;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

class NameTest {

    @DisplayName("알맞은 이름을 입력하면 정상적으로 생성된다.")
    @Test
    void create_success() {
        assertThatNoException().isThrownBy(() -> new Name("name"));
    }

    @DisplayName("이름의 길이가 5글자를 초과하면 예외를 반환한다.")
    @ParameterizedTest
    @ValueSource(strings = {"lensix", "len7777"})
    void create_fail(String wrongName) {
        assertThatThrownBy(() -> new Name(wrongName))
                .isInstanceOf(IllegalArgumentException.class);
    }
}