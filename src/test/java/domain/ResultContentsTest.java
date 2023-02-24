package domain;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.List;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class ResultContentsTest {

    @Test
    @DisplayName("모든 실행결과 생성")
    void createResultContentsSuccess() {
        List<ResultContent> resultContentsInput = List.of(
                new ResultContent("꽝"),
                new ResultContent("1000"),
                new ResultContent("꽝"),
                new ResultContent("2000")
        );
        ResultContents resultContents = new ResultContents(resultContentsInput);

        assertThat(resultContents.getResultContents()).extracting("content")
                .containsExactly("꽝", "1000", "꽝", "2000");
    }

    @Test
    @DisplayName("모든 실행결과를 연속된 문자와 구분자로 생성")
    void createResultContentsRawValueAndDelimiterSuccess() {
        List<String> resultContentsValue = List.of("꽝", "1000", "꽝", "2000");
        ResultContents resultContents = ResultContents.from(resultContentsValue);

        assertThat(resultContents.getResultContents()).extracting("content")
                .containsExactly("꽝", "1000", "꽝", "2000");
    }

}
