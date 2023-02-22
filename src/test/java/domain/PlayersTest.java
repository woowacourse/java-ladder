package domain;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

public class PlayersTest {

    @DisplayName("이름들을 담은 배열을 받아 Player 객체로 변환해야 한다.")
    @Test
    void convertPlayerObject() {
        List<String> names = List.of("be", "bebe", "bebebe");
        assertAll(() -> {
            assertEquals(new Players(names).getPlayers().get(0).getName(), "be");
            assertEquals(new Players(names).getPlayers().get(1).getName(), "bebe");
            assertEquals(new Players(names).getPlayers().get(2).getName(), "bebebe");
        });
    }

}
