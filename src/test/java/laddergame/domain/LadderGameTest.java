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

import static org.junit.jupiter.api.Assertions.*;

class LadderGameTest {

    @DisplayName("사다리 게임 수행 결과 테스트")
    @Test
    void ladderGameResultTest() {
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

    @DisplayName("상위 게임요소의 수와 하위 게임요소의 수가 일치되지 않으면 LadderGame 객체가 생성되지 않는다")
    @Test
    void playerNumerNotEqualsResultNumberTest() {
        Elements people = new Elements(List.of("a", "b", "c", "d"));
        Elements results = new Elements(List.of("꽝", "1000", "꽝"));
        Ladder ladder = new Ladder(3, people.getElements().size());
        assertThrows(IllegalArgumentException.class,
                () -> new LadderGame(people, ladder, results));
    }

    @DisplayName("상위 게임요소의 수와 하위 게임요소의 수가 일치하면 LadderGame 객체가 생성된다")
    @Test
    void playerNumberEqualsResultNumberTest() {
        Elements people = new Elements(List.of("a", "b", "c"));
        Elements results = new Elements(List.of("꽝", "1000", "꽝"));
        Ladder ladder = new Ladder(3, people.getElements().size());
        assertDoesNotThrow(() -> new LadderGame(people, ladder, results));
    }

}
