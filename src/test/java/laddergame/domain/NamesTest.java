package laddergame.domain;

import static org.assertj.core.api.Assertions.assertThatThrownBy;

import java.util.List;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class NamesTest {


    @DisplayName("이름이 중복되면 예외를 발생시킨다.")
    @Test
    void duplicatedName() {
        assertThatThrownBy(() -> new Names(List.of("zeze", "zeze")))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage("[ERROR] 이름은 중복 될 수 없습니다.");
    }
}
