package ladder.domain;

import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

public class CrosspointTest {
    @Test
    void Crosspoint객체가_연결_여부에_따라_변화된_위치를_제대로_돌려주는지_테스트() {
        Crosspoint testpoint1 = new Crosspoint(false, true);
        Crosspoint testpoint2 = new Crosspoint(true, false);
        Crosspoint testpoint3 = new Crosspoint(false, false);

        int testPosition = 1;
        int rightPositionOfTestPosition = 2;
        int leftPositionOfTestPosition = 0;

        assertThat(testpoint1.answerResultPositionOf(testPosition))
                .isEqualTo(rightPositionOfTestPosition);
        assertThat(testpoint2.answerResultPositionOf(testPosition))
                .isEqualTo(leftPositionOfTestPosition);
        assertThat(testpoint3.answerResultPositionOf(testPosition))
                .isEqualTo(testPosition);
    }
}
