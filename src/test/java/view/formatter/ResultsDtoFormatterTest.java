package view.formatter;

import static org.assertj.core.api.Assertions.assertThat;

import dto.ResultDto;
import dto.ResultsDto;
import java.util.List;
import org.junit.jupiter.api.Test;

class ResultsDtoFormatterTest {
    @Test
    void format() {
        ResultsDto resultsDto = new ResultsDto(
                List.of(new ResultDto("pobi", "꽝"),
                        new ResultDto("honux", "3000"),
                        new ResultDto("crong", "꽝"),
                        new ResultDto("jk", "5000"))
        );

        ResultsDtoFormatter resultsDtoFormatter = new ResultsDtoFormatter();
        assertThat(resultsDtoFormatter.format(resultsDto)).isEqualTo(
                "pobi : 꽝\n"
                        + "honux : 3000\n"
                        + "crong : 꽝\n"
                        + "jk : 5000\n");
    }
}
