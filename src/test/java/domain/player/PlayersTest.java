package domain.player;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatCode;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

import domain.ColumnPosition;
import java.util.List;
import java.util.NoSuchElementException;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

@DisplayName("사다리 참가자들 도메인 테스트 작성")
class PlayersTest {

    @DisplayName("중복되는 이름이 있는 경우 생성에 실패한다")
    @Test
    void testCreateWithNonUniqueNames() {
        Player player1 = new Player(new PlayerName("안돌"), new ColumnPosition(0));
        Player player2 = new Player(new PlayerName("안돌"), new ColumnPosition(1));

        assertThatThrownBy(() -> new Players(List.of(player1, player2)))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage("[ERROR] 이름이 중복되는 참가자가 있습니다");
    }

    @DisplayName("최소 참가자 수를 만족하지 못하면 생성에 실패한다")
    @Test
    void testCreateWithInsufficientCount() {
        Player player1 = new Player(new PlayerName("안돌"), new ColumnPosition(0));

        assertThatThrownBy(() -> new Players(List.of(player1)))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage("[ERROR] 참여 인원은 2명 이상이어야 합니다");
    }

    @DisplayName("조건을 만족하면 생성에 성공한다")
    @Test
    void testCreateWithValidData() {
        Player player1 = new Player(new PlayerName("안돌"), new ColumnPosition(0));
        Player player2 = new Player(new PlayerName("리비"), new ColumnPosition(1));

        assertThatCode(() -> new Players(List.of(player1, player2)))
                .doesNotThrowAnyException();
    }

    @DisplayName("이름을 받으면 해당하는 참가자의 시작 열 위치를 반환한다")
    @Test
    void testGetPlayersColumnPosition() {
        Player player1 = new Player(new PlayerName("안돌"), new ColumnPosition(0));
        Player player2 = new Player(new PlayerName("리비"), new ColumnPosition(1));
        Players players = new Players(List.of(player1, player2));

        assertThat(players.columnPositionOf(new PlayerName("안돌")).getColumnPosition()).isEqualTo(0);
    }

    @DisplayName("요청 받은 이름이 존재하지 않는 경우 예외를 발생시킨다")
    @Test
    void testGetPlayerColumnPositionByNonExistName() {
        Player player1 = new Player(new PlayerName("안돌"), new ColumnPosition(0));
        Player player2 = new Player(new PlayerName("리비"), new ColumnPosition(1));
        Players players = new Players(List.of(player1, player2));

        assertThatThrownBy(() -> players.columnPositionOf(new PlayerName("NON")))
                .isInstanceOf(NoSuchElementException.class)
                .hasMessage("[ERROR] 해당하는 이름의 참여자가 존재하지 않습니다");
    }
}
