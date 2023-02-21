package domain.vo;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatNoException;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class NameTest {

    @Test
    @DisplayName("이름은 1~5 글자를 넘지않는다.")
    void makeNameLengthFailure() {
        String wrongName = "abcdef";
        assertThatThrownBy(() -> new Name(wrongName))
            .isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    @DisplayName("이름은 1~5 글자이다.")
    void makeNameSuccess() {
        String rightName = "name";
        assertThatNoException().isThrownBy(() -> new Name(rightName));
    }

    @Test
    @DisplayName("동등성 비교 테스트")
    public void equalsTest() {
        //given
        String value = "value";
        Name target = new Name(value);

        //when
        boolean result = target.equals(new Name("value"));

        //then
        assertThat(result).isTrue();
    }
}
