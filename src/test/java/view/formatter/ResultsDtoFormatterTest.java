package view.formatter;

import static org.assertj.core.api.Assertions.assertThat;

import dto.ResultDto;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import org.junit.jupiter.api.Test;

class ResultsDtoFormatterTest {
    @Test
    void format() {
        List<ResultDto> resultDtos = List.of(
                new ResultDto("pobi", "꽝"),
                new ResultDto("honux", "3000"),
                new ResultDto("crong", "꽝"),
                new ResultDto("jk", "5000")
        );

        ResultFormatter resultFormatter = new ResultFormatter();
        assertThat(resultFormatter.format(resultDtos)).isEqualTo(
                "pobi : 꽝\n"
                        + "honux : 3000\n"
                        + "crong : 꽝\n"
                        + "jk : 5000\n"
        );
    }
}
