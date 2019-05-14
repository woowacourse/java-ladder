package stringadder.domain;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

public class StringSpliterTest {
    StringSpliter testStringSpliter;

    @BeforeEach
    void setUp() {
        testStringSpliter = new StringSpliter();
    }

    @Test
    void 구분자를_기준으로_숫자_문자열을_문자열_리스트로_반환하는지_테스트() {
        String numbersWithSeparator = "1,2,3";
        List<String> expected = new ArrayList<>(Arrays.asList("1", "2", "3"));

        assertThat(testStringSpliter.splitBySeparators(numbersWithSeparator)).isEqualTo(expected);
    }

    @Test
    void 구분자들을_기준으로_숫자_문자열을_문자열_리스트로_반환하는지_테스트() {
        String numbersWithSeparator = "1,2,3:4";
        List<String> expected = new ArrayList<>(Arrays.asList("1", "2", "3", "4"));

        assertThat(testStringSpliter.splitBySeparators(numbersWithSeparator)).isEqualTo(expected);
    }

    @Test
    void 커스텀_구분자를_추가저장_하는기능_테스트() {
        String input = "//;\n1;2;3";

        testStringSpliter.setAdditionalSeparatorsFrom(input);

        assertThat(testStringSpliter).isEqualTo(new StringSpliter(Arrays.asList(";")));
    }

    @Test
    void 커스텀_구분자를_추가저장_하는기능_테스트2() {
        String input = "//.\n1;2;3";

        testStringSpliter.setAdditionalSeparatorsFrom(input);

        assertThat(testStringSpliter).isEqualTo(new StringSpliter(Arrays.asList(".")));
    }

    @Test
    void 커스텀_구분자가_없을떄_문자열을_제대로_반환하는지_테스트() {
        String input = "1,2,3";

        String numberString = testStringSpliter.setAdditionalSeparatorsFrom(input);

        assertThat(numberString).isEqualTo(input);
    }


    @Test
    void 커스텀_구분자를_제외한_문자열을_반환하는지_테스트() {
        String input = "//;\n1;2;3";
        String expected = "1;2;3";

        String numberString = testStringSpliter.setAdditionalSeparatorsFrom(input);

        assertThat(numberString).isEqualTo(expected);
    }

    @Test
    void 커스텀_구분자만_입력했을_때_비어있는_String이_나오는지_테스트() {
        String input = "//;\n";
        String expected = "";

        String numberString = testStringSpliter.setAdditionalSeparatorsFrom(input);

        assertThat(numberString).isEqualTo(expected);
    }

    @Test
    void 커스텀_구분자를_기준으로_정상적으로_분리되는지_확인() {
        String numbersWithSeparator = "1&2&3";
        List<String> expected = new ArrayList<>(Arrays.asList("1", "2", "3"));
        testStringSpliter = new StringSpliter(Arrays.asList("&"));

        assertThat(testStringSpliter.splitBySeparators(numbersWithSeparator)).isEqualTo(expected);
    }
}
