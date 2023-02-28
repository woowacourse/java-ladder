package domain;

import static org.assertj.core.api.Assertions.assertThatThrownBy;
import static org.junit.jupiter.api.Assertions.*;
import static view.InputView.RESULT_LENGTH_ERROR;
import static domain.user.Users.NOT_CONTAIN_NAME_ERROR;

import domain.game.Results;
import domain.user.Users;
import java.util.List;
import org.junit.jupiter.api.*;

public class ResultTest {
    @DisplayName("입력받은 결과의 수가 유저 수와 다르면 실패한다.")
    @Test
    void shouldFailResultNotEqualUserLength() {
        Users users = new Users(List.of("dino", "mango"));
        List<String> results = List.of("꽝", "1000", "꽝", "5000");
        assertThatThrownBy(() -> new Results(results, users.getPersonCount()))
                .hasMessageContaining(RESULT_LENGTH_ERROR);
    }

    @DisplayName("입력받은 결과의 수가 유저 수와 같으면 성공한다.")
    @Test
    void shouldSuccessResultEqualUserLength() {
        Users users = new Users(List.of("dino", "mango","study","java"));
        List<String> results = List.of("꽝", "1000", "꽝", "5000");
        assertDoesNotThrow(() -> new Results(results, users.getPersonCount()));
    }

    @DisplayName("입력받은 값과 같은 이름의 유저가 없으면 실패한다.")
    @Test
    void shouldFailInputIsNotUser() {
        Users users = new Users(List.of("dino", "mango"));
        String input = "dinos";
        assertThatThrownBy(() -> users.checkNameInUsers(input))
                .hasMessageContaining(NOT_CONTAIN_NAME_ERROR);
    }

    @DisplayName("입력받은 값과 같은 이름의 유저가 있으면 성공한다.")
    @Test
    void shouldSuccessInputIsNotUser() {
        Users users = new Users(List.of("dino", "mango"));
        String input = "dino";
        assertDoesNotThrow(() -> users.checkNameInUsers(input));
    }

    @DisplayName("결과를 보고싶은 유저로 'all'을 입력받으면 성공한다.")
    @Test
    void shouldSuccessInputIsAll() {
        Users users = new Users(List.of("dino", "mango"));
        String input = "all";
        assertDoesNotThrow(() -> users.checkNameInUsers(input));
    }
}
