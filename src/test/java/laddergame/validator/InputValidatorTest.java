package laddergame.validator;

import laddergame.validator.InputValidator;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Arrays;

import static org.junit.jupiter.api.Assertions.*;

class InputValidatorTest {

    @Test
    void 콤마로_끝나면_예외를_던지는지_테스트() {
        assertThrows(IllegalArgumentException.class, () -> {
            InputValidator.checkEndsWithComma("a,,,,");
        });
    }

    @Test
    void 빈_리스트를_입력할때_예외를_던지는지_테스트() {
        assertThrows(IllegalArgumentException.class, () -> {
            InputValidator.checkMemberNames(new ArrayList<>());
        });
        assertThrows(IllegalArgumentException.class, () -> {
            InputValidator.checkPrizesName(new ArrayList<>(), 1);
        });
    }

    @Test
    void Members는_이름이_중복될때_예외를_던지는지_테스트() {
        assertThrows(IllegalArgumentException.class, () ->
                InputValidator.checkMemberNames(Arrays.asList("a", "a")));
    }

    @Test
    void Members에_all_이라는_이름이_있으면_예외인지_테스트() {
        assertThrows(IllegalArgumentException.class, () ->
                InputValidator.checkMemberNames(Arrays.asList("all", "gogo")));
    }

    @Test
    void Members와_Prizes는_개수가_같아야함() {
        assertThrows(IllegalArgumentException.class, () ->
                InputValidator.checkPrizesName(Arrays.asList("go", "singsing"), 3));
    }
}