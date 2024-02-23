package model;

import static org.assertj.core.api.Assertions.assertThatThrownBy;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class ParticipantTest {

    @DisplayName("참여자의 이름이 5글자 이하일 시 생성에 성공한다.")
    @Test
    void participantName() {
        Assertions.assertThatCode(() -> new Participant("pobi"))
                .doesNotThrowAnyException();
    }

    @DisplayName("참가자의 이름은 null일 수 없다.")
    @Test
    void participantNullNameThrowException() {
        assertConstructorThrowExceptionWithMessage(null);
    }

    @DisplayName("참가자의 이름은 공백일 수 없다")
    @Test
    void participantBlankNameThrowException() {
        assertConstructorThrowExceptionWithMessage(" ");
    }

    @DisplayName("참가자의 이름은 빈 문자일 수 없다")
    @Test
    void participantEmptyNameThrowException() {
        assertConstructorThrowExceptionWithMessage("");
    }

    @DisplayName("참가자의 이름은 최대 5글자까지 부여할 수 있다.")
    @Test
    void participantNameOverFiveThrowException() {
        assertConstructorThrowIllegalArgumentException("sdfsfs", "참여자의 이름은 최대 5글자입니다.");
    }

    private void assertConstructorThrowExceptionWithMessage(String name) {
        assertConstructorThrowIllegalArgumentException(name, "참가자의 이름은 null 이거나 공백일 수 없습니다.");
    }

    private void assertConstructorThrowIllegalArgumentException(String name, String message) {
        assertThatThrownBy(() -> new Participant(name))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage(message);
    }
}
