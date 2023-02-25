package domain;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.List;
import java.util.Map;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

class LadderGameTest {

    @ParameterizedTest(name = "이름이 입력되면 알맞은 결과를 반환해야한다. name: {0}, expectedResult: {1}")
    @CsvSource(value = {"포비:포비결과", "글렌:글렌결과", "베로:베로결과"}, delimiter = ':')
    void get_appropriate_name_result(String name, String expectedResult) {
        LadderGame ladderGame = createLadderGame();

        Result result = ladderGame.getResultOf(name);

        assertThat(result).isEqualTo(new Result(expectedResult));
    }

    @ParameterizedTest(name = "게임의 모든 결과를 정확하게 가져와야 한다. name: {0}, expectedResult: {1}")
    @CsvSource(value = {"포비:포비결과", "글렌:글렌결과", "베로:베로결과"}, delimiter = ':')
    void get_all_result(String name, String expectedResult) {
        LadderGame ladderGame = createLadderGame();

        Map<Name, Result> namesAndResults = ladderGame.getAllNamesAndResults();

        assertThat(namesAndResults.get(new Name(name))).isEqualTo(new Result(expectedResult));
    }


    private static LadderGame createLadderGame() {
        int numberOfPeople = 3;
        LadderHeight ladderHeight = new LadderHeight(3, numberOfPeople);
        List<Integer> numberListToGenerate = List.of(0);
        MockNumberGenerator numberGenerator = new MockNumberGenerator(numberListToGenerate);
        Ladder ladder = Ladder.of(numberOfPeople, ladderHeight, numberGenerator);
        Names names = new Names(List.of(new Name("포비"), new Name("글렌"), new Name("베로")));
        Results results = new Results(List.of(new Result("포비결과"), new Result("글렌결과"), new Result("베로결과")),
                names);
        return LadderGame.of(names, ladder, results);
    }
}