package domain.model;

import domain.vo.Name;
import domain.vo.Position;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.ValueSource;

import java.util.List;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

public class PlayersTest {
    @Test
    @DisplayName("플레이어 생성 테스트")
    void playersConstructTest(){
        Player player1 = new Player(new Name("test1"),new Position(0));
        Player player2 = new Player(new Name("test2"),new Position(1));
        Player player3 = new Player(new Name("test3"),new Position(2));
        Player player4 = new Player(new Name("test4"),new Position(3));
        List<Player> playerList = List.of(player1,player2,player3,player4);
        Players players = new Players(playerList);
        for (int i = 0; i < 4; i++) {
            assertThat(players.getPlayers().get(i)).isEqualTo(playerList.get(i));
        }
    }

    @ParameterizedTest(name = "플레이어 위치 반환 테스트")
    @CsvSource(value = {"test1:0","test2:1","test3:2","test4:3"},delimiter = ':')
    void getPlayersPosition(String provided,int result){
        Player player1 = new Player(new Name("test1"),new Position(0));
        Player player2 = new Player(new Name("test2"),new Position(1));
        Player player3 = new Player(new Name("test3"),new Position(2));
        Player player4 = new Player(new Name("test4"),new Position(3));
        List<Player> playerList = List.of(player1,player2,player3,player4);
        Players players = new Players(playerList);
        assertThat(players.getPlayersPosition(new Name(provided))).isEqualTo(List.of(result));
    }

    @Test
    @DisplayName("플레이어 이름 반환 테스트")
    void getPlayersNameTest(){
        Player player1 = new Player(new Name("test1"),new Position(0));
        Player player2 = new Player(new Name("test2"),new Position(1));
        Player player3 = new Player(new Name("test3"),new Position(2));
        Player player4 = new Player(new Name("test4"),new Position(3));
        List<Player> playerList = List.of(player1,player2,player3,player4);
        Players players = new Players(playerList);
        for (int i = 0; i < 4; i++) {
            assertThat(players.getPlayersName().get(i).get()).isEqualTo(String.format("test%d",i+1));
        }
    }
}
