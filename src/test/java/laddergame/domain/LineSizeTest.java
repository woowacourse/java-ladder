package laddergame.domain;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.List;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

public class LineSizeTest {


    @DisplayName("Names로 라인 사이즈를 결정한다.")
    @Test
    void create() {
        // given
        Names names = new Names(List.of("pobi", "zeze"));

        // when
        LineSize lineSize = new LineSize(names);

        // then
        assertThat(lineSize).extracting("lineSize").isEqualTo(1);
    }

    @DisplayName("라인 사이즈가 현재 사이즈보다 작으면 true를 반환한다.")
    @ParameterizedTest
    @ValueSource(ints = {0, 1, 2, 3})
    void isBiggerThanTrue(int size) {
        // given
        LineSize lineSize = new LineSize(new Names(List.of("pobi", "zeze", "honux", "crong", "jk")));

        // when & then
        assertThat(lineSize.isBiggerThan(size)).isTrue();
    }

    @DisplayName("라인 사이즈가 현재 사이즈보다 크면 false를 반환한다.")
    @ParameterizedTest
    @ValueSource(ints = {4, 5, 6, 7})
    void isBiggerThanFalse(int size) {
        // given
        LineSize lineSize = new LineSize(new Names(List.of("pobi", "zeze", "honux", "crong", "jk")));

        // when & then
        assertThat(lineSize.isBiggerThan(size)).isFalse();
    }
}
