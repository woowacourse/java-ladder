package ladder.utils;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThatThrownBy;

public class ValidatorUtilsTest {

    @Test
    void 입력된_이름이_올바르지_않을_때() {
        List<String> input1 = new ArrayList<>(Arrays.asList("aaaaaa,bb".trim().split(",")));
        List<String> input2 = new ArrayList<>(Arrays.asList(" ,a".trim().split(",")));
        List<String> input3 = new ArrayList<>(Arrays.asList("pobi,      ,done".trim().split(",")));
        List<String> input4 = new ArrayList<>(Arrays.asList("  ".trim().split(",")));
        List<String> input5 = new ArrayList<>(Arrays.asList(",,,,,,,,".trim().split(",")));

        assertThatThrownBy(() -> {
            ValidatorUtils.checkNames(input1);
        }).isInstanceOf(IllegalArgumentException.class);
        assertThatThrownBy(() -> {
            ValidatorUtils.checkNames(input2);
        }).isInstanceOf(IllegalArgumentException.class);
        assertThatThrownBy(() -> {
            ValidatorUtils.checkNames(input3);
        }).isInstanceOf(IllegalArgumentException.class);
        assertThatThrownBy(() -> {
            ValidatorUtils.checkNames(input4);
        }).isInstanceOf(IllegalArgumentException.class);
        assertThatThrownBy(() -> {
            ValidatorUtils.checkNames(input5);
        }).isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    void 입력된_아이템에_빈칸이_있을_때() {
        List<String> input1 = new ArrayList<>(Arrays.asList(" ,   ".trim().split(",")));
        List<String> input2 = new ArrayList<>(Arrays.asList("     ".trim().split(",")));
        List<String> input3 = new ArrayList<>(Arrays.asList("꽝,  ,5000".trim().split(",")));

        assertThatThrownBy(() -> {
            ValidatorUtils.checkItems(input1, 2);
        }).isInstanceOf(IllegalArgumentException.class);
        assertThatThrownBy(() -> {
            ValidatorUtils.checkItems(input2, 1);
        }).isInstanceOf(IllegalArgumentException.class);
        assertThatThrownBy(() -> {
            ValidatorUtils.checkItems(input3, 3);
        }).isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    void 입력된_아이템의_수와_사람_수가_다를_때() {
        List<String> input = new ArrayList<>(Arrays.asList("5000,꽝".trim().split(",")));

        assertThatThrownBy(() -> {
            ValidatorUtils.checkItems(input, 3);
        }).isInstanceOf(IllegalArgumentException.class);
    }
}
