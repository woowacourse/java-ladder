import static org.assertj.core.api.Assertions.assertThat;

import domain.ladder.Row;
import domain.player.PlayerCount;
import domain.player.Players;
import domain.ladder.Step;
import java.util.List;
import mock.EmptyStepGenerator;
import mock.ExistStepGenerator;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class RowTest {
    public static final Step EXIST_STEP = Step.EXIST;
    public static final Step EMPTY_STEP = Step.EMPTY;

    @Test
    @DisplayName("기둥에 발판이 있으면 연결된 다음 기둥에는 발판이 없어야하고, 마지막 다리는 발판이 없다.")
    void makeLineExist() {
        // given
        final Row row = Row.create(PlayerCount.fromPlayers(Players.from(List.of("a", "b", "c"))), new ExistStepGenerator());

        // when & then
        assertThat(row.getSteps()).containsExactly(EXIST_STEP, EMPTY_STEP, EMPTY_STEP);
    }

    @Test
    @DisplayName("모든 기둥에 발판이 없는 경우를 확인한다.")
    void makeLineEmpty() {
        // given
        final Row row = Row.create(PlayerCount.fromPlayers(Players.from(List.of("a", "b", "c"))), new EmptyStepGenerator());

        // when & then
        assertThat(row.getSteps()).containsExactly(EMPTY_STEP, EMPTY_STEP, EMPTY_STEP);
    }
}
