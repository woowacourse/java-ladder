package ladder.domain;

import org.junit.jupiter.api.Test;

import java.util.List;
import java.util.Map;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

class ResultsTest {

    @Test
    void 참여자의_결과를_가져온다() {
        Players players = new Players(
                List.of(
                        new Player("주노", 0),
                        new Player("도이", 1)
                )
        );

        List<String> dummy = List.of("1", "2");

        Results results = new Results(players, dummy);

        Map<String, String> result = results.toResultByPlayerName("주노");
        assertThat(result.get("주노")).isEqualTo("1");
    }

    @Test
    void 참여자와_결과의_개수가_다르면_예외() {
        Players players = new Players(
                List.of(
                        new Player("주노", 0),
                        new Player("도이", 1)
                )
        );
        List<String> dummy = List.of("1", "2", "3");

        assertThatThrownBy(() -> {
            new Results(players, dummy);
        }).isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    void 존재하지_않는_참여자를_입력하면_예외() {
        Players players = new Players(
                List.of(
                        new Player("주노", 0),
                        new Player("도이", 1)
                )
        );

        List<String> dummy = List.of("1", "2");

        Results results = new Results(players, dummy);

        assertThatThrownBy(() -> {
            results.toResultByPlayerName("없다");
        }).isInstanceOf(IllegalArgumentException.class);
    }
}