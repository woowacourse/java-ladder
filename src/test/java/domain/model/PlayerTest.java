package domain.model;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;
import static org.junit.jupiter.api.Assertions.assertDoesNotThrow;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

class PlayerTest {

    @ParameterizedTest(name = "적절하지 않은 길이의 이름이 들어왔을 때를 테스트")
    @ValueSource(strings = {"", "123456"})
    public void testInvalidLengthName(final String name) {
        assertThatThrownBy(() -> new Player(name))
            .isInstanceOf(IllegalArgumentException.class);
    }

    @ParameterizedTest(name = "적절한 길이의 이름이 들어왔을 때를 테스트")
    @ValueSource(strings = {"1", "12345"})
    public void testValidLengthName(final String name) {
        assertDoesNotThrow(() -> new Player(name));
    }

    @Test
    @DisplayName("동등성 검사 실패 테스트")
    public void testEquals() {
        //given
        Player player1 = new Player("test1");
        Player player2 = new Player("test2");

        //when
        boolean result = player1.equals(player2);

        //then
        assertThat(result).isFalse();
    }

    @Test
    @DisplayName("동등성 검사 성공 테스트")
    public void equalsSuccessTest() {
        //given
        Player player1 = new Player("name");
        Player player2 = new Player("name");

        //when
        boolean result = player1.equals(player2);

        //then
        assertThat(result).isTrue();
    }

    @Test
    @DisplayName("해쉬 코드 값 테스트")
    public void testHashCode() {
        //given
        Player player1 = new Player("name");
        Player player2 = new Player("name");

        //when
        int player1HashCode = player1.hashCode();
        int player2HashCode = player2.hashCode();

        //then
        assertThat(player1HashCode == player2HashCode).isTrue();
    }
}