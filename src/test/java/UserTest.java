import domain.User;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class UserTest {

    @Test
    @DisplayName("사용자를 생성한다.")
    void createUser() {
        User user = new User();
        Assertions.assertThatCode(() -> new User())
                .doesNotThrowAnyException();
    }

}
