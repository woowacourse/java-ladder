import domain.Line;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class LineTest {

    @Test
    @DisplayName("라인을 생성한다.")
    void createLine() {
        Assertions.assertThatCode(() -> new Line()).doesNotThrowAnyException();
    }

}
