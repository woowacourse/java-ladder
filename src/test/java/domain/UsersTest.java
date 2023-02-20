package domain;

import static org.assertj.core.api.Assertions.assertThatCode;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

import java.util.List;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class UsersTest {

    @Test
    @DisplayName("같은 이름을 가진 User가 존재하면 예외를 던진다.")
    void should_throwException_when_duplicatedNameExist() {
        User kodak = new User("kodak");
        User duplicatedKodak = new User("kodak");
        User polo = new User("polo");
        User poz = new User("poz");

        List<User> users = List.of(kodak, duplicatedKodak, polo, poz);

        assertThatThrownBy(() -> new Users(users))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    @DisplayName("같은 이름을 가진 User가 존재하지 않는다면 예외를 던지지 않는다.")
    void should_notThrowException_when_duplicatedNameNotExist() {
        User kodak = new User("kodak");
        User polo = new User("polo");
        User poz = new User("poz");

        List<User> users = List.of(kodak, polo, poz);

        assertThatCode(() -> new Users(users))
                .doesNotThrowAnyException();
    }
}
