package ladder.domain;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertThrows;

class CrosspointTest {
    private Crosspoint rightHandCrosspoint;
    private Crosspoint leftHandCrosspoint;
    private Crosspoint noHandCrosspoint;

    @BeforeEach
    void setUp() {
        rightHandCrosspoint = new Crosspoint(false, true);
        leftHandCrosspoint = new Crosspoint(true, false);
        noHandCrosspoint = new Crosspoint(false, false);
    }

    @Test
    void Crosspoint객체가_가진_가로막대_여부에_따라_변화된_위치를_제대로_돌려주는지_테스트() {
        int testPosition = 1;
        int rightPositionOfTestPosition = 2;
        int leftPositionOfTestPosition = 0;

        assertThat(rightHandCrosspoint.answerResultPositionOf(testPosition))
                .isEqualTo(rightPositionOfTestPosition);
        assertThat(leftHandCrosspoint.answerResultPositionOf(testPosition))
                .isEqualTo(leftPositionOfTestPosition);
        assertThat(noHandCrosspoint.answerResultPositionOf(testPosition))
                .isEqualTo(testPosition);
    }

    @Test
    void leftCrossbar_rightCrossbar가_모두_True일_경우_예외를_던져주는지_테스트() {
        assertThrows(IllegalArgumentException.class, () -> new Crosspoint(true, true));
    }

    @Test
    void 오른쪽_Crossbar가_있으면_true를_리턴해주고_없으면_false를_리턴해주는지_테스트() {
        assertThat(rightHandCrosspoint.hasRightSideCrossbar()).isTrue();
        assertThat(leftHandCrosspoint.hasRightSideCrossbar()).isFalse();
        assertThat(noHandCrosspoint.hasRightSideCrossbar()).isFalse();
    }

    @Test
    void 첫_번째_crosspoint_생성시_왼쪽_가로막대가_생기지_않도록_생성되는지_테스트() {
        Crosspoint firstCrosspoint = Crosspoint.generateFirstCrosspoint();

        assertThat(firstCrosspoint.hasLeftSideCrossbar()).isFalse();
    }

    @Test
    void inner_crosspoint_생성시_왼쪽_가로막대를_제대로_생성하는지_테스트() {
        Crosspoint testingCrosspointWithLeftHand = Crosspoint.generateInnerCrosspointNeighboredWith(rightHandCrosspoint);
        Crosspoint testingCrosspointWithoutLeftHand = Crosspoint.generateInnerCrosspointNeighboredWith(noHandCrosspoint);

        assertThat(testingCrosspointWithLeftHand.hasLeftSideCrossbar()).isTrue();
        assertThat(testingCrosspointWithoutLeftHand.hasLeftSideCrossbar()).isFalse();
    }

    @Test
    void 마지막_crosspoint_생성시_오른쪽_가로막대가_생기지_않도록_생성되는지_테스트() {
        Crosspoint testinglastCrosspoint = Crosspoint.generateLastCrosspointNeighboredWith(noHandCrosspoint);
        assertThat(testinglastCrosspoint.hasRightSideCrossbar()).isFalse();
    }
}
