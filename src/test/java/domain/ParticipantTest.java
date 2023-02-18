package domain;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatIllegalArgumentException;
import static org.assertj.core.api.Assertions.assertThatNoException;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.EmptySource;
import org.junit.jupiter.params.provider.ValueSource;

class ParticipantTest {

    @ParameterizedTest(name = "이름은 1글자 이상 5글자 이하여야한다")
    @ValueSource(strings = {"1", "12345"})
    void test_person_name_length_success(String name) {
        assertThatNoException().isThrownBy(() -> new Participant(name));
    }

    @ParameterizedTest(name = "이름은 1글자 미만 5글자 초과하면 IllegalArgumentException을 던진다")
    @ValueSource(strings = {"", "123456"})
    @EmptySource
    void test_person_name_length_fail(String name) {
        assertThatIllegalArgumentException().isThrownBy(() -> new Participant(name));
    }

    @ParameterizedTest(name = "이름이 같으면 같은 참가자이다")
    @CsvSource(value = {"땡칠,땡칠,true", "땡칠,땡구,false"}, delimiter = ',')
    void participant_distinguished_by_their_name(String name, String otherName, boolean isTwoEquals) {
        assertThat(new Participant(name).equals(new Participant(otherName)))
                .isEqualTo(isTwoEquals);
    }
}
