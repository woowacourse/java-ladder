package util;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.List;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class StringConvertorTest {

    @Test
    @DisplayName("쉼표로 구분하여 배열을 생성한다")
    void splitByCommaTest() {
        // given
        String values = "ka-ki,po-bi,neo";

        // when
        String[] splitValues = StringConvertor.splitByComma(values);

        // then
        assertThat(splitValues).containsExactly("ka-ki", "po-bi", "neo");
    }

    @Test
    @DisplayName("쉼표")
    void convertToTrimmedListTest() {
        // given
        String[] values = {" kaki ", " pobi", "solar "};

        // when
        List<String> trimmedValues = StringConvertor.convertToTrimmedList(values);

        // then
        assertThat(trimmedValues).containsExactly("kaki", "pobi", "solar");
    }

    @Test
    void convertToIntTest() {
        // given
        String value = "100";

        // when
        int convertedValue = StringConvertor.convertToInt(value);

        // then
        assertThat(convertedValue).isEqualTo(100);
    }
}
