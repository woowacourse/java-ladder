package domain;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.List;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

class LadderGameTest {

    @DisplayName("이름이 입력되면 알맞은 결과를 반환해야한다.")
    @ParameterizedTest
    @CsvSource (value = {"pobi:포비결과", "glen:글렌결과", "vero:베로결과"}, delimiter = ':')
    void test(String name, String expectedResult) {
        //given
        LadderGame ladderGame = createLadderGame();

        Result result = ladderGame.getResultOf(name);

        assertThat(result).isEqualTo(new Result(expectedResult));
    }


    private static LadderGame createLadderGame() {
        int numberOfPeople = 3;
        LadderHeight ladderHeight = new LadderHeight(3);
        List<Integer> numberListToGenerate = List.of(0);
        MockNumberGenerator numberGenerator = new MockNumberGenerator(numberListToGenerate);
        Ladder ladder = Ladder.create(numberOfPeople, ladderHeight, numberGenerator);
        Names names = new Names(List.of(new Name("pobi"), new Name("glen"), new Name("vero")));
        Results results = new Results(List.of(new Result("포비결과"), new Result("글렌결과"), new Result("베로결과")), names.size());
        LadderGame ladderGame = new LadderGame(ladder, names, results);
        return ladderGame;
    }
}