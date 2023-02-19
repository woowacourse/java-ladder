package domain;

import static org.assertj.core.api.Assertions.assertThatThrownBy;

import org.junit.jupiter.api.*;

import java.util.List;

@DisplayNameGeneration(DisplayNameGenerator.ReplaceUnderscores.class)
@TestInstance(TestInstance.Lifecycle.PER_CLASS)
public class PlayersTest {
    private final List<Player> playerList = List.of(new Player("judy"), new Player("ako"), new Player("pobi")) ;
    private final Players players = new Players(playerList);

    @Test
    void 사다리_게임을_위해서는_플레이어가_적어도_2명이_필요하다() {
        //when + then
        assertThatThrownBy(() -> new Players(List.of(new Player("ako"))))
            .isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    void getPlayersName_메서드_테스트() {
        //when
        List<String> test = players.getPlayersName();

        //then
        Assertions.assertTrue(test.containsAll(List.of("ako", "judy", "pobi")));
    }
}
