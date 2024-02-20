package ladder.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThatCode;
import static org.assertj.core.api.Assertions.assertThatIllegalArgumentException;

class NamesTest {

    @Test
    @DisplayName("사람 이름은 쉼표(,)를 기준으로 구분한다.")
    void createNames() {
        assertThatCode(() -> new Names("pobi,honux,crong,jk"))
                .doesNotThrowAnyException();
    }

    @Test
    @DisplayName("이름이 5글자를 초과하면 예외가 발생한다.")
    void createInvalidNames() {
        assertThatIllegalArgumentException()
                .isThrownBy(() -> new Names("pobipobi,honux,crong,jk"));
    }

}