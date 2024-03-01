package domain;

import static domain.ConnectionStatus.CONNECTED;
import static domain.ConnectionStatus.DISCONNECTED;
import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatCode;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

import java.util.List;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

@DisplayName("사다리 게임 테스트")
class LadderGameTest {

    @DisplayName("이름으로 결과를 얻어올 수 있다")
    @Test
    void testGetResultByIndex() {
        RowLine line1 = new RowLine(List.of(CONNECTED));
        RowLine line2 = new RowLine(List.of(CONNECTED));

        Players players = new Players(List.of(
                new Player(new PlayerName("리비"), new ColumnPosition(0)),
                new Player(new PlayerName("잉크"), new ColumnPosition(1))
        ));
        Ladder ladder = new Ladder(List.of(line1, line2));
        Prizes prizes = new Prizes(
                List.of(new Prize(new PrizeName("123"), new ColumnPosition(0)),
                        new Prize(new PrizeName("456"), new ColumnPosition(1))));

        LadderGame ladderGame = new LadderGame(ladder, players, prizes);
        assertThat(ladderGame.drive(new PlayerName("잉크")).getResult()).isEqualTo("456");
    }

    @DisplayName("전체 결과를 얻어올 수 있다")
    @Test
    void testGetAllResult() {
        RowLine line1 = new RowLine(List.of(CONNECTED));
        RowLine line2 = new RowLine(List.of(CONNECTED));

        Players players = new Players(List.of(
                new Player(new PlayerName("리비"), new ColumnPosition(0)),
                new Player(new PlayerName("잉크"), new ColumnPosition(1))
        ));

        Ladder ladder = new Ladder(List.of(line1, line2));
        Prizes prizes = new Prizes(
                List.of(new Prize(new PrizeName("123"), new ColumnPosition(0)),
                        new Prize(new PrizeName("456"), new ColumnPosition(1))));

        LadderGame ladderGame = new LadderGame(ladder, players, prizes);
        assertThat(ladderGame.driveAll().getResults())
                .extracting("result")
                .containsExactly("123", "456");
    }

    @DisplayName("열 개수와 실행 결과 개수가 일치하지 않으면 생성에 실패한다")
    @Test
    void testCreationWithInvalidResultCount() {
        RowLine line1 = new RowLine(List.of(CONNECTED, DISCONNECTED, CONNECTED));
        RowLine line2 = new RowLine(List.of(CONNECTED, DISCONNECTED, CONNECTED));

        Players players = new Players(List.of(
                new Player(new PlayerName("리비"), new ColumnPosition(0)),
                new Player(new PlayerName("잉크"), new ColumnPosition(1))
        ));
        Ladder ladder = new Ladder(List.of(line1, line2));
        Prizes prizes = new Prizes(
                List.of(new Prize(new PrizeName("123"), new ColumnPosition(0)),
                        new Prize(new PrizeName("456"), new ColumnPosition(1))));

        assertThatThrownBy(() -> new LadderGame(ladder, players, prizes))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage("[ERROR] 사다리 열과 결과의 개수가 일치하지 않습니다");
    }

    @DisplayName("검증을 모두 통과하면 생성에 성공한다")
    void testCreateWithValidData() {
        RowLine line1 = new RowLine(List.of(CONNECTED, DISCONNECTED, CONNECTED));
        RowLine line2 = new RowLine(List.of(CONNECTED, DISCONNECTED, CONNECTED));

        Players players = new Players(List.of(
                new Player(new PlayerName("리비"), new ColumnPosition(0)),
                new Player(new PlayerName("잉크"), new ColumnPosition(1))
        ));
        Ladder ladder = new Ladder(List.of(line1, line2));
        Prizes prizes = new Prizes(
                List.of(new Prize(new PrizeName("123"), new ColumnPosition(0)),
                        new Prize(new PrizeName("456"), new ColumnPosition(1))));

        assertThatCode(() -> new LadderGame(ladder, players, prizes))
                .doesNotThrowAnyException();

    }
}
