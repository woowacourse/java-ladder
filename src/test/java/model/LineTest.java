package model;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;
import strategy.TruePassGenerator;

class LineTest {

    @ParameterizedTest
    @ValueSource(ints = {-1, 0, 1})
    void 참가자_수로_받는_정수가_2_미만이면_예외가_발생한다(int personCount) {
        assertThatThrownBy(
            () -> new Line(personCount, new TruePassGenerator())
        ).isInstanceOf(IllegalArgumentException.class);
    }

    @ParameterizedTest
    @ValueSource(ints = {2, 3, 4})
    void 참가자_수로_받는_정수_길이만큼의_line이_생성된다(int personCount) {
        Line line = new Line(personCount, new TruePassGenerator());
        assertThat(line.getLineBlockPass().size()).isSameAs(personCount);
    }

}
