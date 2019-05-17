package ladder.util;

import org.junit.jupiter.api.Test;

import java.util.Arrays;

import static org.assertj.core.api.Assertions.assertThat;

public class OutputHelperTest {
    @Test
    void 출력확인() {
        assertThat(OutputHelper.generateOutputText(Arrays.asList("pobi", "brown", "woni"))).isEqualTo("  pobi brown  woni");
    }
}
