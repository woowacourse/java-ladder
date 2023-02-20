package ladder.domain;

import ladder.FixedLineStrategy;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import java.util.List;

import static org.assertj.core.api.Assertions.*;

class LadderGameTest {

    @ParameterizedTest
    @CsvSource(value = {"dochi:01", "ad:00", "www:02", "qwe:last"}, delimiter = ':')
    @DisplayName("사다리 게임은 플레이어에 해당하는 실행결과를 계산한다.")
    void ladderGame_calculate_result_by_player(String input, String expected) {
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
        assertThat(result).isEqualTo(expected);
    }

    @Test
    @DisplayName("사다리 게임 실행결과 계산에서 플레이어 이름을 찾을 수 없는 경우, 예외를 던진다.")
    void ladderGame_exception_if_not_exist_playerName() {
        //given
        List<String> names = List.of("dochi", "ad", "www", "qwe");
        List<String> results = List.of("00", "01", "02", "last");
        int height = 2;
        Command command = new Command(names, results, height);
        List<List<Boolean>> lines = List.of(List.of(true, false, true), List.of(false, false, true));
        // |-----|     |-----|
        // |     |     |-----|
        LadderGame game = new LadderGame(command, new FixedLineStrategy(lines));

        //then
        assertThatThrownBy(() -> game.calculatePlayerResult("못찾겠지"))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage("존재하지 않는 플레이어 입니다.");
    }
}
