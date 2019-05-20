package ladder.view;

import org.junit.jupiter.api.Test;

import java.util.Arrays;

import static org.junit.jupiter.api.Assertions.assertThrows;

public class InputViewTest {
    @Test
    void 쉼표가두개이상있는경우테스트() {
        assertThrows(IllegalArgumentException.class, () -> InputView.validateNoConsecutiveCommas("pobi,,"));
    }

    @Test
    void 중복된이름이있는경우테스트() {
        assertThrows(IllegalArgumentException.class, () -> InputView.validateNoDuplication(Arrays.asList("pobi", "pobi", "crong")));
    }

    @Test
    void 사다리_높이가_자연수가_아닌_경우_테스트() {
        assertThrows(IllegalArgumentException.class, () -> InputView.validateNaturalNumber(0));
    }
}
