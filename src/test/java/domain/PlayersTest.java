package domain;

import static org.assertj.core.api.Assertions.assertThatThrownBy;
import static org.junit.jupiter.api.Assertions.assertDoesNotThrow;

import java.util.Arrays;
import java.util.List;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

class PlayersTest {

    @Test
    @DisplayName("이름을 받아 올바르게 플레이어 일급 컬렉션을 생성한다.")
    void validCreationTest() {
        List<String> names = List.of("aru", "pobi", "woowa");
        assertDoesNotThrow(() -> new Players(names));
    }

    @ParameterizedTest
    @ValueSource(strings = {"aru", "a,b,c,d,e,f,g,h,i,j,k"})
    @DisplayName("사람 수가 범위를 넘어가는 경우, 예외를 발생한다.")
    void invalidSizeCreationTest(String value) {
        // given
        String[] split = value.split(",");
        List<String> names = Arrays.stream(split).toList();
        // when, then
        assertThatThrownBy(() -> new Players(names))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage("참여하는 사람의 수는 2명 이상 10명 이하여야 합니다.");
    }
}
