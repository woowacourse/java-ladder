package ladder.domain;

import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

public class LadderResultTest {
    @Test
    public void 결과를_잘_매치하는지_확인() {
        List<Integer> result = Arrays.asList(1, 3, 0, 2);
        List<String> items = Arrays.asList("꽝", "2등", "1등", "3등");

        List<String> finalResultByMe = Arrays.asList("2등", "3등", "꽝", "1등");
        List<String> finalResultByLadderResult = LadderResult.generate(result, items);

        assertThat(finalResultByMe).isEqualTo(finalResultByLadderResult);
    }
}
