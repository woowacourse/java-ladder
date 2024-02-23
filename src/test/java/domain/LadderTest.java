package domain;

import static org.assertj.core.api.Assertions.assertThatCode;

import domain.LineTest.FixedBooleanGenerator;
import java.util.List;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class LadderTest {

    @DisplayName("사다리를 생성한다.")
    @Test
    public void create() {
        assertThatCode(
                () -> new Ladder(new Players(List.of("pobi", "tommy")), new Height(5), new FixedBooleanGenerator(true)))
                .doesNotThrowAnyException();
    }
}
