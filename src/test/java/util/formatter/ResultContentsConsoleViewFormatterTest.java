package util.formatter;

import static org.assertj.core.api.Assertions.assertThat;

import domain.ResultContents;
import java.util.List;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import view.util.formatter.ResultContentsConsoleViewFormatter;

class ResultContentsConsoleViewFormatterTest {

    @Test
    @DisplayName("사다리 게임 결과 출력 형식 생성 테스트")
    void ladderFormatterTest() {
        List<String> resultContentsValue = List.of("꽝", "오천원", "만원");
        ResultContents resultContents = ResultContents.from(resultContentsValue);
        String expected = new StringBuilder()
                .append("  꽝  ").append(" ")
                .append(" 오천원 ").append(" ")
                .append(" 만원  ").append(" ")
                .toString();

        String formatPlayers = ResultContentsConsoleViewFormatter.formatResultContents(resultContents);
        assertThat(formatPlayers).isEqualTo(expected);
    }
}
