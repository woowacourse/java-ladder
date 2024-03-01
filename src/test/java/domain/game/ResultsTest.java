package domain.game;

import domain.user.Users;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThatThrownBy;

class ResultsTest {

    @Test
    @DisplayName("Result 수는 사용자 수와 일치해야 한다.")
    void equalToPersonCount() {
        //given
        List<String> usernames = List.of("honux", "crong", "jk");
        Users users = new Users(usernames);
        List<Result> prizes = List.of(
                new Result("꽝"),
                new Result("5000"),
                new Result("꽝"),
                new Result("3000"));
        //when
        //then
        assertThatThrownBy(() -> Results.of(prizes, users))
                .isInstanceOf(IllegalArgumentException.class);
    }
}
