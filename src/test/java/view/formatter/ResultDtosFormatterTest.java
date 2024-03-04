package view.formatter;

import static org.assertj.core.api.Assertions.assertThat;

import dto.ResultDto;
import java.util.List;
import org.junit.jupiter.api.Test;

class ResultDtosFormatterTest {
    @Test
    void format() {
        List<ResultDto> resultDtos = List.of(
                new ResultDto("pobi", "꽝"),
                new ResultDto("honux", "3000"),
                new ResultDto("crong", "꽝"),
                new ResultDto("jk", "5000")
        );

        ResultDtosFormatter resultDtosFormatter = new ResultDtosFormatter();
        assertThat(resultDtosFormatter.format(resultDtos)).isEqualTo(
                "pobi : 꽝\n"
                        + "honux : 3000\n"
                        + "crong : 꽝\n"
                        + "jk : 5000\n"
        );
    }
}
