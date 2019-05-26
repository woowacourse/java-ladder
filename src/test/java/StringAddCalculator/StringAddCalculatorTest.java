package StringAddCalculator;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertThrows;

class StringAddCalculatorTest {
    @Test
    void 구분자_구분() {
        String input = "1,2,3";
        String[] splitter = {","};
        List<Integer> output = StringAddCalculator.splitString(input, Arrays.asList(splitter));
        List<Integer> result = Arrays.asList(1, 2, 3);
        assertThat(output).isEqualTo(result);

        input = "1:2:3";
        splitter[0] = ":";
        output = StringAddCalculator.splitString(input, Arrays.asList(splitter));
        result = Arrays.asList(1, 2, 3);
        assertThat(output).isEqualTo(result);
    }

    @Test
    void 콜론_콤마_섞여있을때() {
        String input = "1,2:3";
        String[] splitter = {",", ":"};
        List<Integer> output = StringAddCalculator.splitString(input, Arrays.asList(splitter));
        List<Integer> result = Arrays.asList(1, 2, 3);
        assertThat(output).isEqualTo(result);
    }

    @Test
    void 덧셈() {
        List<Integer> input = Arrays.asList(1, 2, 3);
        assertThat(Adder.add(input)).isEqualTo(6);
    }

    @Test
    void 빈칸이_포함된_경우() {
        String input = "1, 2:3";
        String[] splitter = {",", ":"};
        assertThrows(NumberFormatException.class, () -> {
            List<Integer> output = StringAddCalculator.splitString(input, Arrays.asList(splitter));
        });
    }

    @Test
    void 입력이_없는_경우_또는_널입력() {
        String input = "";
        String[] splitter = {",", ":"};
        assertThat(Adder.add(StringAddCalculator.splitString(input, Arrays.asList(splitter)))).isEqualTo(0);
        assertThat(Adder.add(StringAddCalculator.splitString(null, Arrays.asList(splitter)))).isEqualTo(0);
    }

    @Test
    void 연속_구분자() {
        String input = "1,,2:3";
        String[] splitter = {",", ":"};
        assertThrows(NumberFormatException.class, () -> {
            List<Integer> output = StringAddCalculator.splitString(input, Arrays.asList(splitter));
        });
    }

    @Test
    void 구분자로_끝날때() {
        String input = "1,2:3,";
        String[] splitter = {",", ":"};
        assertThrows(IllegalArgumentException.class, () -> {
            List<Integer> output = StringAddCalculator.splitString(input, Arrays.asList(splitter));
        });
    }

    @Test
    void 구분자로_시작할때() {
        String input = ",1,2:3";
        String[] splitter = {",", ":"};
        assertThrows(IllegalArgumentException.class, () -> {
            List<Integer> output = StringAddCalculator.splitString(input, Arrays.asList(splitter));
        });
    }

    @Test
    void 구분자설정() {
        String input = "//;\n1;2;3";
        assertThat(StringAddCalculator.splitString(input, new ArrayList<String>())).isEqualTo(Arrays.asList(1, 2, 3));
    }

    @Test
    void 숫자_하나_계산() {
        String input = "1";
        String[] splitter = {",", ":"};
        assertThat(Adder.add(StringAddCalculator.splitString(input, Arrays.asList(splitter)))).isEqualTo(1);
    }

    @Test
    void 음수입력() {
        String input = "-1,-2";
        String[] splitter = {",", ":"};
        assertThrows(RuntimeException.class, () -> {
            Adder.add(StringAddCalculator.splitString(input, Arrays.asList(splitter)));
        });
    }
}
