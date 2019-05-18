package laddergame.util;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Arrays;

import static org.junit.jupiter.api.Assertions.*;

class ValidatorTest {
    @Test
    void checkNullName() {
        assertThrows(IllegalArgumentException.class, () ->
                Validator.checkBlankName(null));
    }

    @Test
    void checkBlankName() {
        assertThrows(IllegalArgumentException.class, () ->
                Validator.checkBlankName(""));
    }

    @Test
    void checkNameLength() {
        assertThrows(IllegalArgumentException.class, () ->
                Validator.checkNameLength("abcd",3));
    }

    @Test
    void checkNumberOfNames() {
        assertThrows(IllegalArgumentException.class, () ->
                Validator.checkNumberOfNames(new ArrayList<>(), 2));
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

    @Test
    void checkLadderHeight() {
        assertThrows(IllegalArgumentException.class, () ->
                Validator.checkLadderHeight(0));
    }
}