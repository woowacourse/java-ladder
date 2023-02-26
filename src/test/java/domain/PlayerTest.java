package domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

@DisplayName("참여자")
public class PlayerTest {

    private static final String NAME_SIZE_ERROR_MESSAGE = "이름은 1 ~ 5 글자여야 합니다.";
    private static final String VALUE_ERROR_MESSAGE = "이름은 영어나 숫자로만 가능합니다.";

    @DisplayName("이름이 길이가 범위 밖인 경우 예외 발생")
    @ParameterizedTest
    @ValueSource(strings = {"", "123456"})
    void createNameFail(String input) {
        assertThatThrownBy(() -> new Player(input, 0))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage(NAME_SIZE_ERROR_MESSAGE);
    }

    @DisplayName("이름이 길이가 범위 내인 경우 정상 생성")
    @ParameterizedTest
    @ValueSource(strings = {"1", "12345"})
    void createNameSuccess(String input) {
        Player player = new Player(input, 0);

        assertThat(player.getName()).isEqualTo(input);
    }

    @DisplayName("이름이 문자나 숫자 이외의 값이 포함되면 예외 발생")
    @ParameterizedTest
    @ValueSource(strings = {" ", " pobi", "dk$2"})
    void createNameNotWordFail(String input) {
        assertThatThrownBy(() -> new Player(input, 0))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage(VALUE_ERROR_MESSAGE);
    }

    @Test
    @DisplayName("이동")
    void movePlayerSuccess() {
        Player pobi = new Player("pobi", 0);
        Player hello = new Player("hello", 1);

        pobi.move(new Point(Direction.RIGHT_DOWN));
        hello.move(new Point(Direction.LEFT_DOWN));

        assertThat(pobi.getStandingLine()).isEqualTo(1);
        assertThat(hello.getStandingLine()).isEqualTo(0);
    }

}
