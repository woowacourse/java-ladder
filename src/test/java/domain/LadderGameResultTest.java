package domain;

import java.util.List;
import java.util.Map;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

class LadderGameResultTest {
    // 이 테스트에서 생성되는 사다리 모습
    //      a     b     c     d
    //      |-----|     |     |
    //      |     |-----|     |
    //      |     |     |-----|
    //      |-----|     |     |
    //      |     |-----|     |
    //   상품1  상품2  상품3   상품4
    private static final Height VALID_HEIGHT = new Height(5);
    private static final Width VALID_WIDTH = new Width(3);
    private static final Names VALID_NAMES = new Names(
            List.of(new Name("a"), new Name("b"), new Name("c"), new Name("d")));
    private static final LadderResults VALID_LADDER_RESULTS = new LadderResults(
            List.of(new LadderResult("상품1"), new LadderResult("상품2"), new LadderResult("상품3"),
                    new LadderResult("상품4")));
    private static final Ladder VALID_LADDER = new Ladder(VALID_HEIGHT, VALID_WIDTH,
            new LadderTestGenerator(List.of(
                    new Bridges(List.of(true, false, false)),
                    new Bridges(List.of(false, true, false)),
                    new Bridges(List.of(false, false, true)),
                    new Bridges(List.of(true, false, false)),
                    new Bridges(List.of(false, true, false))),
                    VALID_HEIGHT, VALID_WIDTH));

    @Test
    @DisplayName("이름 개수와 사다리 결과 개수가 같지 않으면 예외 발생")
    void validateLadderResultNamesLength() {
        Names names = new Names(List.of(new Name("name1"), new Name("name2")));
        Assertions.assertThatThrownBy(() -> new LadderGameResult(names, VALID_LADDER_RESULTS, VALID_LADDER))
                .isInstanceOf(LadderGameException.class)
                .hasMessage(ExceptionType.NOT_ALLOW_DIFFERENT_NAMES_LADDER_RESULTS_LENGTH.getMessage());
    }

    @Test
    @DisplayName("이름과 사다리 결과가 같으면 사다리 게임 결과 생성")
    void testCreateLadderGameResult() {
        Assertions.assertThatCode(() -> new LadderGameResult(VALID_NAMES, VALID_LADDER_RESULTS, VALID_LADDER))
                .doesNotThrowAnyException();
    }

    @ParameterizedTest
    @CsvSource({"0,3", "1,2", "2,0", "3,1"})
    @DisplayName("참여자 이름에 대응하는 사다리 게임 결과 반환")
    void testGetLadderResultFromName(int nameIndex, int ladderResultIndex) {
        LadderGameResult ladderGameResult = new LadderGameResult(VALID_NAMES, VALID_LADDER_RESULTS, VALID_LADDER);
        LadderResult actual = ladderGameResult.getLadderResultFromName(VALID_NAMES.getNames().get(nameIndex));
        LadderResult expected = VALID_LADDER_RESULTS.getLadderResults().get(ladderResultIndex);
        Assertions.assertThat(actual).isEqualTo(expected);
    }

    @Test
    @DisplayName("참여자 이름이 존재하지 않을 경우 예외 발생")
    void validateNameExist() {
        LadderGameResult ladderGameResult = new LadderGameResult(VALID_NAMES, VALID_LADDER_RESULTS, VALID_LADDER);
        Name name = new Name("name3");
        Assertions.assertThatThrownBy(() -> ladderGameResult.getLadderResultFromName(name))
                .isInstanceOf(LadderGameException.class)
                .hasMessage(ExceptionType.INVALID_SEARCH_NAME.getMessage());
    }

    @Test
    @DisplayName("전체 참여자 별 사다리 결과 반환")
    void testGetLadderGameResult() {
        LadderGameResult ladderGameResult = new LadderGameResult(VALID_NAMES, VALID_LADDER_RESULTS, VALID_LADDER);
        Map<Name, LadderResult> nameLadderResultMap = ladderGameResult.getLadderGameResult();
        VALID_NAMES.getNames()
                .forEach(name -> Assertions.assertThat(nameLadderResultMap.get(name)).isNotNull());
    }


    static class LadderTestGenerator implements BridgesGenerator {
        private final List<Bridges> ladder;
        private int currentLadderPosition = 0;

        LadderTestGenerator(List<Bridges> ladder, Height height, Width width) {
            if (ladder.size() != height.getLength()) {
                throw new IllegalArgumentException("사다리 행 개수는 높이와 일치해야 합니다.");
            }
            if (ladder.get(0).getBridges().size() != width.getLength()) {
                throw new IllegalArgumentException("사다리 폭 개수는 폭과 일치해야 합니다.");
            }

            this.ladder = ladder;
        }

        @Override
        public Bridges generate(int width) {
            return ladder.get(currentLadderPosition++);
        }
    }
}