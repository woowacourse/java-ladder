package domain;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.EmptySource;
import org.junit.jupiter.params.provider.ValueSource;

import static org.assertj.core.api.Assertions.assertThatIllegalArgumentException;
import static org.assertj.core.api.Assertions.assertThatNoException;

class PersonTest {

    @ParameterizedTest(name = "이름은 1글자 이상 5글자 이하여야한다")
    @ValueSource(strings = {"1", "12345"})
    void test_person_name_length_success(String name) {
        assertThatNoException().isThrownBy(() -> new Person(name));
    }

    @ParameterizedTest(name = "이름은 1글자 미만 5글자 초과하면 IllegalArgumentException을 던진다")
    @ValueSource(strings = {"", "123456"})
    @EmptySource
    void test_person_name_length_fail(String name) {
        assertThatIllegalArgumentException().isThrownBy(() -> new Person(name));
    }
}
