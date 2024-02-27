package laddergame.domain;

import laddergame.domain.connectiongenerator.AllFalseConnectionGenerator;
import laddergame.domain.connectiongenerator.TrueFalseConnectionGenerator;
import laddergame.domain.gameelements.people.People;
import laddergame.domain.gameelements.results.Results;
import laddergame.domain.ladder.Ladder;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;

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

        LadderGame testGame1 = new LadderGame(people, testLadder1, results);
        LadderGame testGame2 = new LadderGame(people, testLadder2, results);
        LadderGame testGame3 = new LadderGame(people, testLadder3, results);

        assertAll(
                () -> assertEquals(List.of("2", "1", "4", "3", "5"), testGame1.getGameResult()),
                () -> assertEquals(List.of("1", "2", "3", "4", "5"), testGame2.getGameResult()),
                () -> assertEquals(List.of("1", "2", "3", "4", "5"), testGame3.getGameResult())
        );
    }

}
