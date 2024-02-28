package view.parser;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.List;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import view.parser.NameParser;

class NameParserTest {

    @Test
    @DisplayName("참여할 사람의 수를 입력받아 쉼표로 구분한다.")
    void parsePersonNames() {
        String text = "pobi,honux,crong,jk";
        List<String> names = NameParser.parse(text);
        assertThat(names).containsExactlyInAnyOrder("pobi", "honux", "crong", "jk");
    }

    @Test
    @DisplayName("실행 결과 목록이 쉼표로 구분한다.")
    void parseItemNames() {
        String text = "꽝,5000,꽝,3000";
        List<String> names = NameParser.parse(text);
        assertThat(names).containsExactlyInAnyOrder("꽝", "5000", "꽝", "3000");
    }
}
