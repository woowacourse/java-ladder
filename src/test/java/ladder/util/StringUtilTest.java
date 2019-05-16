package ladder.util;

import org.junit.jupiter.api.Test;

import java.util.Arrays;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

public class StringUtilTest {
    @Test
    void 입력_콤마_분리() {
        assertThat(StringUtil.splitComma("pobi,crong")).isEqualTo(Arrays.asList("pobi","crong"));
    }


}
