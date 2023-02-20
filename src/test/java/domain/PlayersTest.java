package domain;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;

/**
 * @author 베베
 * @version 1.0.0
 * @Created by 베베 on 2023. 02. 20.
 */
public class PlayersTest {

    @DisplayName("이름들을 담은 배열을 받아 Player 객체로 변환해야 한다.")
    @Test
    void convertPlayerObject() {
        List<String> names = List.of("be", "bebe", "bebebe");
        for (String name : names) {
            Player player = new Player(name);
            Assertions.assertEquals(player.getClass(), Player.class);
        }
    }
}
