package ladder.utils;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThatThrownBy;

public class ValidatorUtilsTest {
    @Test
    public void 입력된_이름의_길이가_5가_넘을_때() {
        List<String> input = new ArrayList<>(Arrays.asList("aaaaaa,bb".trim().split(",")));

        assertThatThrownBy(() -> ValidatorUtils.checkNames(input)).isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    public void 입력된_이름에_공백이_있을_때() {
        List<String> input = new ArrayList<>(Arrays.asList(" ,a".trim().split(",")));
        List<String> input2 = new ArrayList<>(Arrays.asList("  ".trim().split(",")));

        assertThatThrownBy(() -> ValidatorUtils.checkNames(input)).isInstanceOf(IllegalArgumentException.class);

        assertThatThrownBy(() -> ValidatorUtils.checkNames(input2)).isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    public void 입력된_이름이_없고_쉼표만_있을_때() {
        List<String> input = new ArrayList<>(Arrays.asList(",,,,,,,,".trim().split(",")));

        assertThatThrownBy(() -> ValidatorUtils.checkNames(input)).isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    public void 입력된_아이템에_빈칸이_있을_때() {
        List<String> input1 = Arrays.asList(" ,   ".trim().split(","));
        List<String> input2 = Arrays.asList("     ".trim().split(","));
        List<String> input3 = Arrays.asList("꽝,  ,5000".trim().split(","));

        assertThatThrownBy(() -> ValidatorUtils.checkItems(input1, 2)).isInstanceOf(IllegalArgumentException.class);
        assertThatThrownBy(() -> ValidatorUtils.checkItems(input2, 1)).isInstanceOf(IllegalArgumentException.class);
        assertThatThrownBy(() -> ValidatorUtils.checkItems(input3, 3)).isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    public void 입력된_아이템의_수와_사람_수가_다를_때() {
        List<String> input = new ArrayList<>(Arrays.asList("5000,꽝".trim().split(",")));

        assertThatThrownBy(() -> {
            ValidatorUtils.checkItems(input, 3);
        }).isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    public void 입력된_참가자가_없을_때() {
        List<String> names = Arrays.asList("pobi", "done");

        assertThatThrownBy(() -> ValidatorUtils.checkParticipant(names, "brown")).isInstanceOf(IllegalArgumentException.class);
    }
}
