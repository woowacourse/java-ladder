package ladder.model;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;


class GameTest {
    List<String> names;
    List<String> outcomes;
    Game game;

    @BeforeEach
    void setUp() {
        names = Arrays.asList("a", "b", "c", "d", "e");
        outcomes = Arrays.asList("A", "B", "C", "D", "E");
    }

    @Test
    void getResults() {
        game = new Game(names, outcomes, 6);
        assertThat(game.getOutcomes()).containsOnlyElementsOf(game.getResults());
    }
}