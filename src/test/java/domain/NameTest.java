package domain;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import static org.assertj.core.api.Assertions.assertThatNoException;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

class NameTest {

    @Test
    void create_success() {
        assertThatNoException().isThrownBy(() -> new Name("name"));
    }

    @ParameterizedTest
    @ValueSource(strings = {"lensix","len7777"})
    void create_fail(String wrongName) {
        assertThatThrownBy(() -> new Name(wrongName))
                .isInstanceOf(IllegalArgumentException.class);
    }
}