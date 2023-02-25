package domain;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import domain.generator.NonExistConnectionGenerator;

public class LadderTest {

    private Name name1;
    private Name name2;
    private Name name3;
    private Name name4;
    private Result result1;
    private Result result2;

    @BeforeEach
    void setUp() {
        name1 = new Name("pobi");
        name2 = new Name("honux");
        name3 = new Name("crong");
        name4 = new Name("jk");
        result1 = new Result("당첨");
        result2 = new Result("꽝");
    }
    
    @DisplayName("Ladder의 makeResult메서드는 Names와 Results를 받아, 사다리 게임을 완료한 결과를 매칭시켜준다.")
    @Test
    void match_result_when_names_and_results_given() {
        // given
        List<Name> givenNames = List.of(name1, name2, name3, name4);
        List<Result> givenResults = List.of(result1, result2, result2, result2);

        Map<String, String> givenGameResult = new LinkedHashMap<>();
        givenGameResult.put(name1.getValue(), result1.getValue());
        givenGameResult.put(name2.getValue(), result2.getValue());
        givenGameResult.put(name3.getValue(), result2.getValue());
        givenGameResult.put(name4.getValue(), result2.getValue());

        Ladder ladder = new Ladder(givenNames.size(), 5, new NonExistConnectionGenerator());

        // when
        Map<String, String> expectedGameResult = ladder.matchResult(givenNames, givenResults);

        // then
        assertThat(expectedGameResult).isEqualTo(givenGameResult);
    }
}
