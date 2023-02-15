package domain;

import org.junit.jupiter.api.*;

import java.util.List;

@DisplayNameGeneration(DisplayNameGenerator.ReplaceUnderscores.class)
public class PlayersTest {
    Players players;
    List<Player> playerList;

    @BeforeAll
    void initSetting(){
        Player judy = new Player("judy");
        Player ako = new Player("ako");
        Player pobi = new Player("pobi");

        playerList.add(judy);
        playerList.add(ako);
        playerList.add(pobi);
    }

    @Test
    void 사다리_게임을_위해서는_플레이어가_적어도_2명이_필요하다() {
        Assertions.assertThrows(IllegalArgumentException.class, () -> {
            new Players(List.of(new Player("ako")));
        });
    }

    @Test
    void getPlayersName_메서드_테스트() {
        this.players = new Players(playerList);
        List<String> test = players.getPlayersName();
        Assertions.assertTrue(test.containsAll(List.of("ako", "judy", "pobi")));
    }
}
