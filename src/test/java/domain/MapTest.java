package domain;

import exception.InvalidLadderCountException;
import exception.NotNumberException;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class MapTest {

    @DisplayName("높이와 사다리 개수가 조건에 맞는 경우 객체를 생성한다.")
    @Test
    void mapSuccess() {
        try {
            new Map("3", 2);
        } catch (IllegalArgumentException exception) {
            Assertions.fail("높이가 숫자인 경우 객체가 생성되어야 합니다.");
        }
    }

    @DisplayName("높이가 숫자가 아닌 경우 오류를 던진다.")
    @Test
    void heightNotDigit() {
        Assertions.assertThatThrownBy(() -> new Map("a", 2)).isExactlyInstanceOf(NotNumberException.class);
    }

    @DisplayName("높이가 null일 경우 오류를 던진다.")
    @Test
    void heightNull() {
        Assertions.assertThatThrownBy(() -> new Map(null, 2)).isExactlyInstanceOf(NotNumberException.class);
    }

    @DisplayName("높이가 공백으로만 이루어져 있을 경우 오류를 던진다.")
    @Test
    void heightBlank() {
        Assertions.assertThatThrownBy(() -> new Map("     ", 2)).isExactlyInstanceOf(NotNumberException.class);
    }

    @DisplayName("사다리 개수가 10보다 큰 경우 오류를 던진다.")
    @Test
    void ladderCountOver10() {
        Assertions.assertThatThrownBy(() -> new Map("3", 10)).isExactlyInstanceOf(InvalidLadderCountException.class);
    }

    @DisplayName("사다리 개수가 1보다 작은 경우 오류를 던진다.")
    @Test
    void ladderCountUnder1() {
        Assertions.assertThatThrownBy(() -> new Map("3", 0)).isExactlyInstanceOf(InvalidLadderCountException.class);
    }
}
