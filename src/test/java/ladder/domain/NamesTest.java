package ladder.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.*;

class NamesTest {

    @Test
    @DisplayName("사람 이름은 쉼표(,)를 기준으로 구분한다.")
    void createNames() {
        // given
        Names names = new Names("pobi,honux,crong,jk");

        // when
        int count = names.count();

        // then
        assertThat(count).isEqualTo(4);
    }

    @Test
    @DisplayName("이름이 5글자를 초과하면 예외가 발생한다.")
    void createInvalidNames() {
        assertThatIllegalArgumentException()
                .isThrownBy(() -> new Names("pobipobi,honux,crong,jk"));
    }

    @Test
    @DisplayName("이름에 공백은 포함하지 않는다.")
    void createValidNames() {
        // given
        String name = "  jk  ";

        // when & then
        assertThatCode(() -> new Names(name))
                .doesNotThrowAnyException();
    }
}