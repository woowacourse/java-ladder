import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class NameTest {
    @DisplayName("이름 생성 테스트")
    @Test
    void createName() {
        Assertions.assertThatCode(() -> new Name("이름"))
                .doesNotThrowAnyException();
    }
}
