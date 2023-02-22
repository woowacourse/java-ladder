package ladder.domain;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

import java.util.List;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.DisplayNameGeneration;
import org.junit.jupiter.api.DisplayNameGenerator;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

@DisplayNameGeneration(DisplayNameGenerator.ReplaceUnderscores.class)
class LadderTest {

    private static final int HEIGHT = 3;
    private static final int PLAYER_COUNT = 3;
    private static final Destination DESTINATION = new Destination(List.of("a", "b", "c"));
    private final Ladder ladder = Ladder.of(PLAYER_COUNT, new LadderHeight(HEIGHT), DESTINATION);

    @Test
    @DisplayName("사다리는 주어진 높이만큼의 라인을 가진다.")
    void should_HasLinesNumber_Of_GivenHeight() {
        List<Line> lines = ladder.toUnModifiableLines();

        assertThat(lines.size()).isEqualTo(HEIGHT);
    }

    @Test
    @DisplayName("사다리는 참여자 수 만큼의 폭을 가진다.")
    void should_HasWidth_Of_1lessThanPlayersCount() {
        List<Line> lines = ladder.toUnModifiableLines();
        Line line = lines.get(0);

        assertThat(line.size()).isEqualTo(PLAYER_COUNT);
    }

    @ParameterizedTest
    @ValueSource(ints = {-1, 0, 1})
    @DisplayName("참여자 수가 2 미만이면 예외를 던진다.")
    void should_ThrowException_When_PlayersCountLessThan2(int playerCount) {
        assertThatThrownBy(() -> Ladder.of(playerCount, new LadderHeight(3), new Destination(List.of("꽝", "꽝", "당첨"))))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining("참여자가 2명 이상이어야 사다리를 만들 수 있습니다.");
    }

    @Test
    @DisplayName("종착지의 개수가 참여자 수와 같지 않으면 예외를 던진다.")
    void should_ThrowException_When_DestinationSizeNotEqualWithPlayersCount() {
        Destination wrongDestination = new Destination(List.of("실패"));
        assertThatThrownBy(() -> Ladder.of(3, new LadderHeight(3), wrongDestination))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining("종착지의 개수는 참여자 수인 3명과 일치해야 합니다.");
    }
}
