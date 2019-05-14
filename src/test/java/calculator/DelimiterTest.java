package calculator;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class DelimiterTest {
    @Test
    void 구분자_추출하기() {
        assertThat(Delimiter.getFromString("//;\n")).isEqualTo(";");
    }
}
