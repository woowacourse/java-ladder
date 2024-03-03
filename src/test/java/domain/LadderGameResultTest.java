package domain;

import domain.line.CustomLinesGenerator;
import domain.name.Name;
import domain.name.Names;
import domain.prize.Prizes;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import java.util.List;

import static domain.ConnectionStatus.CONNECTED;
import static domain.ConnectionStatus.DISCONNECTED;
import static org.assertj.core.api.Assertions.assertThat;

class LadderGameResultTest {

    private Names names;
    private Prizes prizes;
    private Ladder ladder;
    private LadderIndexConnection ladderIndexConnection;
    private LadderGameResult ladderGameResult;

    @BeforeEach
    void setUp() {
        names = Names.from(List.of("a", "b", "c", "d"));
        prizes = Prizes.from(List.of("1", "2", "3", "4"));
        ladder = Ladder.createFrom(new CustomLinesGenerator(List.of(
                        List.of(CONNECTED, DISCONNECTED, CONNECTED),
                        List.of(DISCONNECTED, CONNECTED, DISCONNECTED),
                        List.of(CONNECTED, DISCONNECTED, CONNECTED))),
                names, new Height(5), prizes);

        ladderIndexConnection = LadderIndexConnection.of(ladder);
        ladderGameResult = new LadderGameResult(names, prizes, ladderIndexConnection);
    }

    @DisplayName("이름과 매칭되는 상품 이름을 반환한다.")
    @ParameterizedTest
    @CsvSource(value = {"a,4", "b,2", "c,3", "d,1"})
    void getOneResult(String name, String prize) {
        assertThat(ladderGameResult.getOneResult(new Name(name)).getPrizeName()).isEqualTo(prize);
    }
}
