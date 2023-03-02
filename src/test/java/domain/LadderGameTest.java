package domain;

import static java.util.stream.Collectors.collectingAndThen;
import static java.util.stream.Collectors.toList;
import static org.assertj.core.api.Assertions.assertThat;

import java.util.List;
import java.util.concurrent.atomic.AtomicInteger;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

class LadderGameTest {

    @ParameterizedTest(name = "이름이 입력되면 알맞은 결과를 반환해야한다. name: {0}, expectedResult: {1}")
    @CsvSource(value = {"포비:포비결과:0", "글렌:글렌결과:1", "베로:베로결과:2"}, delimiter = ':')
    void get_appropriate_name_result(Name name, String expectedResult, String position) {
        LadderGame ladderGame = createLadderGame();
        Player player = new Player(name, new Position(Integer.parseInt(position)));

        Result result = ladderGame.getResultOf(player);

        assertThat(result).isEqualTo(new Result(expectedResult));
    }

    private static LadderGame createLadderGame() {
        int numberOfPeople = 3;
        LadderHeight ladderHeight = new LadderHeight(3, numberOfPeople);
        List<Integer> numberListToGenerate = List.of(0);
        MockNumberGenerator numberGenerator = new MockNumberGenerator(numberListToGenerate);
        Ladder ladder = Ladder.of(numberOfPeople, ladderHeight, numberGenerator);
        List<Name> names = List.of(new Name("포비"), new Name("글렌"), new Name("베로"));
        AtomicInteger index = new AtomicInteger();
        Players players = names.stream()
                .map(name -> new Player(name, new Position(index.getAndIncrement())))
                .collect(collectingAndThen(toList(), Players::new));
        Results results = new Results(List.of(new Result("포비결과"), new Result("글렌결과"), new Result("베로결과")),
                players);
        return new LadderGame(ladder, results);
    }
}