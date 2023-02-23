package ladder.domain;

import static java.util.List.of;
import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

class PrizesTest {

    @ParameterizedTest(name = "위치: {0}, 당첨 항목: {1}")
    @CsvSource(value = {"0:꽝", "1:3000", "2:5000"}, delimiter = ':')
    @DisplayName("위치에 알맞은 당첨 항목을 반환한다.")
    void return_prize_in_position(final int position, final String expected) {
        final Players players = Players.from(of("pobi", "honux", "crong"));
        final Prizes prizes = Prizes.from(of("꽝", "3000", "5000"), players);

        final String result = prizes.check(position);

        assertThat(result).isEqualTo(expected);
    }

    @Test
    @DisplayName("플레이어 수와 당첨 항목 수가 일치하지 않으면 예외를 던진다.")
    void throw_exception_not_equal_player_size_and_prize_size() {
        final Players players = Players.from(of("pobi", "honux", "crong"));

        assertThatThrownBy(() -> Prizes.from(of("꽝", "3000"), players))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage("실행 결과 개수는 플레이어 수와 동일해야 합니다. 플레이어 수: " + players.size() + ", 실행 결과 개수: 2");
    }
}
