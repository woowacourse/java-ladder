package domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

class ResultTest {

    @Test
    @DisplayName("개별 맵핑 결과를 정상적으로 반환하는가")
    void correctly_return_single_mapping_info() {
        List<Integer> from = List.of(1, 2, 3, 4);
        List<Integer> to = List.of(4, 3, 2, 1);

        Result result = new Result(from, to);

        List<Integer> actual = result.getAll();
        assertThat(actual).containsExactlyElementsOf(to);
    }

    @Test
    @DisplayName("전체 맵핑 결과를 정상적으로 반환하는가")
    void correctly_return_all_mapping_info() {
        List<Integer> from = List.of(1, 2, 3, 4);
        List<Integer> to = List.of(4, 3, 2, 1);

        Result result = new Result(from, to);

        Integer actual = result.getOne(1);
        assertThat(actual).isEqualTo(4);
    }

}
