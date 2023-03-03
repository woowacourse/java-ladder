package domain.user;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;
import static org.junit.jupiter.api.Assertions.assertDoesNotThrow;

import domain.ladder.Line;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;
import utils.FixedBooleanGenerator;

class UserTest {
    public static final int NAME_LENGTH_LIMIT = 5;

    @Nested
    @DisplayName("유저 생성 테스트")
    class MakeUserTest {
        @DisplayName("입력값을 통해 올바르게 유저가 생성되는지 확인한다.")
        @ParameterizedTest
        @ValueSource(strings = {"i", "am", "fun", "dino", "mango"})
        void shouldSuccessMakeUser(String name) {
            assertDoesNotThrow(() -> new User(name, 0));
        }
    }

    @Nested
    @DisplayName("이름 길이 검증 테스트")
    class NameLengthTest {
        @DisplayName("사람 이름이 " + NAME_LENGTH_LIMIT + "자 초과일 때 실패한다.")
        @Test
        void shouldFailNameLengthOver() {
            String name = "abcdef";
            assertThatThrownBy(() -> new User(name, 0)).isInstanceOf(IllegalArgumentException.class)
                    .hasMessageContaining(Name.NAME_LENGTH_ERROR_MESSAGE);
        }

        @DisplayName("사람 이름이 0글자일 때 실패한다.")
        @Test
        void shouldFailNameLengthZero() {
            String name = "";
            assertThatThrownBy(() -> new User(name, 0)).isInstanceOf(IllegalArgumentException.class)
                    .hasMessageContaining(Name.NAME_LENGTH_ERROR_MESSAGE);
        }
    }

    @Nested
    @DisplayName("이름 형식 검증 테스트")
    class NameFormatTest {
        @DisplayName("사람 이름에 특수 문자가 포함되면 실패한다.")
        @Test
        void shouldFailNameWithSpecialCharacter() {
            String name = "ab#c";
            assertThatThrownBy(() -> new User(name, 0)).isInstanceOf(IllegalArgumentException.class)
                    .hasMessageContaining(Name.NAME_FORMAT_ERROR_MESSAGE);
        }

        @DisplayName("사람 이름에 숫자가 포함되면 실패한다.")
        @Test
        void shouldFailNameWithNumber() {
            String name = "ab23c";
            assertThatThrownBy(() -> new User(name, 0)).isInstanceOf(IllegalArgumentException.class)
                    .hasMessageContaining(Name.NAME_FORMAT_ERROR_MESSAGE);
        }

        @DisplayName("사람 이름에 한글이 포함되면 실패한다.")
        @Test
        void shouldFailNameWithKorean() {
            String name = "ab가c";
            assertThatThrownBy(() -> new User(name, 0)).isInstanceOf(IllegalArgumentException.class)
                    .hasMessageContaining(Name.NAME_FORMAT_ERROR_MESSAGE);
        }

        @DisplayName("사람 이름에 공백이 포함되면 실패한다.")
        @Test
        void shouldFailNameWithBlank() {
            String name = "ab c";
            assertThatThrownBy(() -> new User(name, 0)).isInstanceOf(IllegalArgumentException.class)
                    .hasMessageContaining(Name.NAME_FORMAT_ERROR_MESSAGE);
        }
    }

    @Nested
    @DisplayName("유저 이동 테스트")
    class MoveUserTest {
        @DisplayName("현재 position에 해당하는 다음 라인 값이 true인 경우, 왼쪽 밑으로 이동한다.")
        @Test
        void shouldSuccessMoveLowerLeft() {
            User user = new User("test", 1);
            Line nextLine = new Line(4, new FixedBooleanGenerator(true));
            user.getPosition().movePosition(nextLine.getLine());
            assertThat(user.getPosition().getValue()).isEqualTo(0);
        }

        @DisplayName("현재 position + 1에 해당하는 다음 라인 값이 true인 경우, 오른쪽 밑으로 이동한다.")
        @Test
        void shouldSuccessMoveLowerRight() {
            User user = new User("test", 0);
            Line nextLine = new Line(4, new FixedBooleanGenerator(true));
            user.getPosition().movePosition(nextLine.getLine());
            assertThat(user.getPosition().getValue()).isEqualTo(1);
        }

        @DisplayName("현재 position과 position + 1에 해당하는 다음 라인 값이 둘 다 false인 경우, 그대로 밑으로 이동한다.")
        @Test
        void shouldSuccessMoveDown() {
            User user = new User("test", 0);
            Line nextLine = new Line(4, new FixedBooleanGenerator(false));
            user.getPosition().movePosition(nextLine.getLine());
            assertThat(user.getPosition().getValue()).isEqualTo(0);
        }
    }
}
