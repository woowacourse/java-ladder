package model;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.NullAndEmptySource;
import org.junit.jupiter.params.provider.ValueSource;

import static org.assertj.core.api.Assertions.*;

class ParticipantTest {

    @DisplayName("String 값을 받아 Participant 객체를 생성한다.")
    @Test
    void createParticipant() {
        String given = "lilly";
        assertThatCode(() -> new Participant(given))
                .doesNotThrowAnyException();
    }

    @DisplayName("참여할 사람의 이름은 5자를 초과할 수 없다.")
    @Test
    void validateNameLength() {
        String given = "123456";
        assertThatThrownBy(() -> new Participant(given))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage("[ERROR] 참여자 이름의 길이는 5자를 초과할 수 없다.");
    }

    @DisplayName("참여할 사람의 이름은 null이거나 공백이면 안된다.")
    @ParameterizedTest
    @NullAndEmptySource
    @ValueSource(strings = {"", "     "})
    void validateNameNotNullAndNotBlank(String given) {
        assertThatThrownBy(() -> new Participant(given))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage("[ERROR] 참여자 이름은 null이거나 공백일 수 없다.");
    }
}
