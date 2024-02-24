package model;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.assertj.core.api.Assertions.assertThatThrownBy;

public class ParticipantTest {

    @DisplayName("참여자의 이름이 5글자 이하일 시 생성에 성공한다.")
    @Test
    void participantName() {
        Assertions.assertThatCode(() -> new Participant("pobi"))
                .doesNotThrowAnyException();
    }

    static Stream<Arguments> inputName() {
        return Stream.of(
                Arguments.of("abcdef", "참가자의 이름은 최대 5글자까지 부여할 수 있다.", "참여자의 이름은 최대 5글자입니다."),
                Arguments.of(null, "참가자의 이름은 null일 수 없다.", "참가자의 이름은 null 이거나 공백일 수 없습니다."),
                Arguments.of(" ", "참가자의 이름은 공백일 수 없다", "참가자의 이름은 null 이거나 공백일 수 없습니다."),
                Arguments.of("", "참가자의 이름은 빈 문자일 수 없다", "참가자의 이름은 null 이거나 공백일 수 없습니다.")
        );
    }

    @DisplayName("참여자의 이름이 잘못 입력된 경우 예외가 발생한다.")
    @ParameterizedTest(name = "{1}")
    @MethodSource("inputName")
    void participantNameIsNull(String name, String reason, String message) {
        assertThatThrownBy(() -> new Participant(name))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage(message);
    }
}
