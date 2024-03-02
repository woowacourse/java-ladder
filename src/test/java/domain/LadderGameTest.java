package domain;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatNoException;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

import domain.ladder.Bridge;
import domain.ladder.Height;
import domain.ladder.Ladder;
import domain.ladder.bridgeConstructstrategy.CustomLineConstructStrategy;
import domain.ladder.bridgeConstructstrategy.RandomLineConstructStrategy;
import domain.player.Name;
import domain.player.Names;
import domain.result.Prize;
import domain.result.Prizes;
import java.util.List;
import java.util.stream.Stream;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

class LadderGameTest {

    private static final Prizes PRIZES_SIZE_OF_THREE = new Prizes(List.of("1", "2", "3"));
    private static final Names NAMES_SIZE_OF_THREE = new Names(List.of("name1", "name2", "name3"));
    private static final Ladder DEFAULT_LADDER_SIZE_OF_THREE =
            new Ladder(new RandomLineConstructStrategy(), NAMES_SIZE_OF_THREE, new Height(5));

    @DisplayName("정상적으로 사다리게임이 생성된다.")
    @Test
    void constructSuccessTest() {
        assertThat(NAMES_SIZE_OF_THREE.size())
                .isEqualTo(PRIZES_SIZE_OF_THREE.size());
        assertThatNoException()
                .isThrownBy(
                        () -> new LadderGame(NAMES_SIZE_OF_THREE, PRIZES_SIZE_OF_THREE, DEFAULT_LADDER_SIZE_OF_THREE));
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
                new Ladder(new RandomLineConstructStrategy(), new Names(List.of("1", "2")), new Height(5));
        assertThatThrownBy(() -> new LadderGame(NAMES_SIZE_OF_THREE, PRIZES_SIZE_OF_THREE, differentSizeLadder))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @Nested
    @DisplayName("임의의 사다리 생성 후 결과 테스트")
    class CustomLadderPrizeTest {
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
        private static final Prizes PRIZES = new Prizes(List.of("꽝", "5000", "꽝", "3000"));
        private static final Ladder CUSTOM_LADDER = new Ladder(
                new CustomLineConstructStrategy(List.of(
                        List.of(Bridge.BUILT, Bridge.EMPTY, Bridge.BUILT),
                        List.of(Bridge.EMPTY, Bridge.BUILT, Bridge.EMPTY),
                        List.of(Bridge.BUILT, Bridge.EMPTY, Bridge.EMPTY),
                        List.of(Bridge.EMPTY, Bridge.BUILT, Bridge.EMPTY),
                        List.of(Bridge.BUILT, Bridge.EMPTY, Bridge.BUILT)
                )), NAMES, new Height(5)
        );
        private static final LadderGame LADDER_GAME = new LadderGame(NAMES, PRIZES, CUSTOM_LADDER);

        @DisplayName("사다리 게임의 각 결과가 정상적으로 조회된다.")
        @ParameterizedTest
        @MethodSource("getNameAndPrizeForResultTest")
        void resultForEachPlayerTest(Name name, Prize prize) {
            assertThat(LADDER_GAME.findEachPrize(name))
                    .isEqualTo(new MatchingResult(name, prize));
        }

        static Stream<Arguments> getNameAndPrizeForResultTest() {
            return Stream.of(
                    Arguments.of(new Name("pobi"), new Prize("꽝")),
                    Arguments.of(new Name("honux"), new Prize("3000")),
                    Arguments.of(new Name("crong"), new Prize("꽝")),
                    Arguments.of(new Name("jk"), new Prize("5000"))
            );
        }

        @DisplayName("존재하지 않는 사람의 결과를 조회하면 예외가 발생한다.")
        @Test
        void exceptionTestForNotExistPlayer() {
            assertThatThrownBy(() -> LADDER_GAME.findEachPrize(new Name("takan")))
                    .isInstanceOf(IllegalArgumentException.class);
        }

        @DisplayName("사다리의 전체 결과를 조회할 수 있다.")
        @Test
        void resultForAllPlayerTest() {
            assertThat(LADDER_GAME.findAllResult())
                    .containsAnyElementsOf(
                            List.of(
                                    new MatchingResult(new Name("pobi"), new Prize("꽝")),
                                    new MatchingResult(new Name("honux"), new Prize("3000")),
                                    new MatchingResult(new Name("crong"), new Prize("꽝")),
                                    new MatchingResult(new Name("jk"), new Prize("5000"))
                            ));
        }
    }
}
