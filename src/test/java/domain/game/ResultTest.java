package domain.game;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

class ResultTest {

    @Test
    @DisplayName("개별 맵핑 결과를 정상적으로 반환하는가")
    void correctly_return_single_mapping_info() {
        List<Integer> to = List.of(3, 0, 2, 1);

        Result result = new Result(to);

        assertThat(result.getOne(3)).isEqualTo(0);
    }
}
