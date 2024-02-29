package domain;

import java.util.List;
import java.util.Map;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

class LadderGameResultTest {
    private static final Names VALID_NAMES = new Names(
            List.of(new Name("a"), new Name("b"), new Name("c")));
    private static final LadderResults VALID_LADDER_RESULTS = new LadderResults(
            List.of(new LadderResult("상품1"), new LadderResult("상품2"), new LadderResult("상품3")));
    private static final Ladder VALID_LADDER = new Ladder(new Height(5), new Width(3),
            new BridgesTestGenerator(List.of(true, false)));

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
    @CsvSource({"5,0,1",
            "6,0,0"})
    @DisplayName("참여자 이름에 대응하는 사다리 게임 결과 반환")
    void testGetLadderResultFromName(int height, int nameIndex, int ladderResultIndex) {
        Ladder ladder = new Ladder(new Height(height), new Width(2), new BridgesTestGenerator(List.of(true)));
        LadderGameResult ladderGameResult = new LadderGameResult(VALID_NAMES, VALID_LADDER_RESULTS, ladder);
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
    void testGetLadderResultFromName() {
        LadderGameResult ladderGameResult = new LadderGameResult(VALID_NAMES, VALID_LADDER_RESULTS, VALID_LADDER);
        Map<Name, LadderResult> nameLadderResultMap = ladderGameResult.getLadderGameResult();
        VALID_NAMES.getNames()
                .forEach(name -> Assertions.assertThat(nameLadderResultMap.get(name)).isNotNull());
    }


    static class BridgesTestGenerator implements BridgesGenerator {
        private final List<Boolean> bridges;

        BridgesTestGenerator(List<Boolean> bridges) {
            this.bridges = bridges;
        }

        @Override
        public Bridges generate(int width) {
            return new Bridges(bridges);
        }
    }
}