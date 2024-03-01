package view;

import static domain.ConnectionStatus.CONNECTED;
import static domain.ConnectionStatus.DISCONNECTED;
import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

import domain.ColumnPosition;
import domain.Ladder;
import domain.LadderResult;
import domain.LadderResults;
import domain.Player;
import domain.PlayerName;
import domain.Players;
import domain.Prize;
import domain.PrizeName;
import domain.Prizes;
import domain.RowLine;
import java.util.List;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

@DisplayName("출력 메시지 리졸버 테스트")
class MessageResolverTest {

    private MessageResolver messageResolver;

    @BeforeEach
    void setUp() {
        messageResolver = new MessageResolver();
    }

    @DisplayName("사다리 정보 메시지 테스트")
    @Test
    void testResolveLadderMessage() {
        RowLine line1 = new RowLine(List.of(CONNECTED, DISCONNECTED));
        RowLine line2 = new RowLine(List.of(DISCONNECTED, DISCONNECTED));
        List<RowLine> rowLines = List.of(line1, line2);

        Ladder ladder = new Ladder(rowLines);
        Players players = new Players(List.of(
                new Player(new PlayerName("리비"), new ColumnPosition(0)),
                new Player(new PlayerName("테니"), new ColumnPosition(1)),
                new Player(new PlayerName("잉크"), new ColumnPosition(2))
        ));

        Prizes prizes = new Prizes(List.of(
                new Prize(new PrizeName("1"), new ColumnPosition(0)),
                new Prize(new PrizeName("2"), new ColumnPosition(1)),
                new Prize(new PrizeName("3"), new ColumnPosition(2))));

        String result = messageResolver.resolveLadderMessage(ladder, players, prizes);

        assertThat(result).isEqualTo(
                System.lineSeparator()
                        + "사다리결과" + System.lineSeparator() + System.lineSeparator()
                        + "리비    테니    잉크   " + System.lineSeparator()
                        + "    |-----|     |" + System.lineSeparator()
                        + "    |     |     |" + System.lineSeparator()
                        + "1     2     3    ");
    }

    @DisplayName("단일 결과 메시지 테스트")
    @Test
    void testResultMessage() {
        LadderResult ladderResult = new LadderResult("1등", "리비");
        assertThat(messageResolver.resolveResultMessage(ladderResult)).isEqualTo(
                System.lineSeparator() + "실행 결과" + System.lineSeparator() + "1등");
    }

    @DisplayName("총 결과 메시지 테스트")
    @Test
    void testResultsMessage() {
        LadderResult ladderResult1 = new LadderResult("1등", "리비");
        LadderResult ladderResult2 = new LadderResult("2등", "잉크");
        LadderResult ladderResult3 = new LadderResult("3등", "테니");
        LadderResult ladderResult4 = new LadderResult("4등", "에버");
        LadderResult ladderResult5 = new LadderResult("5등", "제리");

        LadderResults ladderResults = new LadderResults(
                List.of(ladderResult1, ladderResult2, ladderResult3, ladderResult4, ladderResult5));

        assertThat(messageResolver.resolveResultsMessage(ladderResults)).isEqualTo(
                System.lineSeparator() + "실행 결과" + System.lineSeparator()
                        + "리비 : 1등" + System.lineSeparator()
                        + "잉크 : 2등" + System.lineSeparator()
                        + "테니 : 3등" + System.lineSeparator()
                        + "에버 : 4등" + System.lineSeparator()
                        + "제리 : 5등");
    }
}
