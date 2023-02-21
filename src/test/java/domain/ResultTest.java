package domain;

import static org.assertj.core.api.Assertions.assertThatThrownBy;
import static org.junit.jupiter.api.Assertions.*;

import controller.LadderGameController;
import domain.user.User;
import domain.user.Users;
import java.util.List;
import org.junit.jupiter.api.Assertions;
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

    @DisplayName("입력받은 값과 같은 이름의 유저가 없으면 실패한다.")
    @Test
    void shouldFailInputIsNotUser() {
        Users users = new Users(List.of(new User("dino"), new User("mango")));
        String input = "dinos";
        assertThatThrownBy(() -> LadderGameController.checkNameInUsers(input, users));
    }

    @DisplayName("결과를 보고싶은 유저로 'all'을 입력받으면 성공한다.")
    @Test
    void shouldSuccessInputIsAll() {
        Users users = new Users(List.of(new User("dino"), new User("mango")));
        String input = "all";
        assertDoesNotThrow(() -> LadderGameController.checkNameInUsers(input, users));
    }

    @DisplayName("입력받은 유저의위치에 해당하는 결과값을 반환한다.")
    @Test
    void shouldSuccessFindResultByUser() {
        List<String> names = List.of("dino", "mango", "study");
        assertEquals(LadderGameController.findResultByUser(names, "mango"), 1);
    }
}
