import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class UserTest {
    @Test
    @DisplayName("유저가 제대로 생성되는지 확인")
    void userTest() {
        Assertions.assertDoesNotThrow(() -> new User("홍실"));
    }

    @Test
    @DisplayName("유저가 이름은 5글자 이하여야한다.")
    void userName5overTest() {
        Assertions.assertThrows(IllegalArgumentException.class, () -> new User("홍실썬샷페어"));
    }

    @Test
    @DisplayName("유저의 이름이 공백인지 확인")
    void userNameBlankTest() {
        Assertions.assertThrows(IllegalArgumentException.class, () -> new User(" "));
    }
}
