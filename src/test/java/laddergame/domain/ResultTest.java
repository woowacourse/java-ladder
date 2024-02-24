package laddergame.domain;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

@DisplayName("결과")
public class ResultTest {
    @Test
    @DisplayName("생성에 성공한다.")
    public void createResult() {
        //given
        String name = "name";

        //when
        Result result = new Result(name);

        //then
        assertEquals(result.getName(), name);
    }

    @ParameterizedTest
    @ValueSource(strings = {"", "    "})
    @DisplayName("빈이름을 허용하지 않는다.")
    public void resultBlankException(final String name) {
        //given & when & then
        assertThrows(IllegalArgumentException.class, () -> new Result(name));
    }
}
