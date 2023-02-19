package ladder.domain;

import static org.assertj.core.api.Assertions.assertThatIllegalArgumentException;
import static org.assertj.core.api.Assertions.assertThatNoException;

import ladder.domain.linestrategy.CustomLineStrategy;
import ladder.domain.strategy.linestrategy.LineStrategy;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import java.util.List;

public class LadderFactoryTest {
    private final Height height = new Height(4);
    private final Players players = new Players(new String[]{"glen", "doggy"});
    private final LineStrategy lineStrategy = new CustomLineStrategy(List.of(Step.EXIST));
    private final LadderFactory ladderFactory = new LadderFactory(height, players, lineStrategy);

    @Test
    @DisplayName("입력된 사다리의 높이가 인원 수보다 작으면 예외가 발생한다.")
    void create_heightMinPlayersCount() {
        // given
        Height height = new Height(1);

        // expect
        assertThatIllegalArgumentException().isThrownBy(() -> {
            new LadderFactory(height, players, lineStrategy);
        }).withMessage("[ERROR] 사다리의 높이는 사람 수보다 크거나, 사람 수의 두 배 보다 작아야 합니다.");
    }

    @Test
    @DisplayName("입력된 사다리의 높이가 인원 수의 2배보다 크면 예외가 발생한다.")
    void create_heightMaxPlayersCount() {
        // given
        Height height = new Height(5);

        // expect
        assertThatIllegalArgumentException().isThrownBy(() -> {
            new LadderFactory(height, players, lineStrategy);
        }).withMessage("[ERROR] 사다리의 높이는 사람 수보다 크거나, 사람 수의 두 배 보다 작아야 합니다.");
    }

    @Test
    @DisplayName("사다리가 정상적으로 생성되어야 한다.")
    void create_success() {
        // expect
        assertThatNoException().isThrownBy(() -> {
            ladderFactory.makeLadder();
        });
    }
}
