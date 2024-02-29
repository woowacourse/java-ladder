package laddergame.view;

import laddergame.domain.connectiongenerator.AllFalseConnectionGenerator;
import laddergame.domain.connectiongenerator.TrueFalseConnectionGenerator;
import laddergame.domain.gameelements.Players;
import laddergame.domain.ladder.Ladder;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

class MessageResolverTest {
    @Test
    @DisplayName("사람 이름 출력 테스트")
    void makePeopleMessageTest() {
        Players testPeople = new Players(List.of("a", "b", "c"));
        String expectedPeopleMessage = "a     b     c    ";
        assertEquals(expectedPeopleMessage
                , MessageResolver.resolveElementMessage(testPeople));
    }

    @Test
    @DisplayName("사다리 출력 테스트")
    void makeLadderMessageTest() {
        Ladder testLadder1 = new Ladder(1, 3, new AllFalseConnectionGenerator());
        Ladder testLadder2 = new Ladder(1, 4, new TrueFalseConnectionGenerator());

        String expectedLadder1 = "    |     |     |";
        String expectedLadder2 = "    |-----|     |-----|";

        assertEquals(expectedLadder1
                , MessageResolver.resolveLadderMessage(testLadder1));
        assertEquals(expectedLadder2
                , MessageResolver.resolveLadderMessage(testLadder2));
    }
}
