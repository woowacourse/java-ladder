package calculator.domain;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class DelimiterTest {
    @Test
    void 구분자_추출하기_커스텀() {
        assertThat(Delimiter.getFromString("//;\n1,2,3")).isEqualTo(";");
    }

    @Test
    void 구분자_추출하기_디폴트() {
        assertThat(Delimiter.getFromString("1,2,3")).isEqualTo(":|,");
    }
}
