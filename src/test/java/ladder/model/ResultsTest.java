package ladder.model;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class ResultsTest {

    @Test
    @DisplayName("플레이어 수와 실행 결과 수가 일치하지 않는 경우 예외처리 테스트")
    void invalidResultCountTest(){
        List<String> results = new ArrayList<>(List.of("꽝", "꽝", "3000", "5000"));
        Assertions.assertThatThrownBy(() -> new Results(results, 2))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    @DisplayName("플레이어 수와 실행 결과 수가 일치하면 통과 테스트")
    void validResultCountTest(){
        List<String> results = new ArrayList<>(List.of("꽝", "꽝", "3000", "5000"));
        Assertions.assertThatThrownBy(() -> new Results(results, 4))
                .isInstanceOf(IllegalArgumentException.class);
    }

}
