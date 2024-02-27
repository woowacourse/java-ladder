package ladderGame.model;

import java.util.List;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import static org.assertj.core.api.Assertions.assertThatCode;
import static org.assertj.core.api.Assertions.assertThatThrownBy;
import static org.junit.jupiter.api.Assertions.assertAll;

class NameTest {

    @Test
    @DisplayName("이름은 6글자 이상일 시 예외처리 된다.")
    void validateNameLength() {
        assertThatThrownBy(() -> new Name("켬미켬미켬미"))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage("이름은 최대 5글자까지 가능합니다.");
    }

    @ParameterizedTest
    @ValueSource(strings = {"", " ", "초롱", "ab cd"})
    @DisplayName("이름에 영문과 숫자 외에 입력이 들어가는 경우 예외처리 된다.")
    void validateUndefinedName(String name) {
        assertThatThrownBy(() -> new Name(name))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage("이름은 영문과 숫자로만 입력해야 합니다.");
    }

    @ParameterizedTest
    @ValueSource(strings = {"pobi", "pobi2", "12345"})
    @DisplayName("이름은 영문과 숫자만 입력할 수 있다.")
    void validateAvailableName(String name) {
        assertThatCode(() -> {
            new Name(name);
        }).doesNotThrowAnyException();
    }

    @Test
    @DisplayName("참여자 목록에 있지 않은 사람을 입력할 경우 예외처리 된다")
    void inputCommand() {
        Players players = new Players(List.of("pobi", "crong", "honux", "jk"));

        assertAll(
                () -> assertThatThrownBy(() -> new Name("popo", players))
                        .isInstanceOf(IllegalArgumentException.class)
                        .hasMessage("참여자 목록 중에서 골라야 합니다."),
                () -> assertThatCode(() -> new Name("pobi", players))
                        .doesNotThrowAnyException(),
                () -> assertThatCode(() -> new Name("all", players))
                        .doesNotThrowAnyException()
        );

    }
}
