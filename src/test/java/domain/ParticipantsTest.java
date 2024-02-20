package domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThatThrownBy;

class ParticipantsTest {

    @Test
    @DisplayName("참가자가 2명 미만이면 예외가 발생한다.")
    void lessThanTwoExceptionTest() {
        String[] names = {"a"};
        assertThatThrownBy(() -> new Participants(names))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage("[ERROR] 참가자는 2명 이상이어야 합니다.");
    }

    @Test
    @DisplayName("참가자가 50명 초과면 예외가 발생한다.")
    void moreThanFiftyExceptionTest() {
        String[] names = {
                "a", "b", "c", "d", "e", "f", "g", "h", "i", "j", "k", "l", "m",
                "n", "o", "p", "q", "r", "s", "t", "u", "v", "w", "x", "y", "z",
                "A", "B", "C", "D", "E", "F", "G", "H", "I", "J", "K", "L", "M",
                "N", "O", "P", "Q", "R", "S", "T", "U", "V", "W", "X", "Y"};

        assertThatThrownBy(() -> new Participants(names))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage("[ERROR] 참가자는 50명 이하여야 합니다.");
    }

    @Test
    @DisplayName("참가자 이름에 중복이 있으면 예외가 발생한다.")
    void duplicateExceptionTest() {
        String[] names = {"siso", "siso"};

        assertThatThrownBy(() -> new Participants(names))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage("[ERROR] 참가자 이름은 중복될 수 없습니다.");
    }
}