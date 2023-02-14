package domain;

import org.junit.jupiter.api.*;

import java.util.ArrayList;
import java.util.List;

@DisplayNameGeneration(DisplayNameGenerator.ReplaceUnderscores.class)
public class PlayersTest {
    List<Player> players;

    @BeforeAll
    void initSetting(){
        this.players = new ArrayList<>();
        players.add(new Player("ako"));
    }

    @Test
    void 사다리_게임을_위해서는_플레이어가_적어도_2명이_필요하다(){
        Assertions.assertThrows(IllegalArgumentException.class, () -> {
            new Players(players);
        });
    }
}
