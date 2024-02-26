package domain;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatNoException;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

import domain.ladder.Bridge;
import domain.ladder.Height;
import domain.ladder.Ladder;
import domain.ladder.bridgeConstructstrategy.CustomBridgeConstructStrategy;
import domain.ladder.bridgeConstructstrategy.RandomBridgeConstructStrategy;
import domain.player.Name;
import domain.player.Names;
import domain.result.Result;
import domain.result.Results;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;

class GameResultTest {

    private static final Results RESULTS_SIZE_OF_THREE = new Results(List.of("1", "2", "3"));
    private static final Names NAMES_SIZE_OF_THREE = new Names(List.of("name1", "name2", "name3"));
    private static final Ladder DEFAULT_LADDER_SIZE_OF_THREE =
            new Ladder(new RandomBridgeConstructStrategy(), NAMES_SIZE_OF_THREE, new Height(5));

    @DisplayName("정상적으로 사다리게임이 생성된다.")
    @Test
    void constructSuccessTest() {
        assertThat(NAMES_SIZE_OF_THREE.size())
                .isEqualTo(RESULTS_SIZE_OF_THREE.size());
        assertThatNoException()
                .isThrownBy(() -> new GameResult(NAMES_SIZE_OF_THREE, RESULTS_SIZE_OF_THREE,
                        DEFAULT_LADDER_SIZE_OF_THREE));
    }

    @DisplayName("이름과 결과의 개수가 다를 경우, 사다리 생성에서 예외가 발생한다.")
    @Test
    void constructFailWithDifferentSizeNamesAndResults() {
        Results DifferentSizeResults = new Results(List.of("1", "2", "3", "4"));
        assertThat(NAMES_SIZE_OF_THREE.size())
                .isNotEqualTo(DifferentSizeResults.size());
        assertThatThrownBy(
                () -> new GameResult(NAMES_SIZE_OF_THREE, DifferentSizeResults, DEFAULT_LADDER_SIZE_OF_THREE))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("이름 개수와 사다리의 너비가 다를 경우 사다리 생성에서 예외가 발생한다.")
    @Test
    void constructFailWithDifferentSizeNamesAndLadder() {
        Ladder differentSizeLadder =
                new Ladder(new RandomBridgeConstructStrategy(), new Names(List.of("1", "2")), new Height(5));
        assertThatThrownBy(() -> new GameResult(NAMES_SIZE_OF_THREE, RESULTS_SIZE_OF_THREE, differentSizeLadder))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @Nested
    @DisplayName("임의의 사다리 생성 후 결과 테스트")
    class CustomLadderResultTest {
        /*
         pobi honux crong    jk
            |-----|     |-----|
            |     |-----|     |
            |-----|     |     |
            |     |-----|     |
            |-----|     |-----|
            꽝 5000     꽝  3000
         */
        private static final Names NAMES = new Names(List.of("pobi", "honux", "crong", "jk"));
        private static final Results RESULTS = new Results(List.of("꽝", "5000", "꽝", "3000"));
        private static final Ladder CUSTOM_LADDER = new Ladder(
                new CustomBridgeConstructStrategy(List.of(
                        List.of(Bridge.BUILT, Bridge.EMPTY, Bridge.BUILT),
                        List.of(Bridge.EMPTY, Bridge.BUILT, Bridge.EMPTY),
                        List.of(Bridge.BUILT, Bridge.EMPTY, Bridge.EMPTY),
                        List.of(Bridge.EMPTY, Bridge.BUILT, Bridge.EMPTY),
                        List.of(Bridge.BUILT, Bridge.EMPTY, Bridge.BUILT)
                )), NAMES, new Height(5)
        );
        private static final GameResult CUSTOM_GAME_RESULT = new GameResult(NAMES, RESULTS, CUSTOM_LADDER);

        @DisplayName("사다리 게임의 각 결과가 정상적으로 조회된다.")
        @Test
        void resultForEachPlayerTest() {
            assertThat(CUSTOM_GAME_RESULT.getResult(new Name("pobi")))
                    .isEqualTo(new Result("꽝"));
            assertThat(CUSTOM_GAME_RESULT.getResult(new Name("honux")))
                    .isEqualTo(new Result("3000"));
            assertThat(CUSTOM_GAME_RESULT.getResult(new Name("crong")))
                    .isEqualTo(new Result("꽝"));
            assertThat(CUSTOM_GAME_RESULT.getResult(new Name("jk")))
                    .isEqualTo(new Result("5000"));
        }

        @DisplayName("존재하지 않는 사람의 결과를 조회하면 예외가 발생한다.")
        @Test
        void exceptionTestForNotExistPlayer() {
            assertThatThrownBy(() -> CUSTOM_GAME_RESULT.getResult(new Name("takan")))
                    .isInstanceOf(IllegalArgumentException.class);
        }

        @DisplayName("사다리의 전체 결과를 조회할 수 있다.")
        @Test
        void resultForAllPlayerTest() {
            assertThat(CUSTOM_GAME_RESULT.getAllResult())
                    .containsExactlyInAnyOrderEntriesOf(
                            Map.of(
                                    new Name("pobi"), new Result("꽝"),
                                    new Name("honux"), new Result("3000"),
                                    new Name("crong"), new Result("꽝"),
                                    new Name("jk"), new Result("5000")
                            ));
        }
    }
}
