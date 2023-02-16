import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;
import static org.junit.jupiter.api.Assertions.assertDoesNotThrow;

import domain.User;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.ValueSource;

class UserTest {
    public static final int NAME_LENGTH_LIMIT = 5;

    @Nested
    @DisplayName("유저 생성 테스트")
    class MakeUserTest {
        @DisplayName("변환된 입력값을 통해 올바르게 유저가 생성되는지 확인한다.")
        @ParameterizedTest
        @ValueSource(strings = {"i", "am", "fun", "dino", "mango"})
        void shouldSuccessMakeUser(String name) {
            assertDoesNotThrow(() -> new User(name));
        }

        @DisplayName("생성된 유저 객체가 올바르게 저장되는지 확인한다.")
        @ParameterizedTest
        @ValueSource(strings = {"i", "am", "fun", "dino", "mango"})
        void shouldSuccessStoreUsers(String name) {
            assertDoesNotThrow(() -> new User(name));
        }
    }

    @Nested
    @DisplayName("이름 길이 검증 테스트")
    class NameLengthTest {
        @DisplayName("사람 이름이 " + NAME_LENGTH_LIMIT + "자 초과일 때 실패한다.")
        @Test
        void shouldFailNameLengthOver() {
            String name = "abcdef";
            assertThatThrownBy(() -> new User(name)).isInstanceOf(IllegalArgumentException.class)
                    .hasMessageContaining(User.NAME_LENGTH_ERROR_MESSAGE);
        }

        @DisplayName("사람 이름이 0글자일 때 실패한다.")
        @Test
        void shouldFailNameLengthZero() {
            String name = "";
            assertThatThrownBy(() -> new User(name)).isInstanceOf(IllegalArgumentException.class)
                    .hasMessageContaining(User.NAME_LENGTH_ERROR_MESSAGE);
        }
    }

    @Nested
    @DisplayName("이름 형식 검증 테스트")
    class NameFormatTest {
        @DisplayName("사람 이름에 특수 문자가 포함되면 실패한다.")
        @Test
        void shouldFailNameWithSpecialCharacter() {
            String name = "ab#c";
            assertThatThrownBy(() -> new User(name)).isInstanceOf(IllegalArgumentException.class)
                    .hasMessageContaining(User.NAME_FORMAT_ERROR_MESSAGE);
        }

        @DisplayName("사람 이름에 숫자가 포함되면 실패한다.")
        @Test
        void shouldFailNameWithNumber() {
            String name = "ab23c";
            assertThatThrownBy(() -> new User(name)).isInstanceOf(IllegalArgumentException.class)
                    .hasMessageContaining(User.NAME_FORMAT_ERROR_MESSAGE);
        }

        @DisplayName("사람 이름에 한글이 포함되면 실패한다.")
        @Test
        void shouldFailNameWithKorean() {
            String name = "ab가c";
            assertThatThrownBy(() -> new User(name)).isInstanceOf(IllegalArgumentException.class)
                    .hasMessageContaining(User.NAME_FORMAT_ERROR_MESSAGE);
        }

        @DisplayName("사람 이름에 공백이 포함되면 실패한다.")
        @Test
        void shouldFailNameWithBlank() {
            String name = "ab c";
            assertThatThrownBy(() -> new User(name)).isInstanceOf(IllegalArgumentException.class)
                    .hasMessageContaining(User.NAME_FORMAT_ERROR_MESSAGE);
        }
    }

    @Nested
    @DisplayName("입력받은 문자열 변환 테스트")
    class ConvertNameTest {
        @DisplayName("변환된 문자열이 최대 길이 제한과 같은지 확인한다.")
        @ParameterizedTest
        @ValueSource(strings = {"i", "am", "fun", "dino", "mango"})
        void shouldSuccessConvertNamesEqualMaxLength(String name) {
            User user = new User(name);
            assertThat(user.getName().length()).isEqualTo(NAME_LENGTH_LIMIT);
        }

        @DisplayName("입력받은 문자열이 지정된 형식에 맞게 변환되었는지 확인한다.")
        @ParameterizedTest
        @CsvSource(value = {"i:   i ", "am:  am ", "fun: fun ", "dino:dino ", "mango:mango"}, delimiter = ':', ignoreLeadingAndTrailingWhitespace = false)
        void shouldSuccessConvertNames(String name, String expected) {
            User user = new User(name);
            assertThat(user.getName()).isEqualTo(expected);
        }
    }
}
