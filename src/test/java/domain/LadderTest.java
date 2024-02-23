package domain;

import static org.assertj.core.api.Assertions.assertThatCode;
import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class LadderTest {

    @DisplayName("사다리를 생성한다.")
    @Test
    public void create() {
        assertThatCode(() -> new Ladder(2, new Height(5), new FixedBooleanGenerator(true)))
                .doesNotThrowAnyException();
    }

    @DisplayName("사다리 정보를 원시값으로 생성한다..")
    @Test
    public void createInformation() {
        Ladder ladder = new Ladder(4, new Height(5), new FixedBooleanGenerator(true));

        Map<Integer, List<Boolean>> actual = ladder.getLinesInformation();
        Map<Integer, List<Boolean>> expected = new LinkedHashMap<>();
        for (int i = 1; i <= 5; i++) {
            expected.put(i, List.of(true, false, true));
        }

        assertEquals(actual, expected);
    }

}
