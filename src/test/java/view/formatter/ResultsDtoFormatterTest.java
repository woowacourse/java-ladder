package view.formatter;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.LinkedHashMap;
import java.util.Map;
import org.junit.jupiter.api.Test;

class ResultDtoFormatterTest {
    @Test
    void format() {
        Map<String, String> result = new LinkedHashMap<>();
        result.put("pobi", "꽝");
        result.put("honux", "3000");
        result.put("crong", "꽝");
        result.put("jk", "5000");

        ResultFormatter resultFormatter = new ResultFormatter();
        assertThat(resultFormatter.format(result)).isEqualTo(
                "pobi : 꽝\n"
                        + "honux : 3000\n"
                        + "crong : 꽝\n"
                        + "jk : 5000\n"
        );
    }
}
