package domain;

import static domain.Participants.Participants.MAX_OF_PARTICIPANTS_COUNT;
import static domain.Participants.Participants.MIN_OF_PARTICIPANTS_COUNT;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

import domain.Participants.Participants;
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
                .hasMessage("[ERROR] 참가자는 " + MIN_OF_PARTICIPANTS_COUNT + "명 이상 "
                        + MAX_OF_PARTICIPANTS_COUNT + "명 이하여야 합니다.");
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
                .hasMessage("[ERROR] 참가자는 " + MIN_OF_PARTICIPANTS_COUNT + "명 이상 "
                        + MAX_OF_PARTICIPANTS_COUNT + "명 이하여야 합니다.");
    }

    @Test
    @DisplayName("참가자 이름에 중복이 있으면 예외가 발생한다.")
    void duplicateExceptionTest() {
        List<String> names = List.of("siso", "siso");

        assertThatThrownBy(() -> new Participants(names))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage("[ERROR] 참가자 이름은 중복될 수 없습니다.");
    }

    @Test
    @DisplayName("참가자 수와 들어오는 수가 같은지 확인한다.")
    void isMatchCountTest() {
        List<String> names = List.of("siso", "atto");
        Participants participants = new Participants(names);
        participants.isMatchCount(2);
    }

}
