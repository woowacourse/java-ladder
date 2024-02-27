package laddergame.view;

import laddergame.domain.connectiongenerator.AllFalseConnectionGenerator;
import laddergame.domain.gameelements.Elements;
import laddergame.domain.ladder.Ladder;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

class MessageResolverTest {
    @Test
    @DisplayName("사람 이름 출력 테스트")
    void makePeopleMessageTest() {
        Elements testPeople = new Elements(List.of("a", "b", "c"));
        String expectedPeopleMessage = "a     b     c    ";
        assertEquals(expectedPeopleMessage
                , MessageResolver.resolveElementMessage(testPeople));
    }

    @Test
    @DisplayName("사다리 출력 테스트")
    void makeLadderMessageTest() {
        Ladder testLadder = new Ladder(1, 3, new AllFalseConnectionGenerator());
        String expectedLadder = "    |     |     |";
        assertEquals(expectedLadder
                , MessageResolver.resolveLadderMessage(testLadder));
    }
}
