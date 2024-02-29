package domain.model;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import java.util.List;
import java.util.Map;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.AssertionsForClassTypes.assertThatCode;

public class LadderGameTest {
    @Test
    @DisplayName("사다리게임을 만든다")
    void makeLadderGame() {
        //given
        // |--|   |
        // |--|   |
        Ladder ladder = new Ladder("2", 3,()->true);
        People people=new People(List.of("a","b","c"));
        Consequences consequences =new Consequences(List.of("꽝","100","200"),3);
        //when
        LadderGame ladderGame=new LadderGame(ladder,people, consequences);
        //then
        assertThatCode(()->new LadderGame(ladder,people, consequences)).doesNotThrowAnyException();
    }
    @ParameterizedTest
    @CsvSource({
            "a,꽝",
            "b,100",
            "c,200"
    })
    @DisplayName("게임을 진행하고 결과를 얻는다")
    void playGameTest(String person,String consequence) {
        //given
        Ladder ladder = new Ladder("2", 3,()->true);
        People people=new People(List.of("a","b","c"));
        Consequences consequences =new Consequences(List.of("꽝","100","200"),3);
        LadderGame ladderGame=new LadderGame(ladder,people, consequences);
        //when
        ladderGame.play();
        Map<String,String> result=ladderGame.giveResult();
        //then
        assertThat(result.get(person)).isEqualTo(consequence);
    }
}
