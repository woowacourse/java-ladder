package domain;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.ArrayList;
import java.util.List;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class ResultTest {

    @Test
    @DisplayName("플레이어의 인덱스와 일치하는 결과 반환 확인")
    void findResultByIndex() {
        Result results = new Result(new ArrayList<>(List.of("꽝", "당첨1", "당첨2", "당첨3")));

        assertThat(results.getResultByIndex(2)).isEqualTo("당첨2");
    }
}
