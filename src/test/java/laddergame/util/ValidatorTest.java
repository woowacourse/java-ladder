package laddergame.util;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Arrays;

import static org.junit.jupiter.api.Assertions.*;

class ValidatorTest {

    @Test
    void checkEmptyTag() {
        assertThrows(IllegalArgumentException.class, () -> Validator.checkEmptyTag(new ArrayList<>()));
    }

    @Test
    void checkDuplicateNames() {
        assertThrows(IllegalArgumentException.class, () ->
                Validator.checkDuplicateNames(Arrays.asList("a","a")));
    }

    @Test
    void checkEqualSize() {
        assertThrows(IllegalArgumentException.class, () ->
                Validator.checkEqualSize(1,2));
    }

    @Test
    void checkNameIsAll() {
        assertThrows(IllegalArgumentException.class, () ->
                Validator.checkNameIsAll("all"));
    }
}