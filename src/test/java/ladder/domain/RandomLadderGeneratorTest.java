package ladder.domain;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertThrows;

public class RandomLadderGeneratorTest {

    @Test
    void generateLadderWithOnePlayerTest() {
        Players.NUM_OF_PLAYERS = 1;
        assertThrows(RuntimeException.class, () -> RandomLadderGenerator.generate(1, new LadderHeight(2)));
    }

    @Test
    void generateLadderWithTwoPlayersTest() {
        Players.NUM_OF_PLAYERS = 2;
        System.out.println("Test of two players ladder");
        Ladder ladder = RandomLadderGenerator.generate(2, new LadderHeight(2));
        while(ladder.hasNextLine()) {
            System.out.println(ladder.getNextLine());
        }
    }

    @Test
    void generateLadderWithThreePlayersTest() {
        Players.NUM_OF_PLAYERS = 3;
        System.out.println("Test of three players ladder");
        Ladder ladder = RandomLadderGenerator.generate(3, new LadderHeight(2));
        while(ladder.hasNextLine()) {
            System.out.println(ladder.getNextLine());
        }
    }
}
