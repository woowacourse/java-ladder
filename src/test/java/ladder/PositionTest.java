package ladder;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class PositionTest {
    private final static boolean TRUE = true;
    private final static boolean FALSE = false;
    private final static String LINE = "-----";
    private final static String BLNAK = "     ";

    @Test
    void 첫_포지션_생성() {
        Position position = Position.first(TRUE);
        assertThat(position).isEqualTo(Position.first(TRUE));
    }

    @Test
    void 첫_포지션에서_포지션이_있는_경우_다음_포지션_생성() {
        Position position = Position.first(TRUE).next(1, TRUE);
        Position position1 = Position.first(TRUE).next(1, FALSE);
        assertThat(position).isEqualTo(position1);
    }

    @Test
    void 첫_포지션에서_포지션이_없는_경우_다음_포지션_생성() {
        Position position = Position.first(FALSE).next(1, TRUE);
        assertThat(position.toString()).isEqualTo(LINE);

        position = Position.first(FALSE).next(1, FALSE);
        assertThat(position.toString()).isEqualTo(BLNAK);
    }

    @Test
    void 마지막_이전이_포지션이_있는_경우_마지막_포지션_생성() {
        Position position = Position.first(FALSE).next(1, TRUE).last(2);
        assertThat(position.toString()).isEqualTo(BLNAK);

        position = Position.first(FALSE).next(1, FALSE).last(2);
        assertThat(position.toString()).isEqualTo(BLNAK);
    }
}
