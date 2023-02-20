package domain;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.List;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class ResultContentsTest {

    @DisplayName("모든 실행결과 생성")
    @Test
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

    @DisplayName("모든 실행결과를 연속된 문자와 구분자로 생성")
    @Test
    void createResultContentsRawValueAndDelimiterSuccess() {
        String resultContentsInput = "꽝,1000,꽝,2000";
        String delimiter = ",";
        ResultContents resultContents = ResultContents.of(resultContentsInput, delimiter);

        assertThat(resultContents.getResultContents()).extracting("content")
                .containsExactly("꽝", "1000", "꽝", "2000");
    }

}
