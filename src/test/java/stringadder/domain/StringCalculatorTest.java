package stringadder.domain;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertThrows;

public class StringCalculatorTest {
    @Test
    void 커스텁_구분자가_없을_때_합을_제대로_반환하는지_테스트() {
        String input = "1,2:3";

        assertThat(StringCalculator.calculateSumOf(input)).isEqualTo(6);
    }

    @Test
    void 커스텀_구분자가_있을_때_합을_제대로_반환하는지_테스트() {
        String input = "//a\n1a2a3";

        assertThat(StringCalculator.calculateSumOf(input)).isEqualTo(6);
    }

    @Test
    void 커스텀_구분자만_입력했을_경우_0이_나오는지_테스트() {
        String input = "//a\n";

        assertThat(StringCalculator.calculateSumOf(input)).isEqualTo(0);
    }

    @Test
    void 아무것도_입력하지_않았을_경우_0이_나오는지_테스트() {
        String input = "";

        assertThat(StringCalculator.calculateSumOf(input)).isEqualTo(0);
    }

    @Test
    void 음수가_입력되었을_때_예외를_던져주는지_테스트() {
        String input = "-1,2;3";

        assertThrows(RuntimeException.class, () -> StringCalculator.calculateSumOf(input));
    }

    @Test
    void 숫자가_아닌_값이_입력되었을_때_예외를_던져주는지_테스트() {
        String input = "1,a;3";

        assertThrows(RuntimeException.class, () -> StringCalculator.calculateSumOf(input));

    }
}
