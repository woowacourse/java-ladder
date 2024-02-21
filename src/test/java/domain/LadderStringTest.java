package domain;

import java.util.List;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class LadderStringTest {
    @Test
    @DisplayName("사다리 문자열 생성")
    void test() {
        Height height = new Height(5);
        Width width = new Width(2);
        Ladder ladder = new Ladder(height, width, width1 -> List.of(true));
        String actual = LadderString.from(ladder);
        String expected = """
                |-----|
                |-----|
                |-----|
                |-----|
                |-----|""";
        Assertions.assertThat(actual)
                .isEqualTo(expected);
    }

}