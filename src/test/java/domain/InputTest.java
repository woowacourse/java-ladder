package domain;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertThrows;

/**
 * @author 베베
 * @version 1.0.0
 * @Created by 베베 on 2023. 02. 20.
 */
public class InputTest {

    private static List<String> splitComma(String input) {
        return Arrays.asList(input.split(","));
    }

    @DisplayName("사람 수는 2명 이상이어야 한다.")
    @Test
    void methodName(String inputPeople) {
        List<String> names = splitComma(inputPeople);

        assertThrows(IllegalArgumentException.class, () -> new Player(names));
    }
}
