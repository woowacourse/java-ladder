package ladder.util;

import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

public class InputHelperTest {
    @Test
    void 쉼표_구분() {
        String names = "buddy,pobi,brown";
        List<String> results = Arrays.asList("buddy", "pobi", "brown");
        assertThat(InputHelper.splitNames(names)).isEqualTo(results);
    }
}
