package domain;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.List;
import java.util.stream.Collectors;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import util.FalseGenerator;
import util.TrueGenerator;

class LadderGameTest {
    private LadderGame ladderGame;
    private static Persons persons;
    private static Height height;

    @BeforeAll
    static void setUp() {
        List<String> names = List.of("pobi", "crong", "honux", "jk", "abcd");
        persons = new Persons(names.stream()
                .map(Person::new)
                .collect(Collectors.toList()));
        height = new Height(5);
    }

    @Test
    @DisplayName("항상 true 인 값이 생성될 때, 사다리 이동을 테스트한다")
    void moveWhenLadderAlwaysTrue() {
        //given
        ladderGame = new LadderGame(persons, height, new TrueGenerator());

        //when
        List<Integer> afterMovePersonIndex = ladderGame.play();

        //then
        assertThat(afterMovePersonIndex).containsExactly(1, 0, 3, 2, 4);
    }

    @Test
    @DisplayName("항상 false 인 값이 생성될 때, 사다리 이동을 테스트한다")
    void moveWhenLadderAlwaysFalse() {
        //given
        ladderGame = new LadderGame(persons, height, new FalseGenerator());

        //when
        List<Integer> afterMovePersonIndex = ladderGame.play();

        //then
        assertThat(afterMovePersonIndex).containsExactly(0, 1, 2, 3, 4);
    }
}