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

    @Test
    @DisplayName("사다리는 주어진 높이만큼의 라인을 가진다.")
    void should_HasLinesNumber_Of_GivenHeight() {
        int height = 3;
        Ladder ladder = Ladder.of(3, new LadderHeight(height));
        List<Line> lines = ladder.toUnModifiableLines();

        assertThat(lines.size()).isEqualTo(height);
    }

    @Test
    @DisplayName("사다리는 참여자_수 보다 1 작은 폭을 가진다.")
    void should_HasWidth_Of_1lessThanPlayersCount() {
        int playerCount = 3;
        Ladder ladder = Ladder.of(playerCount, new LadderHeight(3));
        List<Line> lines = ladder.toUnModifiableLines();
        Line line = lines.get(0);

        assertThat(line.size()).isEqualTo(playerCount - 1);
    }

    @ParameterizedTest
    @ValueSource(ints = {-1, 0, 1})
    @DisplayName("참여자 수가 2 미만이면 예외를 던진다.")
    void should_ThrowException_When_PlayersCountLessThan2(int playerCount) {
        assertThatThrownBy(() -> Ladder.of(playerCount, new LadderHeight(3)))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining("참여자가 2명 이상이어야 사다리를 만들 수 있습니다.");
    }
}
