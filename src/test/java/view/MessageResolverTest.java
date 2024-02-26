package view;

import static domain.ConnectionStatus.CONNECTED;
import static domain.ConnectionStatus.DISCONNECTED;
import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

import domain.Ladder;
import domain.Name;
import domain.Names;
import domain.Prize;
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

    @Test
    void testResolveLadderMessage() {
        RowLine line1 = new RowLine(List.of(CONNECTED, DISCONNECTED));
        RowLine line2 = new RowLine(List.of(DISCONNECTED, DISCONNECTED));
        List<RowLine> rowLines = List.of(line1, line2);

        Ladder ladder = new Ladder(rowLines);
        Names names = new Names(List.of(new Name("리비"), new Name("테니"), new Name("잉크")));
        Prizes prizes = new Prizes(List.of(new Prize("1"), new Prize("2"), new Prize("3")));

        String result = messageResolver.resolveLadderMessage(ladder, names, prizes);

        assertThat(result).isEqualTo(
                System.lineSeparator()
                        + "사다리결과" + System.lineSeparator() + System.lineSeparator()
                        + "리비    테니    잉크   " + System.lineSeparator()
                        + "    |-----|     |" + System.lineSeparator()
                        + "    |     |     |" + System.lineSeparator()
                        + "1     2     3    ");
    }
}
