package ladder.domain;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.Map;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

class LadderResultTest {

    @ParameterizedTest(name = "입력: {0}, 결과: {1}")
    @CsvSource(value = {"pobi:true", "honux:false"}, delimiter = ':')
    @DisplayName("사다리 결과를 확인할 수 있는 대상인지 판별한다.")
    void check_valid_result_target(final String target, final boolean expected) {
        final LadderResult ladderResult = new LadderResult(Map.ofEntries(
                Map.entry("pobi", "꽝"),
                Map.entry("crong", "3000")
        ));

        assertThat(ladderResult.exist(target)).isEqualTo(expected);
    }
}
