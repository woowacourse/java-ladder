package domain.model;

import domain.model.consequence.Consequence;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

public class ConsequenceTest {
    @Test
    @DisplayName("consequence 객체는 결과값을 갖는다.")
    void consequenceValueTest() {
        Consequence consequence = new Consequence("꽝");

        assertThat(consequence.getValue()).isEqualTo("꽝");
    }

    @Test
    @DisplayName("공백값은 허용하지 않는다")
    void checkBlank() {
        assertThatThrownBy(() -> new Consequence(""))
                .isInstanceOf(IllegalArgumentException.class);

    }
}
