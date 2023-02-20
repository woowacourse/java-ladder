package model;

import static org.assertj.core.api.Assertions.assertThatThrownBy;

import org.junit.jupiter.api.DisplayNameGeneration;
import org.junit.jupiter.api.DisplayNameGenerator.ReplaceUnderscores;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.EmptySource;

@DisplayNameGeneration(ReplaceUnderscores.class)
class LadderResultTest {

    @ParameterizedTest
    @EmptySource
    void 생성자는_실행_결과로_빈_문자열을_전달하면_예외가_발생한다(String result) {
        assertThatThrownBy(() -> new LadderResult(result))
                .isInstanceOf(IllegalArgumentException.class);
    }


}
