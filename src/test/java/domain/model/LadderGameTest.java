package domain.model;

import domain.model.consequence.Consequences;
import domain.model.ladder.Ladder;
import domain.model.ladder.LadderGame;
import domain.model.ladder.Result;
import domain.model.participant.People;
import domain.model.participant.Person;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.AssertionsForClassTypes.assertThatCode;

public class LadderGameTest {
    @Test
    @DisplayName("사다리게임을 만든다")
    void makeLadderGame() {
        Ladder ladder = new Ladder("2", 3, () -> true);
        People people = new People(List.of("a", "b", "c"));
        Consequences consequences = new Consequences(List.of("꽝", "100", "200"), 3);

        assertThatCode(() -> new LadderGame(ladder, people, consequences)).doesNotThrowAnyException();
    }

    @Test
    @DisplayName("게임을 진행하고 결과를 얻는다")
    void playGameTest() {
        //given
        Ladder ladder = new Ladder("2", 3, () -> true);
        People people = new People(List.of("a", "b", "c"));
        Consequences consequences = new Consequences(List.of("꽝", "100", "200"), 3);
        LadderGame ladderGame = new LadderGame(ladder, people, consequences);
        //when
        ladderGame.play();
        Result result = ladderGame.giveResult();
        //then
        for (int i = 0; i < 3; i++) {
            Person person = people.getNameByOrder(i);
            String consequence = consequences.getConsequenceByOrder(i).getValue();
            assertThat(result.showConsequence(person)).isEqualTo(consequence);
        }
    }
}
