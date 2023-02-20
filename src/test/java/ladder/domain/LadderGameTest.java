package ladder.domain;

import ladder.FixedLineStrategy;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import java.util.List;

class LadderGameTest {

    @ParameterizedTest
    @CsvSource(value = {"dochi:01", "ad:00", "www:02", "qwe:last"}, delimiter = ':')
    @DisplayName("사다리 게임은 플레이어에 해당하는 실행결과를 계산한다.")
    void m(String input, String expected) {
        //given
        List<String> names = List.of("dochi", "ad", "www", "qwe");
        List<String> results = List.of("00", "01", "02", "last");
        int height = 2;
        Command command = new Command(names, results, height);
        List<List<Boolean>> lines = List.of(List.of(true, false, true), List.of(false, false, true));
        // |-----|     |-----|
        // |     |     |-----|
        LadderGame game = new LadderGame(command, new FixedLineStrategy(lines));

        // when
        String result = game.calculatePlayerResult(input);
        //then
        Assertions.assertThat(result).isEqualTo(expected);
    }
}
