
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;


public class GameBoardTest {
    @Test
    @DisplayName("Player 와 사다리를 통해 게임 보드를 만든다.")
    public void createGameBoard(){
        List<Player> players = 이름_생성(List.of("도비","조이썬","포비","크롱")).stream().map(Player::new).toList();
        Height height = new Height("5");
        Ladder ladder = new Ladder(height,players.size(),new RandomDirectionGenerator());

        GameBoard gameBoard = new GameBoard(players,ladder);

        assertInstanceOf(GameBoard.class,gameBoard);

    }
    private List<Name> 이름_생성(List<String> names) {
        return names.stream().map(Name::new).toList();
    }
}
