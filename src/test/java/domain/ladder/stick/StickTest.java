package domain.ladder.stick;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertAll;

class StickTest {

    private final Stick filledStick = Stick.FILLED;
    private final Stick notFilledStick = Stick.NOT_FILLED;

    @DisplayName("채워진 막대인지를 반환한다.")
    @Test
    void isFilled() {
        boolean isFilled1 = filledStick.isFilled();
        boolean isFilled2 = notFilledStick.isFilled();

        assertAll(
                () -> assertThat(isFilled1).isTrue(),
                () -> assertThat(isFilled2).isFalse()
        );
    }

    @DisplayName("같은 유형의 막대인지를 반환한다.")
    @Test
    void isSameType() {
        boolean isSame1 = filledStick.isSameType(Stick.FILLED);
        boolean isSame2 = notFilledStick.isSameType(Stick.FILLED);

        assertAll(
                () -> assertThat(isSame1).isTrue(),
                () -> assertThat(isSame2).isFalse()
        );
    }

    @DisplayName("반대 유형의 막대를 반환한다.")
    @Test
    void getOpposite() {
        Stick opposite1 = filledStick.getOpposite();
        Stick opposite2 = notFilledStick.getOpposite();

        assertAll(
                () -> assertThat(opposite1).isEqualTo(Stick.NOT_FILLED),
                () -> assertThat(opposite2).isEqualTo(Stick.FILLED)
        );
    }
}
