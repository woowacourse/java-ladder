package ladder.domain;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import static org.assertj.core.api.Assertions.assertThatNoException;
import static org.assertj.core.api.Assertions.assertThatThrownBy;
import static org.junit.jupiter.api.Assertions.*;

class PersonTest {
    @ParameterizedTest
    @ValueSource(strings = {"aaaaaa", "", "1234567"})
    public void 생성_길이_예외던지기(String name) {
        assertThatThrownBy(() -> new Person(name))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @ParameterizedTest
    @ValueSource(strings = {"abc ", "  ", "a b", " abc"})
    public void 생성_공백_예외던지기(String name) {
        assertThatThrownBy(() -> new Person(name))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @ParameterizedTest
    @ValueSource(strings = {"abc", "에밀과홍고", "에"})
    public void 정상_생성(String name) {
        assertThatNoException().isThrownBy(() -> new Person(name));
    }
}