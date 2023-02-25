package domain;

import static org.assertj.core.api.Assertions.*;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class WinningEntryTest {

    @Test
    @DisplayName("당첨 결과 수가 사람 수와 다르면 예외가 발생한다")
    void createWinningEntryWithWrongSize() {
        //given
        int personCount = 5;
        List<WinningResult> winningResults = Stream.of("1", "2", "3", "4")
                .map(WinningResult::new)
                .collect(Collectors.toList());

        //when
        //then
        assertThatThrownBy(() -> new WinningEntry(winningResults, personCount))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    @DisplayName("당첨 결과 수가 사람 수와 동일하면 성공")
    void createWinningEntryWithPersonCountSize() {
        //given
        int personCount = 5;
        List<WinningResult> winningResults = Stream.of("1", "2", "3", "4", "5")
                .map(WinningResult::new)
                .collect(Collectors.toList());

        //when
        WinningEntry winningEntry = new WinningEntry(winningResults, personCount);

        //then
        assertThat(winningEntry.getWinningEntry().size()).isEqualTo(personCount);
    }

}