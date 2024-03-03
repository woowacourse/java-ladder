package domain;

import domain.line.CustomLinesGenerator;
import domain.name.Names;
import domain.prize.Prizes;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;

import static domain.ConnectionStatus.CONNECTED;
import static domain.ConnectionStatus.DISCONNECTED;
import static org.junit.jupiter.api.Assertions.assertEquals;

class LadderIndexConnectionTest {

    @DisplayName("시작점에 맞는 끝점을 반환한다.")
    @Test
    void getPrizeIndexTest() {
        Ladder ladder = Ladder.createFrom(new CustomLinesGenerator(List.of(
                        List.of(CONNECTED, DISCONNECTED, CONNECTED),
                        List.of(DISCONNECTED, CONNECTED, DISCONNECTED),
                        List.of(CONNECTED, DISCONNECTED, CONNECTED))),
                Names.from(List.of("a", "b", "c", "d")),
                new Height(5),
                Prizes.from(List.of("1", "2", "3", "4")));

        LadderIndexConnection ladderIndexConnection = LadderIndexConnection.of(ladder);

        Assertions.assertAll(
                () -> assertEquals(ladderIndexConnection.getPrizeIndex(0), 3),
                () -> assertEquals(ladderIndexConnection.getPrizeIndex(1), 1),
                () -> assertEquals(ladderIndexConnection.getPrizeIndex(2), 2),
                () -> assertEquals(ladderIndexConnection.getPrizeIndex(3), 0)
        );
    }
}
