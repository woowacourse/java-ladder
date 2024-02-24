package laddergame.domain;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

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
}
