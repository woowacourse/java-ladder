package domain;

import static domain.PointStatus.printStatus;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class PointStatusTest {

    @DisplayName("point가 True이면 width만큼 '-'를 붙인 문자열을 반환한다.")
    @Test
    void shouldPrintHyphenPointIsTrue() {
        Assertions.assertThat(printStatus(true, 5)).isEqualTo("-----");
    }

    @DisplayName("point가 False이면 width만큼 ' '를 붙인 문자열을 반환한다.")
    @Test
    void shouldPrintBlankPointIsFalse() {
        Assertions.assertThat(printStatus(false, 5)).isEqualTo("     ");
    }
}
