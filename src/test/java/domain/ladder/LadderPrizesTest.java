package domain.ladder;


import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatNoException;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

import domain.player.Position;
import java.util.ArrayList;
import java.util.List;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

class LadderPrizesTest {

    @DisplayName("입력받은 크기와 LadderPrizes의 크기가 다르면 생성시 예외를 반환한다.")
    @Test
    void create_success_by_same_size() {
        // given
        List<LadderPrize> ladderPrizes = List.of(
                new LadderPrize("any", new Position(1)),
                new LadderPrize("any", new Position(2)));
        // then
        assertThatNoException().isThrownBy(
                () -> LadderPrizes.createWithSameSize(ladderPrizes, ladderPrizes.size()));
    }

    @DisplayName("입력받은 크기와 LadderPrizes의 크기가 다르면 생성시 예외를 반환한다.")
    @Test
    void create_fail_by_different_size() {
        // given
        List<LadderPrize> ladderPrizes = List.of(
                new LadderPrize("any", new Position(1)),
                new LadderPrize("any", new Position(2)));
        // then
        assertThatThrownBy(() -> LadderPrizes.createWithSameSize(ladderPrizes, ladderPrizes.size() - 1))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage("크기가 일치하지 않습니다.");
    }

    @DisplayName("입력받은 Position에 따라 적합한 result를 반환한다.")
    @ParameterizedTest
    @CsvSource(value = {"1:3000", "2:1000", "3:2000", "4:5000", "5:꽝"}, delimiter = ':')
    void find_result_by_position_test(int position,
                                      String expectedResult) {
        // given
        LadderPrizes ladderPrizes = generateLadderPrizesByParameter("3000", "1000", "2000", "5000", "꽝");
        // when
        LadderPrize ladderPrize = ladderPrizes.findPrizeByPosition(new Position(position));
        assertThat(ladderPrize.getPrize()).isEqualTo(expectedResult);
    }

    private LadderPrizes generateLadderPrizesByParameter(String... results) {
        List<LadderPrize> ladderPrizes = new ArrayList<>();
        for (int i = 0; i < results.length; i++) {
            ladderPrizes.add(new LadderPrize(results[i], new Position(i + 1)));
        }
        return LadderPrizes.createWithSameSize(ladderPrizes, results.length);
    }
}
