package domain;

import java.util.List;
import java.util.Set;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class LadderGameTest {

    private People people;
    private Prizes ladderResult;
    private Ladder ladder;

    private Person pobi;
    private Person honux;
    private Person crong;
    private Person jk;

    @BeforeEach
    void init() {
        pobi = new Person("pobi", 0);
        honux = new Person("honux", 1);
        crong = new Person("crong", 2);
        jk = new Person("jk", 3);

        people = new People(List.of(pobi, honux, crong, jk));
        ladderResult = new Prizes(List.of("꽝", "5000", "꽝", "3000"), people.getCount());
        LadderGenerator testRadderGenerator = (width, height) -> List.of(
            new Line(List.of(true, false, true)),
            new Line(List.of(false, true, false)),
            new Line(List.of(true, false, false)),
            new Line(List.of(false, true, false)),
            new Line(List.of(true, false, true)));
        ladder = Ladder.make(people.getCount(), 5, testRadderGenerator);
    }

    @Test
    @DisplayName("사람 이름을 입력시 모든 해당 사람의 결과를 보여준다")
    void searchOneTest() {
        //given
        LadderGame ladderGame = new LadderGame(people, ladderResult, ladder);
        ladderGame.start();

        //when
        LadderResults results = ladderGame.searchResult("pobi");
        LadderResult result = results.getSingleResult();

        //then
        LadderResult expected = new LadderResult(pobi, "꽝");

        Assertions.assertThat(result).isEqualTo(expected);
    }

    @Test
    @DisplayName("all을 입력시 모든 결과를 보여준다")
    void searchAllTest() {
        //given
        LadderGame ladderGame = new LadderGame(people, ladderResult, ladder);
        ladderGame.start();

        //when
        LadderResults result = ladderGame.searchResult("all");

        //then
        Set<LadderResult> expected = Set.of(
            new LadderResult(pobi, "꽝"),
            new LadderResult(honux, "3000"),
            new LadderResult(crong, "꽝"),
            new LadderResult(jk, "5000"));
        Assertions.assertThat(result).containsAll(expected);
    }
}
