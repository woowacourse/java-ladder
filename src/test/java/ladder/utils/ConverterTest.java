package ladder.utils;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

class ConverterTest {
    @Test
    @DisplayName("입력 값을 리스트로 변경한다.")
    void testConvertStringToList() {
        String input = "pobi,honux,crong,jk";
        List<String> actual = Converter.stringToList(input);

        assertThat(actual).containsExactly("pobi", "honux", "crong", "jk");
    }

}
