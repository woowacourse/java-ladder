package ladder.domain;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.List;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

class PrizesTest {

    @ParameterizedTest(name = "입력: {0}, 출력: {1}")
    @CsvSource(value = {"0:꽝", "1:3000", "2:5000"}, delimiter = ':')
    @DisplayName("당첨 결과를 확인한다.")
    void checkPrize(final int position, final String expected) {
        final Prizes prizes = Prizes.from(List.of("꽝", "3000", "5000"));

        final String result = prizes.check(position);

        assertThat(result).isEqualTo(expected);
    }
}
