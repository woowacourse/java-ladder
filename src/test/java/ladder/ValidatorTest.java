package ladder;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Arrays;

import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.junit.jupiter.api.Assertions.assertFalse;

public class ValidatorTest {
    @Test
    void 글자수_5자_이하인_경우_True_반환() {
        assertTrue(Validator.checkNameLength("pobi"));
    }

    @Test
    void 글자수_5자_초과인_값이_없을_경우_True_반환() {
        assertTrue(Validator.checkNamesLength(Arrays.asList("pobi","crong")));
    }

    @Test
    void 글자수_5자_초과인_값이_있을_경우_False_반환() {
        assertFalse(Validator.checkNamesLength(Arrays.asList("pobicrong","crong")));
    }

    @Test
    void 글자수_5자_초과인_경우_False_반환() {
        assertFalse(Validator.checkNameLength("pobihonux"));
    }

    @Test
    void 사다리_높이값이_숫자인_경우_True_반횐() {
        assertTrue(Validator.checkLadderHeight("19"));
    }

    @Test
    void 사다리_높이값이_숫자가_아닌_경우_False_반환() {
        assertFalse(Validator.checkLadderHeight("a"));
    }
}
