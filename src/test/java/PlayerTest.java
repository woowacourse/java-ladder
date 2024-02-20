import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class PlayerTest {

    @DisplayName("생성 테스트")
    @Test
    void createTest() {
        Assertions.assertThatCode(() -> new Player("산초"))
                .doesNotThrowAnyException();
    }
}
