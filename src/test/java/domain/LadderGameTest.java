package domain;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;
import static org.junit.jupiter.api.Assertions.*;

import java.util.List;
import java.util.Map;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import utils.PresentStepGenerator;

class LadderGameTest {

    @Test
    @DisplayName("사다리의 모든 유저 결과를 제대로 반환한다.")
    void allResultOfLadderTest() {
        Participants participants = new Participants(List.of("a", "b", "c"));
        Prizes prizes = new Prizes(List.of("1", "2", "3"), participants);
        Ladder ladder = new Ladder(2, 3, new PresentStepGenerator());

        LadderGame ladderGame = new LadderGame(participants, prizes, ladder);
        Map<String, String> expectedAllResult = Map.of("a", "1","b", "2", "c", "3");

        assertThat(ladderGame.allResultOfLadder()).isEqualTo(expectedAllResult);
    }

    @Test
    @DisplayName("사다리의 특정 유저 결과를 제대로 반환한다.")
    void oneResultOfLadderTest() {
        Participants participants = new Participants(List.of("a", "b", "c"));
        Prizes prizes = new Prizes(List.of("1", "2", "3"), participants);
        Ladder ladder = new Ladder(2, 3, new PresentStepGenerator());

        LadderGame ladderGame = new LadderGame(participants, prizes, ladder);
        String expectedOneResult = "1";

        assertThat(ladderGame.oneResultOfLadder("a")).isEqualTo(expectedOneResult);
    }
}
