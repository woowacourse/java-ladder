package laddergame.domain;

import laddergame.domain.connectiongenerator.AllFalseConnectionGenerator;
import laddergame.domain.connectiongenerator.TrueFalseConnectionGenerator;
import laddergame.domain.gameelements.people.Name;
import laddergame.domain.gameelements.people.People;
import laddergame.domain.gameelements.results.Result;
import laddergame.domain.gameelements.results.Results;
import laddergame.domain.ladder.Ladder;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;
import java.util.Map;

import static org.junit.jupiter.api.Assertions.assertAll;
import static org.junit.jupiter.api.Assertions.assertEquals;

class LadderGameTest {

    @DisplayName("사다리 게임 수행 결과 테스트")
    @Test
    void ladderGameResultTest() {
        People people = new People(List.of("a", "b", "c", "d", "e"));
        int peopleNumber = people.getNames().size();

        Results results = new Results(List.of("1", "2", "3", "4", "5"), peopleNumber);
        Ladder testLadder1 = new Ladder(3, peopleNumber, new TrueFalseConnectionGenerator());
        Ladder testLadder2 = new Ladder(4, peopleNumber, new TrueFalseConnectionGenerator());
        Ladder testLadder3 = new Ladder(5, peopleNumber, new AllFalseConnectionGenerator());

        Map<Name, Result> testGame1 = new LadderGame(people, testLadder1, results).getPlayerGameResult();
        Map<Name, Result> testGame2 = new LadderGame(people, testLadder2, results).getPlayerGameResult();
        Map<Name, Result> testGame3 = new LadderGame(people, testLadder3, results).getPlayerGameResult();

        List<Result> expected1 = List.of(new Result("2"), new Result("1"), new Result("4"), new Result("3"), new Result("5"));
        List<Result> expected2 = List.of(new Result("1"), new Result("2"), new Result("3"), new Result("4"), new Result("5"));
        List<Result> expected3 = List.of(new Result("1"), new Result("2"), new Result("3"), new Result("4"), new Result("5"));


        List<Result> gameResult1 = testGame1.keySet().stream().map(key -> testGame1.get(key)).toList();
        List<Result> gameResult2 = testGame2.keySet().stream().map(key -> testGame2.get(key)).toList();
        List<Result> gameResult3 = testGame3.keySet().stream().map(key -> testGame3.get(key)).toList();

        assertAll(() -> {
            for (int i = 0; i < expected1.size(); i++) {
                assertEquals(expected1.get(i), gameResult1.get(i));
            }
        }, () -> {
            for (int i = 0; i < expected2.size(); i++) {
                assertEquals(expected2.get(i), gameResult2.get(i));
            }
        }, () -> {
            for (int i = 0; i < expected3.size(); i++) {
                assertEquals(expected3.get(i), gameResult3.get(i));
            }
        });
    }

}
