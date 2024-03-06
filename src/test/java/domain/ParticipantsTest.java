package domain;

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
                .hasMessage(Participants.OUT_OF_RANGE_PARTICIPANTS_COUNT);
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
                .hasMessage(Participants.OUT_OF_RANGE_PARTICIPANTS_COUNT);
    }

    @Test
    @DisplayName("참가자 이름에 중복이 있으면 예외가 발생한다.")
    void duplicateExceptionTest() {
        List<String> duplicateNames = List.of("siso", "siso");

        assertThatThrownBy(() -> new Participants(duplicateNames))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage(Participants.DUPLICATE_PARTICIPANTS);
    }

}
