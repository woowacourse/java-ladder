package utils;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

import static org.assertj.core.api.Assertions.assertThat;

public class ParserTest {

    @Test
    @DisplayName("입력받은 문자열을 , 로 구분하여 리스트로 반환한다")
    void splitNameByDelimiter_Success() {
        String inputName = "pobi,jason,gray,encho";
        String delimiter = ",";

        List<String> names = Parser.parse(inputName, delimiter);

        assertThat(names).containsExactly("pobi", "jason", "gray", "encho");
    }
}
