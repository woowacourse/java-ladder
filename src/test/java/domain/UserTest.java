package domain;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertThrows;


public class UserTest {
    @Test
    void 빈_문자열이거나_이름이_없는경우() {
        assertThrows(IllegalArgumentException.class, () -> {
            new User("");
        });
        assertThrows(IllegalArgumentException.class, () -> {
            new User(null);
        });
    }

    @Test
    void 다섯자_초과() {
        assertThrows(IllegalArgumentException.class, () -> {
           new User("pobico");
        });
    }

    @Test
    void 유효한_이름() {
        assertThat(new User("pobi")).isEqualTo(new User("pobi"));
    }
}
