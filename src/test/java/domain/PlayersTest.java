package domain;

import org.junit.jupiter.api.*;

import java.util.ArrayList;
import java.util.List;

@DisplayNameGeneration(DisplayNameGenerator.ReplaceUnderscores.class)
@TestInstance(TestInstance.Lifecycle.PER_CLASS)
public class PlayersTest {
    Players players;
    List<Player> playerList;
    List<String> nameList;

    @BeforeAll
    void initSetting() {
        nameList = new ArrayList<>(List.of("judy", "ako", "pobi"));
        playerList = new ArrayList<>(List.of(new Player("judy"), new Player("ako"), new Player("pobi")));
    }

    @Test
    void getPlayersName_메서드_테스트() {
        this.players = new Players(new PlayerNames(nameList));
        List<String> test = players.getPlayersName();
        Assertions.assertTrue(test.containsAll(List.of("ako", "judy", "pobi")));
    }
}
