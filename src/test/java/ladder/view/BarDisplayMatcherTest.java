package ladder.view;

import ladder.domain.Bar;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class BarDisplayMatcherTest {
    @Test
    @DisplayName("valueOfBarMatcher()는 true값이 들어왔을때 -----값을 가진 enum이 반환된다.")
    void test_1() {
        // given & when
        BarDisplayMatcher trueBarDisplayMatcher = BarDisplayMatcher.valueOfBarMatcher(Bar.TRUE);

        // then
        assertThat(trueBarDisplayMatcher.getBarDisplay())
                .isEqualTo("-----");
    }

    @Test
    @DisplayName("valueOfBarMatcher()는 false값이 들어왔을때 스페이스 5개의 값을 가진 enum이 반환된다.")
    void test_2() {
        // given & when
        BarDisplayMatcher falseBarDisplayMatcher = BarDisplayMatcher.valueOfBarMatcher(Bar.FALSE);

        // then
        assertThat(falseBarDisplayMatcher.getBarDisplay())
                .isEqualTo("     ");
    }
}
