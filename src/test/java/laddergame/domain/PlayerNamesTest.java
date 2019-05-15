package laddergame.domain;

import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

public class PlayerNamesTest {
    @Test
    void 이름입력값이_배열로_전달되는지_테스트() {
        String input = "a,b,c";
        List<String> checker = Arrays.asList("a", "b", "c");
        assertThat(new PlayerNames().makeNames(input)).isEqualTo(checker);
    }
}
