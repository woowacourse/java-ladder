package ladder.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.Map;
import java.util.Set;

import static org.assertj.core.api.Assertions.assertThat;

class PlayResultsTest {

    @Test
    @DisplayName("게임 실행 결과 개수를 반환한다.")
    void size() {
        // given
        PlayResults playResults = new PlayResults(Map.of(
                new Name("이름"), new Result("결과"))
        );

        // when
        int size = playResults.size();

        // then
        assertThat(size).isEqualTo(1);
    }

    @Test
    @DisplayName("실행 결과에서 이름만을 모두 가져온다.")
    void keySet() {
        // given
        PlayResults playResults = new PlayResults(Map.of(
                new Name("이름1"), new Result("결과1"),
                new Name("이름2"), new Result("결과2")
        ));

        // when
        Set<Target> names = playResults.getNames();

        // then
        assertThat(names).contains(new Name("이름1"), new Name("이름2"));
    }

    @Test
    @DisplayName("이름과 일치하는 결과를 반환한다.")
    void findResult() {
        // given
        Result result2 = new Result("결과2");
        PlayResults playResults = new PlayResults(Map.of(
                new Name("이름1"), new Result("결과1"),
                new Name("이름2"), result2
        ));

        // when
        Result result = playResults.find(new Name("이름2"));

        // then
        assertThat(result).isEqualTo(result2);
    }
}
