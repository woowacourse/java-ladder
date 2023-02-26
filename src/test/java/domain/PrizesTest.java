package domain;

import static org.assertj.core.api.Assertions.*;

import java.util.List;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

public class PrizesTest {
    private static Players players = new Players(List.of("1", "2", "3", "4"));

    @DisplayName("실형결과수와 참여자의 수가 다르면 예외가 발생한다.")
    @Test
    void not_match_count() {
        List<String> prizeNames = List.of("a", "b", "c");

        assertThatThrownBy(() -> new Prizes(prizeNames, players))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage("실행결과 수는 참여자 수와 같아야합니다.");
    }

    @DisplayName("인덱스에 해당되는 실행결과 확인하기")
    @ParameterizedTest
    @CsvSource(value = {"0,a", "1,b"})
    void check_prize_by_name(int index, String expected) {
        List<String> prizeNames = List.of("a", "b", "c", "d");

        Prizes prizes = new Prizes(prizeNames, players);

        assertThat(prizes.getName(index)).isEqualTo(expected);
    }
}
