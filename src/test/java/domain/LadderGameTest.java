package domain;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.List;
import java.util.Map;
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
    private static WinningEntry winningEntry;

    @BeforeAll
    static void setUp() {
        List<String> names = List.of("pobi", "crong", "honux", "jk", "abcd");
        persons = new Persons(names.stream()
                .map(Person::new)
                .collect(Collectors.toList()));
        height = new Height(5);
        winningEntry = new WinningEntry(List.of("0", "1", "2", "3", "4"), 5);
    }

    @Test
    @DisplayName("항상 true 인 값이 생성될 때, 사다리 이동을 테스트한다")
    void moveWhenLadderAlwaysTrue() {
        //given
        ladderGame = new LadderGame(persons, height, winningEntry, new TrueGenerator());
        Map<String, String> expectedResult = Map.of("pobi", "1",
                "crong", "0",
                "honux", "3",
                "jk", "2",
                "abcd", "4");

        //when
        Map<String, String> result = ladderGame.play();

        //then
        assertThat(result).containsExactlyInAnyOrderEntriesOf(expectedResult);
        assertThat(result.values()).containsExactly("1", "0", "3", "2", "4");
    }

    @Test
    @DisplayName("항상 false 인 값이 생성될 때, 사다리 이동을 테스트한다")
    void moveWhenLadderAlwaysFalse() {
        //given
        ladderGame = new LadderGame(persons, height, winningEntry, new FalseGenerator());
        Map<String, String> expectedResult = Map.of("pobi", "0",
                "crong", "1",
                "honux", "2",
                "jk", "3",
                "abcd", "4");

        //when
        Map<String, String> result = ladderGame.play();

        //then
        assertThat(result).containsExactlyInAnyOrderEntriesOf(expectedResult);
        assertThat(result.values()).containsExactly("0", "1", "2", "3", "4");
    }
}