package model;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

import java.util.List;
import org.junit.jupiter.api.DisplayNameGeneration;
import org.junit.jupiter.api.DisplayNameGenerator.ReplaceUnderscores;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.NullSource;

@DisplayNameGeneration(ReplaceUnderscores.class)
class LadderResultsTest {

    @ParameterizedTest
    @NullSource
    void of_메소드는_null이_주어지면_예외가_발생한다(List<LadderResult> results) {
        assertThatThrownBy(() -> LadderResults.of(results, 3))
                .isInstanceOf(IllegalStateException.class)
                .hasMessageContaining("실행 결과가 정상적으로 입력되지 않았습니다.");
    }

    @Test
    void of_메소드는_results의_크기와_참가자의_크기가_일치하지_않으면_예외가_발생한다() {
        List<LadderResult> results = List.of(new LadderResult("abc"), new LadderResult("bcd"));

        assertThatThrownBy(() -> LadderResults.of(results, 3))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining("사다리 게임 결과는 참가자 수와 일치해야 합니다.");
    }

    @ParameterizedTest
    @CsvSource(value = {"0:a", "1:b"}, delimiter = ':')
    void getLadderResultOfIndex_메소드는_인덱스를_전달하면_인덱스에_위치한_사다리_결과를_반환한다(int index, String expected) {
        LadderResults ladderResults =
                LadderResults.of(List.of(new LadderResult("a"), new LadderResult("b")), 2);

        String actual = ladderResults.getLadderResultOfIndex(index);

        assertThat(actual).isEqualTo(expected);
    }
}
