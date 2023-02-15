import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;
import static org.junit.jupiter.api.Assertions.*;

import java.util.List;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;

class UserTest {
    public static final int NAME_LENGTH_LIMIT = 5;

    @Nested
    @DisplayName("이름 길이 검증 테스트")
    class NameLengthTest {
        @DisplayName("사람 이름이 " + NAME_LENGTH_LIMIT + "자 초과일 때 실패한다.")
        @Test
        void shouldFailNameLengthOver() {
            String name = "abcdef";
            assertThatThrownBy(() -> User.validateNameLength(name)).isInstanceOf(IllegalArgumentException.class)
                    .hasMessageContaining(User.NAME_LENGTH_ERROR_MESSAGE);
        }

        @DisplayName("사람 이름이 0글자일 때 실패한다.")
        @Test
        void shouldFailNameLengthZero() {
            String name = "";
            assertThatThrownBy(() -> User.validateNameLength(name)).isInstanceOf(IllegalArgumentException.class)
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
            assertThatThrownBy(() -> User.validateNameFormat(name)).isInstanceOf(IllegalArgumentException.class)
                    .hasMessageContaining(User.NAME_FORMAT_ERROR_MESSAGE);
        }

        @DisplayName("사람 이름에 숫자가 포함되면 실패한다.")
        @Test
        void shouldFailNameWithNumber() {
            String name = "ab23c";
            assertThatThrownBy(() -> User.validateNameFormat(name)).isInstanceOf(IllegalArgumentException.class)
                    .hasMessageContaining(User.NAME_FORMAT_ERROR_MESSAGE);
        }

        @DisplayName("사람 이름에 한글이 포함되면 실패한다.")
        @Test
        void shouldFailNameWithKorean() {
            String name = "ab가c";
            assertThatThrownBy(() -> User.validateNameFormat(name)).isInstanceOf(IllegalArgumentException.class)
                    .hasMessageContaining(User.NAME_FORMAT_ERROR_MESSAGE);
        }

        @DisplayName("사람 이름에 공백이 포함되면 실패한다.")
        @Test
        void shouldFailNameWithBlank() {
            String name = "ab c";
            assertThatThrownBy(() -> User.validateNameFormat(name)).isInstanceOf(IllegalArgumentException.class)
                    .hasMessageContaining(User.NAME_FORMAT_ERROR_MESSAGE);
        }
    }

    @Nested
    @DisplayName("입력 문자열 분리 테스트")
    class SplitInputTest {
        public static final String SPLIT_DELIMITER = ",";

        @DisplayName("입력받은 문자열이 " + SPLIT_DELIMITER + "를 기준으로 분리된다.")
        @Test
        void shouldSuccessSplitInput() {
            String input = "abc,abcd,abcde";
            assertThat(User.splitNameInput(input)).contains("abc", "abcd", "abcde");
        }
    }

    @Nested
    @DisplayName("입력받은 문자열 변환 테스트")
    class ConvertNameTest {
        @DisplayName("변환된 문자열이 최대 길이 제한과 같은지 확인한다.")
        @Test
        void shouldSuccessConvertNamesEqualMaxLength() {
            List<String> names = User.convertNames(List.of("i", "am", "fun", "dino"));
            names.forEach(name -> assertThat(name.length()).isEqualTo(NAME_LENGTH_LIMIT));
        }

        @DisplayName("입력받은 문자열이 지정된 형식에 맞게 변환되었는지 확인한다.")
        @Test
        void shouldSuccessConvertNames() {
            List<String> names = List.of("i", "am", "fun", "dino", "mango");
            assertThat(User.convertNames(names)).isEqualTo(List.of("   i ", "  am ", " fun ", "dino ", "mango"));
        }
    }
}
