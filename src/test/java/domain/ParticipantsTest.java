package domain;

import constant.domain.ParticipantsExceptionMessage;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThatThrownBy;

class ParticipantsTest {

    @Test
    @DisplayName("참가자가 " + Participants.MIN_OF_PARTICIPANTS_COUNT + "명 미만이면 예외가 발생한다.")
    void lessThanTwoExceptionTest() {
        List<String> oneNames = List.of("a");

        assertThatThrownBy(() -> new Participants(oneNames))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage(ParticipantsExceptionMessage.OUT_OF_RANGE_PARTICIPANTS_COUNT.getExceptionMessage());
    }

    @Test
    @DisplayName("참가자가 " + Participants.MAX_OF_PARTICIPANTS_COUNT + "명 초과면 예외가 발생한다.")
    void moreThanFiftyExceptionTest() {
        List<String> fiftyOneNames = List.of(
                "a", "b", "c", "d", "e", "f", "g", "h", "i", "j", "k", "l", "m",
                "n", "o", "p", "q", "r", "s", "t", "u", "v", "w", "x", "y", "z",
                "A", "B", "C", "D", "E", "F", "G", "H", "I", "J", "K", "L", "M",
                "N", "O", "P", "Q", "R", "S", "T", "U", "V", "W", "X", "Y");

        assertThatThrownBy(() -> new Participants(fiftyOneNames))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage(ParticipantsExceptionMessage.OUT_OF_RANGE_PARTICIPANTS_COUNT.getExceptionMessage());
    }

    @Test
    @DisplayName("참가자 이름에 중복이 있으면 예외가 발생한다.")
    void duplicateExceptionTest() {
        List<String> duplicateNames = List.of("siso", "siso");

        assertThatThrownBy(() -> new Participants(duplicateNames))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage(ParticipantsExceptionMessage.DUPLICATE_PARTICIPANTS.getExceptionMessage());
    }

    @Test
    @DisplayName("존재하지 않는 참가자의 이름이 입력되면 예외가 발생한다.")
    void noExistNameExceptionTest() {
        List<String> names = List.of("siso", "atto");
        Participants participants = new Participants(names);

        assertThatThrownBy(() -> participants.getIndexOfName("tacan"))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage("[ERROR] 존재하지 않는 참가자입니다.");
    }

}
