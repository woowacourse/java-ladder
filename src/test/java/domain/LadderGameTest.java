package domain;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import java.util.List;

class LadderGameTest {

    LadderGame ladderGame;

    @BeforeEach
    void setUp() {
        Participants participants = new Participants("pobi,honux,crong,jk");
        Ladder ladder = new Ladder(new Height("3"), new Weight(4), () -> true);
        Results results = new Results("a,b,c,d", 4);
        ladderGame = new LadderGame(participants, results, ladder);
    }

    @DisplayName("participants 객체 값을 view가 원하는 형태로 반환해야 한다.")
    @Test
    void getParticipants() {
        Assertions.assertThat(ladderGame.getParticipants())
                  .containsExactly("pobi", "honux", "crong", "jk");
    }

    @DisplayName("results 객체 값을 view가 원하는 형태로 반환해야 한다.")
    @Test
    void getResults() {
        Assertions.assertThat(ladderGame.getResults())
                  .containsExactly("a", "b", "c", "d");
    }

    @DisplayName("ladder 객체 값을 view가 원하는 형태로 반환해야 한다.")
    @Test
    void getLadder() {
        Assertions.assertThat(ladderGame.getLadder())
                .containsExactly(List.of(true, false, true),
                        List.of(true, false, true),
                        List.of(true, false, true));
    }

    @DisplayName("전체 매칭 결과 객체 값을 view가 원하는 형태로 반환해야 한다.")
    @Test
    void getGameAllResult() {
        Assertions.assertThat(ladderGame.getGameAllResult())
                  .containsEntry("pobi", "b")
                  .containsEntry("honux", "a")
                  .containsEntry("crong", "d")
                  .containsEntry("jk", "c");
    }

    @DisplayName("한 명의 매칭 결과 값을 view가 원하는 형태로 반환해야 한다.")
    @ParameterizedTest
    @CsvSource({"pobi, b", "honux, a", "crong, d", "jk, c"})
    void getGameResultByName(String name, String result) {
        Assertions.assertThat(ladderGame.getGameResultByName(name)).isEqualTo(result);
    }
}
