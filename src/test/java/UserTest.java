import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class UserTest {

    public static final int NAME_LENGTH_LIMIT = 5;

    @DisplayName("사람 이름이 " + NAME_LENGTH_LIMIT + "자 초과일 때 실패한다.")
    @Test
    void shouldFailNameLengthOver() {
        String name = "abcdef";
        assertThrows(IllegalArgumentException.class, () -> User.validateNameLength(name));
    }

    @DisplayName("사람 이름이 0글자일 때 실패한다.")
    @Test
    void shouldFailNameLengthZero() {
        String name = "";
        assertThrows(IllegalArgumentException.class, () -> User.validateNameLength(name));
    }

    @DisplayName("사람 이름에 특수 문자가 포함되면 실패한다.")
    @Test
    void shouldFailNameWithSpecialCharacter() {
        String name = "ab#c";
        assertThrows(IllegalArgumentException.class, () -> User.validateNameFormat(name));
    }

    @DisplayName("사람 이름에 숫자가 포함되면 실패한다.")
    @Test
    void shouldFailNameWithNumber() {
        String name = "ab23c";
        assertThrows(IllegalArgumentException.class, () -> User.validateNameFormat(name));
    }

    @DisplayName("사람 이름에 한글이 포함되면 실패한다.")
    @Test
    void shouldFailNameWithKorean() {
        String name = "ab가c";
        assertThrows(IllegalArgumentException.class, () -> User.validateNameFormat(name));
    }

    @DisplayName("사람 이름에 공백이 포함되면 실패한다.")
    @Test
    void shouldFailNameWithBlank() {
        String name = "ab c";
        assertThrows(IllegalArgumentException.class, () -> User.validateNameFormat(name));
    }
}
