package model;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatCode;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

import exception.WrongRangeLadderHeightException;
import helper.FakeHeight;
import org.junit.jupiter.api.DisplayNameGeneration;
import org.junit.jupiter.api.DisplayNameGenerator.ReplaceUnderscores;
import org.junit.jupiter.api.Test;

@DisplayNameGeneration(ReplaceUnderscores.class)
class HeightTest {

    @Test
    void 생성자는_0_이하의_값이_주어지면_Exception이_발생한다() {
        assertThatThrownBy(() -> new Height(0))
                .isInstanceOf(WrongRangeLadderHeightException.class);
    }

    @Test
    void 생성자는_1_이상의_값이_주어지면_Height를_생선한다() {
        assertThatCode(() -> new Height(1)).doesNotThrowAnyException();
    }

    @Test
    void isContinueMakerLadder_메소드는_height가_1_이상이면_true를_반환한다() {
        Height height = new Height(1);

        boolean actual = height.isContinueMakeLadder();

        assertThat(actual).isSameAs(true);
    }

    @Test
    void isContinueMakerLadder_메소드는_height가_0이면_false를_반환한다() {
        Height height = new FakeHeight();

        boolean actual = height.isContinueMakeLadder();

        assertThat(actual).isSameAs(false);
    }
}