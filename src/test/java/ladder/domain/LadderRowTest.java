package ladder.domain;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertThrows;

class LadderRowTest {
    private Crosspoint rightHandCrosspoint = new Crosspoint(false, true);
    private Crosspoint leftHandCrosspoint = new Crosspoint(true, false);
    private Crosspoint downwardCrosspoint = new Crosspoint(false, false);

    @BeforeEach
    void setUp() {
        rightHandCrosspoint = new Crosspoint(false, true);
        leftHandCrosspoint = new Crosspoint(true, false);
        downwardCrosspoint = new Crosspoint(false, false);
    }

    @Test
    void 연속해서_오른쪽_방향_Crossbar가_있는_경우_예외를_던지는지_테스트() {
        List<Crosspoint> crosspoints = Arrays.asList(rightHandCrosspoint, rightHandCrosspoint, leftHandCrosspoint);

        assertThrows(IllegalArgumentException.class, () -> new LadderRow(crosspoints));
    }

    @Test
    void 연속해서_왼쪽_방향_Crossbar가_있는_경우_예외를_던지는지_테스트() {
        List<Crosspoint> crosspoints = Arrays.asList(rightHandCrosspoint, rightHandCrosspoint, leftHandCrosspoint);

        assertThrows(IllegalArgumentException.class, () -> new LadderRow(crosspoints));
    }

    @Test
    void Dummy_자리인_첫번째와_마지막_자리에는_crossbar가_있으면_예외를_던지는지_테스트() {
        List<Crosspoint> crosspointsStartsWithLeftHandCrosspoint = Arrays.asList(leftHandCrosspoint);
        List<Crosspoint> crosspointsEndsWithRightHandCrosspoint = Arrays.asList(rightHandCrosspoint);

        assertThrows(IllegalArgumentException.class, () -> new LadderRow(crosspointsStartsWithLeftHandCrosspoint));
        assertThrows(IllegalArgumentException.class, () -> new LadderRow(crosspointsEndsWithRightHandCrosspoint));
    }

    @Test
    void LadderRow_한_줄을_내려갔을_때_결과를_제대로_알려주는지_테스트() {
        LadderRow ladderRow = new LadderRow(Arrays.asList(downwardCrosspoint,
                rightHandCrosspoint, leftHandCrosspoint));

        assertThat(ladderRow.answerResultIndexOf(0)).isEqualTo(0);
        assertThat(ladderRow.answerResultIndexOf(1)).isEqualTo(2);
        assertThat(ladderRow.answerResultIndexOf(2)).isEqualTo(1);
    }

    @Test
    void LadderRow의_사이즈를_잘_반환해_주는지_테스트() {
        List<Crosspoint> crosspoints = Arrays.asList(rightHandCrosspoint, leftHandCrosspoint);

        assertThat(new LadderRow(crosspoints).width()).isEqualTo(2);
    }

    @Test
    void 사람_수에_맞게_제대로_LadderRow를_만들어주는지_테스트() {
        LadderRow testRow = LadderRow.of(3);

        assertThat(testRow.width()).isEqualTo(3);
    }
}
