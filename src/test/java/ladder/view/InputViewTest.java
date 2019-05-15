package ladder.view;

import ladder.model.Player;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertThrows;

public class InputViewTest {
    @Test
    void 구분자를_포함한_이름들을_입력받아서_Player_객체들을_반환하는_메소드_테스트() {
        String[] names = {"red", "blue", "green"};
        List<Player> players = InputView.makePlayers(names);
        assertThat(players.get(0).getName()).isEqualTo("red");
        assertThat(players.get(1).getName()).isEqualTo("blue");
        assertThat(players.get(2).getName()).isEqualTo("green");
    }

    @Test
    void 이름이_1개_밖에_없는_경우() {
        String[] names = {"red"};
        assertThrows(IllegalArgumentException.class, () ->{
            InputView.makePlayers(names);
        });
    }

    @Test
    void 이름이_중복된_경우() {
        String[] names = {"red","red","blue","green"};
        assertThrows(IllegalArgumentException.class, () ->{
            InputView.makePlayers(names);
        });
    }
}
