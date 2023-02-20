package domain;

import static org.assertj.core.api.Assertions.assertThatThrownBy;

import domain.user.User;
import domain.user.Users;
import java.util.List;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class ResultTest {
    @DisplayName("입력받은 결과의 수가 유저 수와 다르면 실패한다.")
    @Test
    void shouldFailResultNotEqualUserLength() {
        Users users = new Users(List.of(new User("dino"), new User("mango")));
        List<String> results = List.of("꽝", "1000", "꽝", "5000");
        assertThatThrownBy(() -> new Results(results, users.getPersonCount()));
    }
}
