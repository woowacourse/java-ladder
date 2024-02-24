package view;

import static domain.ConnectionStatus.CONNECTED;
import static domain.ConnectionStatus.DISCONNECTED;
import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

import domain.Ladder;
import domain.Name;
import domain.Names;
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

    @DisplayName("이름을 형식에 맞게 출력할 수 있다")
    @Test
    void testResolveNamesMessage() {
        Names names = new Names(List.of(new Name("잉크"), new Name("리비")));

        String result = messageResolver.resolveNamesMessage(names);

        assertThat(result).isEqualTo("잉크    리비   ");
    }

    @Test
    void testResolveLadderMessage() {
        RowLine line1 = new RowLine(List.of(CONNECTED, DISCONNECTED, DISCONNECTED));
        RowLine line2 = new RowLine(List.of(CONNECTED, DISCONNECTED, CONNECTED));
        List<RowLine> rowLines = List.of(line1, line2);
        Ladder ladder = new Ladder(rowLines);

        String result = messageResolver.resolveLadderMessage(ladder);

        assertThat(result).isEqualTo(
                "    |-----|     |     |" + System.lineSeparator()
                        + "    |-----|     |-----|");
    }
}
