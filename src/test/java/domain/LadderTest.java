package domain;


import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import java.util.List;
import java.util.Map;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatCode;

public class LadderTest {

    @ParameterizedTest
    @ValueSource(ints = {0, 11})
    @DisplayName("사다리 높이가 1~10을 벗어나면 예외가 발생한다.")
    void LadderHeightFailTest(int height) {
        Assertions.assertThatThrownBy(() -> new Ladder(new Height(height), new Width(5), new RandomLadderGenerator()))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @ParameterizedTest
    @ValueSource(ints = {1, 10})
    @DisplayName("사다리 높이가 1~10 사이면 정상적으로 수행된다.")
    void LadderHeightSuccessTest(int height) {
        assertThatCode(() -> new Ladder(new Height(height), new Width(5), new RandomLadderGenerator()))
                .doesNotThrowAnyException();
    }

    @DisplayName("사다리 게임을 정상적으로 진행후 (유저 이름 : 도착 index)데이터가 반환된다.")
    @Test
    void ladderResultTest() {
        //given
        Users users = new Users(List.of(
                new User("pobi"),
                new User("honux"),
                new User("crong"),
                new User("jk"))
        );
        Ladder ladder = new Ladder(
                new Height(4),
                new Width(users.getCount() - 1),
                ((width, height) -> List.of(
                        new Line(List.of(Bridge.EXIST, Bridge.NON_EXIST, Bridge.EXIST)),
                        new Line(List.of(Bridge.NON_EXIST, Bridge.EXIST, Bridge.NON_EXIST)),
                        new Line(List.of(Bridge.EXIST, Bridge.NON_EXIST, Bridge.NON_EXIST)),
                        new Line(List.of(Bridge.EXIST, Bridge.NON_EXIST, Bridge.EXIST))
                ))
        );

        //when
        Map<String, Integer> result = ladder.play(users);

        //then
        assertThat(result.get("pobi")).isEqualTo(3);
        assertThat(result.get("honux")).isEqualTo(0);
        assertThat(result.get("crong")).isEqualTo(2);
        assertThat(result.get("jk")).isEqualTo(1);
    }
}
