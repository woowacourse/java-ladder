package ladder.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.EmptySource;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatIllegalArgumentException;

class NameTest {

    @Test
    @DisplayName("이름이 5글자를 초과하면 예외가 발생한다.")
    void createInvalidNames() {
        assertThatIllegalArgumentException()
                .isThrownBy(() -> new Name("pobiii"));
    }

    @Test
    @DisplayName("이름에 공백은 포함하지 않는다.")
    void createValidNames() {
        // given
        String rawName = "     jk      ";

        // when
        Name name = new Name(rawName);

        // then
        assertThat(name).extracting("value")
                .asString()
                .isEqualTo("jk");
    }


    @ParameterizedTest
    @EmptySource
    @DisplayName("이름이 공백이라면 예외가 발생한다.")
    void blankNameTest(String blankName) {
        // when & then
        assertThatIllegalArgumentException()
                .isThrownBy(() -> new Name(blankName));
    }

    @Test
    @DisplayName("이름이 같다면 두 객체의 값이 같다.")
    void testEquals() {
        String name = "pobi";

        Name pobi1 = new Name(name);
        Name pobi2 = new Name(name);

        assertThat(pobi1).isEqualTo(pobi2);
    }
}