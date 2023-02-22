package model;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

public class ResultTest {
    @ParameterizedTest(name = "Result 객체 name ={0} 생성 성공 테스트")
    @ValueSource(strings = {"pobi", "honux","crong"})
    void createResultTest(String input) {
        Assertions.assertThatNoException().isThrownBy(() -> new Result(input));
    }
}
