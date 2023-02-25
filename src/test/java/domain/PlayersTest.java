package domain;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;
import static org.junit.jupiter.api.Assertions.assertDoesNotThrow;

import exception.InvalidPlayerNameException;
import exception.InvalidPlayersSizeException;
import exception.PlayerDuplicationException;
import org.junit.jupiter.api.*;

import java.util.List;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.NullSource;
import org.junit.jupiter.params.provider.ValueSource;

@DisplayNameGeneration(DisplayNameGenerator.ReplaceUnderscores.class)
@TestInstance(TestInstance.Lifecycle.PER_CLASS)
public class PlayersTest {

    @Test
    void 사다리_게임을_위해서는_플레이어가_적어도_2명이_필요하다() {
        //when + then
        assertThatThrownBy(() -> new Players(List.of(new Player("ako"))))
            .isInstanceOf(InvalidPlayersSizeException.class);
    }

    @Test
    void 플레이어들의_이름_리스트를_반환하는_기능_테스트() {
        //given
        List<Player> playerList = List.of(new Player("judy"), new Player("ako"), new Player("pobi"));
        Players players = new Players(playerList);

        //when
        List<String> test = players.getPlayersName();

        //then
        Assertions.assertTrue(test.containsAll(List.of("ako", "judy", "pobi")));
    }

    @ParameterizedTest
    @NullSource
    @ValueSource(strings = {"", " ", "  ", "maco"})
    void 입력값이_players에_포함되지_않은면_에러를_발생시킨다(String player) {
        //given
        Players players = new Players(List.of(new Player("ako"), new Player("split"), new Player("ash")));

        //when + then
        assertThatThrownBy(() -> players.findPlayer(player))
            .isInstanceOf(InvalidPlayerNameException.class);
    }

    @Test
    void 입력값이_players에_포함되면_객체를_반환한다() {
        //given
        Players players = new Players(List.of(new Player("ako"), new Player("split"), new Player("ash")));
        String playerName = "ako";

        //when
        Player result = players.findPlayer(playerName);

        //then
        assertThat(result.getName()).isEqualTo(playerName);
    }

    @Test
    void 중복된_이름이_있으면_Players_객체를_생성하지_않고_에러를_발생시킨다() {
        //given
        List<String> players = List.of("ako", "ako", "ash", "split");

        //when + then
        assertThatThrownBy(() -> Players.generatePlayer(players))
            .isInstanceOf(PlayerDuplicationException.class);

    }

    @Test
    void 중복된_이름이_없으면_Players_객체를_생성한다() {
        //given
        List<String> player = List.of("ako","ash", "split");

        //when + then
        assertDoesNotThrow(() -> Players.generatePlayer(player));
    }
}
