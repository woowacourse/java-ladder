package domain;

import common.exception.message.ExceptionMessage;
import common.exception.model.ValidationException;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

public class PlayerNameTest {

    @Nested
    @DisplayName("참가자 이름 형식 테스트")
    class PlayerNameFormatTest {

        @ParameterizedTest
        @ValueSource(strings = {"name", "이름"})
        @DisplayName("영어 또는 한글이면 정상적으로 생성된다")
        void createPlayerNameSuccessWithFormat(String value) {
            Assertions.assertThatCode(() -> new PlayerName(value))
                    .doesNotThrowAnyException();
        }

        @ParameterizedTest
        @ValueSource(strings = {"1", "^%&"})
        @DisplayName("영어 또는 한글이 아니면 예외가 발생한다")
        void createPlayerNameFailByFormat(String value) {
            Assertions.assertThatThrownBy(() -> new PlayerName(value))
                    .isInstanceOf(ValidationException.class)
                    .hasMessage(ExceptionMessage.PLAYER_NAMES_FORMAT);
        }
    }

    @Nested
    @DisplayName("참가자 이름 공백 테스트")
    class PlayerNameBlankTest {

        @Test
        @DisplayName("공백만 입력되면 예외가 발생한다")
        void createPlayerNameFailByBlank() {
            Assertions.assertThatThrownBy(() -> new PlayerName(" "))
                    .isInstanceOf(ValidationException.class)
                    .hasMessage(ExceptionMessage.PLAYER_NAME_BLANK);
        }
    }

    @Nested
    @DisplayName("참가자 이름 길이 테스트")
    class PlayerNameLengthTest {

        @ParameterizedTest
        @ValueSource(strings = {"a", "abcde"})
        @DisplayName("길이가 1 이상, 5 이하이면 정상적으로 생성된다")
        void createPlayerNameSuccessWithLength(String name) {
            Assertions.assertThatCode(() -> new PlayerName(name))
                    .doesNotThrowAnyException();
        }

        @ParameterizedTest
        @ValueSource(strings = {"", "abcdef"})
        @DisplayName("길이가 1 미만, 5 초과이면 예외가 발생한다")
        void createPlayerNameFailByLength(String name) {
            Assertions.assertThatThrownBy(() -> new PlayerName(name))
                    .isInstanceOf(ValidationException.class)
                    .hasMessage(ExceptionMessage.PLAYER_NAME_LENGTH);
        }
    }
}
