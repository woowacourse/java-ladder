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

    @DisplayName("열 번호로 결과를 얻어올 수 있다")
    @Test
    void testGetResultByIndex() {
        RowLine line1 = new RowLine(List.of(CONNECTED));
        RowLine line2 = new RowLine(List.of(CONNECTED));

        Names names = new Names(List.of(new Name("리비"), new Name("잉크")));
        Ladder ladder = new Ladder(List.of(line1, line2));
        LadderResults ladderResults = new LadderResults(List.of(new LadderResult("123"), new LadderResult("456")));

        LadderGame ladderGame = new LadderGame(ladder, names, ladderResults);
        assertThat(ladderGame.drive(1).getResult()).isEqualTo("456");
    }

    @DisplayName("열 개수와 실행 결과 개수가 일치하지 않으면 생성에 실패한다")
    @Test
    void testCreationWithInvalidResultCount() {
        RowLine line1 = new RowLine(List.of(CONNECTED, DISCONNECTED, CONNECTED));
        RowLine line2 = new RowLine(List.of(CONNECTED, DISCONNECTED, CONNECTED));

        Names names = new Names(List.of(new Name("리비"), new Name("잉크")));
        Ladder ladder = new Ladder(List.of(line1, line2));
        LadderResults ladderResults = new LadderResults(
                List.of(new LadderResult("123"), new LadderResult("456"), new LadderResult("789")));

        assertThatThrownBy(() -> new LadderGame(ladder, names, ladderResults))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage("[ERROR] 사다리 열과 결과의 개수가 일치하지 않습니다");
    }

    @DisplayName("검증을 모두 통과하면 생성에 성공한다")
    void testCreateWithValidData() {
        RowLine line1 = new RowLine(List.of(CONNECTED, DISCONNECTED, CONNECTED));
        RowLine line2 = new RowLine(List.of(CONNECTED, DISCONNECTED, CONNECTED));

        Names names = new Names(List.of(new Name("리비"), new Name("잉크")));
        Ladder ladder = new Ladder(List.of(line1, line2));
        LadderResults ladderResults = new LadderResults(
                List.of(new LadderResult("123"), new LadderResult("456")));

        assertThatCode(() -> new LadderGame(ladder, names, ladderResults))
                .doesNotThrowAnyException();

    }
}
