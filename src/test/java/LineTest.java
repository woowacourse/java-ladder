import static org.assertj.core.api.Assertions.assertThatCode;

import domain.Line;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class LineTest {

    @DisplayName("라인 객체를 정상적으로 생성한다.")
    @Test
    void createLine() {
        assertThatCode(() -> new Line())
                .doesNotThrowAnyException();
    }

    @DisplayName("라인은 다리를 생성한다.")
    @Test
    void makeLeg() {
        Line line = new Line();

        assertThatCode(()->line.makeLeg(3))
                .doesNotThrowAnyException();
    }
}
