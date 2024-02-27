package domain;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatNoException;
import static org.assertj.core.api.Assertions.assertThatThrownBy;
import static org.junit.jupiter.api.Assertions.*;

import domain.ladder.Height;
import domain.ladder.Ladder;
import domain.ladder.bridgeConstructstrategy.RandomBridgeConstructStrategy;
import domain.player.Names;
import domain.result.Prizes;
import java.util.List;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class LadderGameTest {

    private static final Prizes PRIZES_SIZE_OF_THREE = new Prizes(List.of("1", "2", "3"));
    private static final Names NAMES_SIZE_OF_THREE = new Names(List.of("name1", "name2", "name3"));
    private static final Ladder DEFAULT_LADDER_SIZE_OF_THREE =
            new Ladder(new RandomBridgeConstructStrategy(), NAMES_SIZE_OF_THREE, new Height(5));

    @DisplayName("정상적으로 사다리게임이 생성된다.")
    @Test
    void constructSuccessTest() {
        assertThat(NAMES_SIZE_OF_THREE.size())
                .isEqualTo(PRIZES_SIZE_OF_THREE.size());
        assertThatNoException()
                .isThrownBy(() -> new LadderGame(NAMES_SIZE_OF_THREE, PRIZES_SIZE_OF_THREE, DEFAULT_LADDER_SIZE_OF_THREE));
    }

    @DisplayName("이름과 결과의 개수가 다를 경우, 사다리 게임 생성에서 예외가 발생한다.")
    @Test
    void constructFailWithDifferentSizeNamesAndResults() {
        Prizes differentSizePrizes = new Prizes(List.of("1", "2", "3", "4"));
        assertThat(NAMES_SIZE_OF_THREE.size())
                .isNotEqualTo(differentSizePrizes.size());
        assertThatThrownBy(
                () -> new LadderGame(NAMES_SIZE_OF_THREE, differentSizePrizes, DEFAULT_LADDER_SIZE_OF_THREE))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("이름 개수와 사다리의 너비가 다를 경우 사다리 게임 생성에서 예외가 발생한다.")
    @Test
    void constructFailWithDifferentSizeNamesAndLadder() {
        Ladder differentSizeLadder =
                new Ladder(new RandomBridgeConstructStrategy(), new Names(List.of("1", "2")), new Height(5));
        assertThatThrownBy(() -> new LadderGame(NAMES_SIZE_OF_THREE, PRIZES_SIZE_OF_THREE, differentSizeLadder))
                .isInstanceOf(IllegalArgumentException.class);
    }
}
