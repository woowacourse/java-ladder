package ladder.domain;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertThrows;

public class CrosspointTest {
    Crosspoint testpoint1;
    Crosspoint testpoint2;
    Crosspoint testpoint3;

    @BeforeEach
    void setUp() {
        testpoint1 = new Crosspoint(false, true);
        testpoint2 = new Crosspoint(true, false);
        testpoint3 = new Crosspoint(false, false);
    }

    @Test
    void Crosspoint객체가_연결_여부에_따라_변화된_위치를_제대로_돌려주는지_테스트() {
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

    @Test
    void leftCrossbar_rightCrossbar가_모두_True일_경우_예외를_던져주는지_테스트() {
        assertThrows(IllegalArgumentException.class, () -> new Crosspoint(true, true));
    }

    @Test
    void 오른쪽_Crossbar가_있으면_true를_리턴해주고_없으면_false를_리턴해주는지_테스트() {
        assertThat(testpoint1.hasRightCrossbar()).isTrue();
        assertThat(testpoint2.hasRightCrossbar()).isFalse();
        assertThat(testpoint3.hasRightCrossbar()).isFalse();

    }
}
