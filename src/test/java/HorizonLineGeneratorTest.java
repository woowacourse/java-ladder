import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class HorizonLineGeneratorTest {

    @DisplayName("생성 테스트")
    @Test
    void create() {
        Assertions.assertThatCode(() -> new HorizonLineGenerator())
                .doesNotThrowAnyException();
    }
}
