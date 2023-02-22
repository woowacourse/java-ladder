package domain;

import exception.InvalidPersonNameException;
import exception.NotFindPersonException;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.NullAndEmptySource;

import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

class LadderGameTest {

    LadderGame ladderGame;

    @BeforeEach
    void setUp() {
        Participants participants = new Participants("pobi,honux,crong,jk");
        Ladder ladder = new Ladder(new Height("3"), new Weight(4), () -> true);
        Results results = new Results("a,b,c,d", 4);

        ladderGame = new LadderGame(participants, ladder, results);
    }

    @DisplayName("요청 값으로 all을 전달한 경우 전체 결과를 반환한다.")
    @Test
    void getAllResult() {
        Assertions.assertThat(ladderGame.getResult("all"))
                  .containsEntry("pobi", "b")
                  .containsEntry("honux", "a")
                  .containsEntry("crong", "d")
                  .containsEntry("jk", "c");
    }

    @DisplayName("요청 값으로 존재하는 사람의 이름을 전달한 경우 해당 사람의 결과를 반환한다.")
    @Test
    void getResultByName() {
        Assertions.assertThat(ladderGame.getResult("pobi"))
                  .containsEntry("pobi", "b");
    }

    @DisplayName("요청 값으로 존재하지 않는 사람의 이름을 전달한 경우 오류를 반환한다.")
    @Test
    void getResultNotFindName() {
        Assertions.assertThatThrownBy(() -> ladderGame.getResult("test"))
                  .isExactlyInstanceOf(NotFindPersonException.class);
    }

    @DisplayName("요청 값으로 빈값을 전달한 경우 오류를 반환한다.")
    @ParameterizedTest
    @NullAndEmptySource
    void getResultNullAndEmpty(String input) {
        Assertions.assertThatThrownBy(() -> ladderGame.getResult(input))
                  .isExactlyInstanceOf(InvalidPersonNameException.class);
    }

    @DisplayName("요청 값으로 공백만 전달한 경우 오류를 반환한다.")
    @Test
    void getResultBlank() {
        Assertions.assertThatThrownBy(() -> ladderGame.getResult("   "))
                  .isExactlyInstanceOf(InvalidPersonNameException.class);
    }
}
