package domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.EmptySource;
import org.junit.jupiter.params.provider.ValueSource;

import static org.assertj.core.api.Assertions.assertThatThrownBy;

class ParticipantTest {

    @DisplayName("이름의 글자 수가 0이거나 5글자 이상일 경우 예외처리")
    @EmptySource
    @ValueSource(strings = {"123456", "1234567"})
    @ParameterizedTest
    void validateNameLengthTest(String name) {
        assertThatThrownBy(() -> new Participant(name))
                .isInstanceOf(IllegalArgumentException.class);
    }
}
