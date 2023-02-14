package laddergame.model;

import static org.assertj.core.api.Assertions.assertThatThrownBy;
import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;

class PersonTest {
    @Nested
    @DisplayName("이름에 한글이 들어갈 수 없다.")
    class TestNameLength {
        @Test
        @DisplayName("생성 테스트")
        void Should_Success_When_NameInput() {
            assertDoesNotThrow(() -> new Person("name"));
        }

        @Test
        @DisplayName("한글이 들어가는 경우 예외 발생")
        void Should_ThrowException_When_KoreanInput() {
            assertThatThrownBy(() -> new Person("이름"));
        }
    }

}
