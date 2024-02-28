package domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThatThrownBy;

class ParticipantsTest {

    @DisplayName("참가자 이름 0명 입력 예외 처리")
    @ParameterizedTest
    @ValueSource(strings = {",,,", ""})
    void validateNamesLengthTest(String actual) {
        List<String> names = List.of(actual.split(","));

        assertThatThrownBy(() -> new Participants(names))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("참가자들 이름 중복 에외 처리")
    @Test
    void validateDuplicatedNameTest() {
        assertThatThrownBy(() -> new Participants(List.of("test1", "test2", "test2")))
                .isInstanceOf(IllegalArgumentException.class);
    }
}
