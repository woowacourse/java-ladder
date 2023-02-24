package domain.ladder;


import static java.util.stream.Collectors.toList;
import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatNoException;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

import domain.player.Position;
import java.util.Arrays;
import java.util.List;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

class LadderResultsTest {

    @DisplayName("입력받은 크기와 LadderResults의 크기가 다르면 생성시 예외를 반환한다.")
    @Test
    void create_success_by_same_size() {
        // given
        List<LadderResult> ladderResults = List.of(new LadderResult("any"), new LadderResult("any"));

        // then
        assertThatNoException().isThrownBy(
                () -> LadderResults.createWithSameSize(ladderResults, ladderResults.size()));
    }

    @DisplayName("입력받은 크기와 LadderResults의 크기가 다르면 생성시 예외를 반환한다.")
    @Test
    void create_fail_by_different_size() {
        // given
        List<LadderResult> ladderResults = List.of(new LadderResult("any"), new LadderResult("any"));

        // then
        assertThatThrownBy(() -> LadderResults.createWithSameSize(ladderResults, ladderResults.size() - 1))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage("크기가 일치하지 않습니다.");
    }

    @DisplayName("입력받은 Position에 따라 적합한 result를 반환한다.")
    @ParameterizedTest
    @CsvSource(value = {"1:3000", "2:1000", "3:2000", "4:5000", "5:꽝"}, delimiter = ':')
    void find_result_by_position_test(int position,
                                      String expectedResult) {
        // given
        LadderResults ladderResults = generateLadderResultsByParameter("3000", "1000", "2000", "5000", "꽝");

        // when
        LadderResult ladderResult = ladderResults.findResultByPosition(new Position(position));

        assertThat(ladderResult.getResult()).isEqualTo(expectedResult);
    }

    private LadderResults generateLadderResultsByParameter(String... results) {
        List<LadderResult> ladderResults = Arrays.stream(results)
                .map(LadderResult::new)
                .collect(toList());
        return LadderResults.createWithSameSize(ladderResults, results.length);
    }
}
