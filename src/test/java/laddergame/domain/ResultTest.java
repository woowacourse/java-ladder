package laddergame.domain;

import laddergame.domain.result.Result;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.NullSource;
import org.junit.jupiter.params.provider.ValueSource;

import java.util.HashMap;
import java.util.Map;

public class ResultTest {

    @DisplayName("이름에 대한 결과값을 반환한다.")
    @Test
    void testFindByName() {
        // given
        final Map<String, String> maps = new HashMap<>();
        maps.put("pobi", "꽝");
        maps.put("honux", "3000");
        maps.put("crong", "꽝");
        maps.put("jk", "5000");

        Result result = new Result(maps);

        // when & then
        Assertions.assertThat(result.findByName("pobi")).isEqualTo("꽝");
    }

    @DisplayName("존재하지 않는 이름을 입력하면 예외를 발생시킨다.")
    @Test
    void testNotExistedPlayer() {
        // given
        final Map<String, String> maps = new HashMap<>();
        maps.put("pobi", "꽝");
        maps.put("honux", "3000");
        maps.put("crong", "꽝");
        maps.put("jk", "5000");

        Result result = new Result(maps);

        // when & then
        Assertions.assertThatThrownBy(() -> result.findByName("zeze"))
                        .isInstanceOf(IllegalArgumentException.class)
                        .hasMessage("[ERROR] 존재하지 않는 참가자이름입니다.");
    }
}
