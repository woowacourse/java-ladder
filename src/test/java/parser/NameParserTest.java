package parser;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.List;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class NameParserTest {

    @Test
    @DisplayName("참여할 사람의 수를 입력받아 라인을 만든다.")
    void parse() {
        String text = "pobi,honux,crong,jk";
        List<String> names = NameParser.parse(text);
        assertThat(names).containsExactlyInAnyOrder("pobi", "honux", "crong", "jk");
    }
}