package ladder.domain.ladder;

import ladder.domain.Position;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

class RewardsTest {
    @Test
    @DisplayName("존재하지 않는 위치로 실행 결과를 찾는 경우 예외를 던진다.")
    void items_throwException_notFoundPositionOfItem() {
        // given
        Position wrongPosition = new Position(4);
        Rewards rewards = new Rewards(List.of("1", "2", "3"));

        // expected
        assertThatThrownBy(() -> rewards.findItem(wrongPosition))
                .isInstanceOf(IllegalStateException.class);
    }

    @ParameterizedTest
    @CsvSource(value = {"0,1", "1,2", "2,3"}, delimiter = ',')
    @DisplayName("플레이어의 위치를 입력하여 동일한 위치의 실행 결과를 찾는다.")
    void items_findSamePositionItem(int position, String expectedItem) {
        // given
        Rewards rewards = new Rewards(List.of("1", "2", "3"));

        // expected
        assertThat(rewards.findItem(new Position(position)).getName())
                .isEqualTo(expectedItem);
    }
}
