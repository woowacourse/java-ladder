package domain;

import static org.assertj.core.api.Assertions.assertThatThrownBy;

import exception.domain.ParticipantsExceptionMessage;
import java.util.List;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

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
        List<String> fiftyNames = List.of(
                "a", "b", "c", "d", "e", "f", "g", "h", "i", "j", "k", "l", "m",
                "n", "o", "p", "q", "r", "s", "t", "u", "v", "w", "x", "y", "z",
                "A", "B", "C", "D", "E", "F", "G", "H", "I", "J", "K", "L", "M",
                "N", "O", "P", "Q", "R", "S", "T", "U", "V", "W", "X", "Y");

        assertThatThrownBy(() -> new Participants(fiftyNames))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage(ParticipantsExceptionMessage.OUT_OF_RANGE_PARTICIPANTS_COUNT.getExceptionMessage());
    }

    @Test
    @DisplayName("참가자 이름에 중복이 있으면 예외가 발생한다.")
    void duplicateExceptionTest() {
        List<String> names = List.of("siso", "siso");

        assertThatThrownBy(() -> new Participants(names))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage(ParticipantsExceptionMessage.DUPLICATE_PARTICIPANTS.getExceptionMessage());
    }

    @Test
    @DisplayName("참가자 수와 들어오는 수가 같은지 확인한다.")
    void isMatchCountTest() {
        List<String> names = List.of("siso", "atto");
        Participants participants = new Participants(names);
        participants.isMatchCount(2);
    }

}
