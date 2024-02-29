package laddergame.domain;

import laddergame.domain.connectiongenerator.AllFalseConnectionGenerator;
import laddergame.domain.connectiongenerator.TrueFalseConnectionGenerator;
import laddergame.domain.gameelements.Element;
import laddergame.domain.gameelements.Elements;
import laddergame.domain.ladder.Ladder;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;
import java.util.Map;

import static org.junit.jupiter.api.Assertions.assertAll;
import static org.junit.jupiter.api.Assertions.assertEquals;

class LadderGameTest {
    //TODO 테스트 코드 단순화 + 책임 분리
    @DisplayName("사다리 게임 수행 결과 테스트")
    @Test
    void ladderGameResultTest() {

        /*
         *    [test case1]                      [test case2]                 [test case 3]
         *     a    b    c    d    e            a    b    c    d    e        a    b    c    d    e
         *     |----|    |----|    |            |----|    |----|    |        |    |    |    |    |
         *     |----|    |----|    |            |----|    |----|    |        |    |    |    |    |
         *     |----|    |----|    |            |----|    |----|    |        |    |    |    |    |
         *     1    2    3    4    5            |----|    |----|    |        |    |    |    |    |
         *                                      1    2    3    4    5        |    |    |    |    |
         *                                                                   1    2    3    4    5
         * 예상 결과        a    b    c    d    e
         * test case 1    2    1    4    3    5
         * test case 2    1    2    3    4    5
         * test case 3    1    2    3    4    5
         * */
        Elements people = new Elements(List.of("a", "b", "c", "d", "e"));
        int peopleNumber = people.getElements().size();

        Elements results = new Elements(List.of("1", "2", "3", "4", "5"));
        Ladder testLadder1 = new Ladder(3, peopleNumber, new TrueFalseConnectionGenerator());
        Ladder testLadder2 = new Ladder(4, peopleNumber, new TrueFalseConnectionGenerator());
        Ladder testLadder3 = new Ladder(5, peopleNumber, new AllFalseConnectionGenerator());

        Map<Element, Element> testGame1 = new LadderGame(people, testLadder1, results).getPlayerGameResult();
        Map<Element, Element> testGame2 = new LadderGame(people, testLadder2, results).getPlayerGameResult();
        Map<Element, Element> testGame3 = new LadderGame(people, testLadder3, results).getPlayerGameResult();


        List<Element> expected1 = List.of(new Element("2"), new Element("1"), new Element("4"), new Element("3"), new Element("5"));
        List<Element> expected2 = List.of(new Element("1"), new Element("2"), new Element("3"), new Element("4"), new Element("5"));
        List<Element> expected3 = List.of(new Element("1"), new Element("2"), new Element("3"), new Element("4"), new Element("5"));


        List<Element> gameResult1 = testGame1.keySet().stream().map(testGame1::get).toList();
        List<Element> gameResult2 = testGame2.keySet().stream().map(testGame2::get).toList();
        List<Element> gameResult3 = testGame3.keySet().stream().map(testGame3::get).toList();

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
