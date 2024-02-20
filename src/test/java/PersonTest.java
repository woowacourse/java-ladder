import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class PersonTest {

    @DisplayName("생성 테스트")
    @Test
    void createTest() {
        Assertions.assertThatCode(() -> new Person("산초"))
                .doesNotThrowAnyException();
    }
}
