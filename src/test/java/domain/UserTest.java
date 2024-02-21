package domain;

import domain.User;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.*;

class UserTest {

    @Test
    @DisplayName("사용자를 생성한다.")
    void createUser() {
        User user = new User();
        assertThatCode(() -> new User())
                .doesNotThrowAnyException();
    }
}
