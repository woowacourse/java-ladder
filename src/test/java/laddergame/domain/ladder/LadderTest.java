package laddergame.domain.ladder;

import laddergame.domain.player.Player;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import java.util.List;

import static laddergame.domain.ladder.Connection.CONNECTED;
import static laddergame.domain.ladder.Connection.UNCONNECTED;
import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.AssertionsForClassTypes.assertThatThrownBy;
import static org.junit.jupiter.api.Assertions.assertAll;

public class LadderTest {

    private static ConnectionStrategy randomPicker;

    private Player ethan;
    private Player coil;
    private Player junPark;
    private List<Player> players;
    private List<Connection> connections;
    private Ladder testLadder;

    @BeforeAll
    static void init() {
        randomPicker = new RandomLineMaker();
    }

    @BeforeEach
    void setUp() {
        ethan = Player.of("에단", 0);
        coil = Player.of("코일", 1);
        junPark = Player.of("준팍", 2);
        players = List.of(ethan, coil, junPark);

        connections = List.of(CONNECTED, UNCONNECTED);
        testLadder = new Ladder(1, players.size(), new TestConnectionMaker(connections));
    }

    @Test
    @DisplayName("높이가 1미만이면 예외가 발생한다.")
    void givenUnderOneHeight_thenFail() {
        //then
        assertThatThrownBy(() -> new Ladder(0, 3, randomPicker))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage("최소 높이가 1이상이어야 합니다.");
    }

    @ParameterizedTest
    @ValueSource(ints = {1, 5, 100})
    @DisplayName("높이가 1이상이면 List<Line>이 생성된다.")
    void givenOverOneHeight_thenSuccess(int height) {
        //given
        final Ladder ladder = new Ladder(height, 3, randomPicker);

        //then
        assertThat(ladder.getLines()).hasSize(height);
    }

    @Test
    void givenHeightAndPlayer_thenReturnWhetherMovable() {
        // when & then
        assertAll(
                () -> assertThat(testLadder.canMoveLeft(0, coil)).isTrue(),
                () -> assertThat(testLadder.canMoveLeft(0, ethan)).isFalse(),
                () -> assertThat(testLadder.canMoveRight(0, coil)).isFalse(),
                () -> assertThat(testLadder.canMoveRight(0, ethan)).isTrue()
        );
    }
}
