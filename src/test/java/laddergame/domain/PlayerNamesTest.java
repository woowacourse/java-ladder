package laddergame.domain;

import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;
import static org.junit.jupiter.api.Assertions.assertThrows;
/*

public class PlayerNamesTest {
    @Test
    void 이름입력값이_배열로_전달되는지_테스트() {
        String input = "a,b,c";
        List<String> checker = Arrays.asList("a", "b", "c");
        assertThat(PlayerNames.makeNames(input)).isEqualTo(checker);
    }

    @Test
    void 널일때예외처리되는지테스트() {
        assertThrows(IllegalArgumentException.class, () ->
                PlayerNames.makeNames(null));
    }

    @Test
    void 엠티쓰트링일때테스트() {
        assertThrows(IllegalArgumentException.class, () ->
                PlayerNames.makeNames(""));
    }

    @Test
    void 중복하는_이름이_존재할때_예외테스트() {
        assertThrows(IllegalArgumentException.class, () ->
                PlayerNames.makeNames("a,a,b"));
    }

    @Test
    void 이름에_빈칸이_있을때_예외테스트() {
        assertThrows(IllegalArgumentException.class, () ->
                PlayerNames.makeNames("a,,,b"));
    }

    @Test
    void 이름에_공백문자만_있을때_예외테스트() {
        assertThrows(IllegalArgumentException.class, () ->
                PlayerNames.makeNames("a, ,b"));
        assertThrows(IllegalArgumentException.class, () ->
                PlayerNames.makeNames("a,  ,b"));
    }

    @Test
    void 이름의길이가적합하지않을때() {
        assertThrows(IllegalArgumentException.class, () ->
                PlayerNames.makeNames("a,b,aadsfsdfsadfadf"));
        assertThrows(IllegalArgumentException.class, () ->
                PlayerNames.makeNames("a,,b"));
    }

}

 */
