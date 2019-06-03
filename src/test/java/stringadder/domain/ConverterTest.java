package stringadder.domain;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertThrows;

public class ConverterTest {
    @Test
    void 제대로_된_숫자문자열이_들어왔을_때_IntegerList로_변환() {
        List<String> input = new ArrayList<>(Arrays.asList("1", "2", "3"));
        List<Integer> expected = new ArrayList<>(Arrays.asList(1, 2, 3));

        assertThat(Converter.convert(input)).isEqualTo(expected);
    }

    @Test
    void 숫자가_아닌_값이_들어왔을_떼_예외를_던지는지_테스트() {
        List<String> input = new ArrayList<>(Arrays.asList("a", "2", "3"));

        assertThrows(RuntimeException.class, () -> Converter.convert(input));
    }

    @Test
    void 음수를_입력했을_때_예외를_던지는지_테스트() {
        List<String> input = new ArrayList<>(Arrays.asList("-1", "2", "3"));

        assertThrows(RuntimeException.class, () -> Converter.convert(input));
    }

    @Test
    void 빈_문자열을_입력했을_때_빈_리스트를_리턴하는지_테스트() {
        List<String> input = new ArrayList<>(Arrays.asList(""));
        List<Integer> empty = new ArrayList<>();

        assertThat(Converter.convert(input)).isEqualTo(empty);
    }
}
