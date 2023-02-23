package ladder.domain;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.List;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

class PrizesTest {

    @ParameterizedTest(name = "위치: {0}, 당첨 항목: {1}")
    @CsvSource(value = {"0:꽝", "1:3000", "2:5000"}, delimiter = ':')
    @DisplayName("위치에 알맞은 당첨 항목을 반환한다.")
    void return_prize_in_position(final int position, final String expected) {
        final Prizes prizes = Prizes.from(List.of("꽝", "3000", "5000"));

        final String result = prizes.check(position);

        assertThat(result).isEqualTo(expected);
    }
}
