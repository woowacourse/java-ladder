package laddergame.domain.validator;

import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;
import static org.junit.jupiter.api.Assertions.assertThrows;

public class PlayerNamesValidatorTest {
    /*@Test
    void 이름입력값이_배열로_전달되는지_테스트() {
        String input = "a,b,c";
        List<String> checker = Arrays.asList("a", "b", "c");
        assertThat(PlayerNamesValidator.makeNames(input)).isEqualTo(checker);
    }*/

    @Test
    void 널일때예외처리되는지테스트() {
        assertThrows(IllegalArgumentException.class, () ->
                PlayerNamesValidator.checkNullName(null));
    }

    /*@Test
    void 엠티쓰트링일때테스트() {
        assertThrows(IllegalArgumentException.class, () ->
                PlayerNamesValidator.makeNames(""));
    }*/

    @Test
    void 중복하는_이름이_존재할때_예외테스트() {
        List<String> names = Arrays.asList("a", "b", "b");

        assertThrows(IllegalArgumentException.class, () ->
                PlayerNamesValidator.checkDuplicatedName(names));
    }

}
