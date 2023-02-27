package model;

import java.util.List;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;
import strategy.TruePassGenerator;

class LadderTest {

    @ParameterizedTest
    @ValueSource(ints = {-1,0})
    void 사다리의_높이가_1미만이면_예외가_발생한다(int height){
        Assertions.assertThatThrownBy(
            () -> new Ladder(height,3,new TruePassGenerator())
        ).isInstanceOf(IllegalArgumentException.class);
    }

}
