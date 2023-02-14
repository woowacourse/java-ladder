import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class UserTest {
    @DisplayName("사람 이름이 6글자일 때 실패한다.")
    @Test
    void should_fail_name_length_6() {
        String name = "asdfgh";
        assertThrows(IllegalArgumentException.class, () -> User.validateNameLength(name));
    }

    @DisplayName("사람 이름이 0글자일 때 실패한다.")
    @Test
    void should_fail_name_length_zero() {
        String name = "";
        assertThrows(IllegalArgumentException.class, () -> User.validateNameLength(name));
    }
}
