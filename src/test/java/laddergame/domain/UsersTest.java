package laddergame.domain;

import static org.junit.jupiter.api.Assertions.*;

import java.util.List;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

class UsersTest {

    @DisplayName("게임 결과를 확인할 유저의 이름을 입력한다.")
    @ParameterizedTest
    @ValueSource(strings = {"민트", "헙크", "쥬니"})
    void validateResultCheckCommand_success(String name) {
        Users users = new Users(List.of(
                new User(new Name("민트"))
                , new User(new Name("헙크"))
                , new User(new Name("쥬니"))
        ));

        assertDoesNotThrow(() -> users.validateResultCheckCommand(name));
    }

    @DisplayName("존재하지 않는 유저의 게임 결과를 확인하려 하면 예외가 발생한다.")
    @ParameterizedTest
    @ValueSource(strings = {"레오", "테오", "하디"})
    void validateResultCheckCommand_fail(String name) {
        Users users = new Users(List.of(
                new User(new Name("민트"))
                , new User(new Name("헙크"))
                , new User(new Name("쥬니"))
        ));

        assertThrows(IllegalArgumentException.class, () -> users.validateResultCheckCommand(name));
    }

    @DisplayName("게임 결과 확인을 위한 유저 입력에서 \"all\"은 유효한 명령어다.")
    @Test
    void validateResultCheckCommand_all() {
        Users users = new Users(List.of(
                new User(new Name("민트"))
                , new User(new Name("헙크"))
                , new User(new Name("쥬니"))
        ));

        assertDoesNotThrow(() -> users.validateResultCheckCommand("all"));
    }
}
