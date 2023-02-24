package domain.model;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;
import static org.junit.jupiter.api.Assertions.assertDoesNotThrow;

import domain.vo.Name;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

class PlayerTest {

    @ParameterizedTest(name = "Player의 유효성 검증 실패를 테스트")
    @ValueSource(strings = {"", "123456"})
    public void validateFailureTest(final String name) {
        assertThatThrownBy(() -> new Player(name))
            .isInstanceOf(IllegalArgumentException.class);
    }

    @ParameterizedTest(name = "Player의 유효성 검증 성공을 테스트")
    @ValueSource(strings = {"1", "12345"})
    public void validateSuccessTest(final String name) {
        assertDoesNotThrow(() -> new Player(name));
    }

    @Test
    @DisplayName("동등성 검사 실패 테스트")
    public void equalsFailureTest() {
        //given
        Name name1 = new Name("name1");
        Name name2 = new Name("name2");

        //when
        boolean result = name1.equals(name2);

        //then
        assertThat(result).isFalse();
    }

    @Test
    @DisplayName("동등성 검사 성공 테스트")
    public void equalsSuccessTest() {
        //given
        Name name1 = new Name("name");
        Name name2 = new Name("name");

        //when
        boolean result = name1.equals(name2);

        //then
        assertThat(result).isTrue();
    }

    @Test
    @DisplayName("해쉬 코드 값 테스트")
    public void hashCodeTest() {
        //given
        Name name1 = new Name("name");
        Name name2 = new Name("name");

        //when
        int name1HashCode = name1.hashCode();
        int name2HashCode = name2.hashCode();

        //then
        assertThat(name1HashCode == name2HashCode).isTrue();
    }
}