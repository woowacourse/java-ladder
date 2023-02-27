package domain;

import exception.InvalidPersonNameException;
import exception.NotFindPersonException;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.NullAndEmptySource;

import java.util.HashMap;
import java.util.Map;

class GameResultTest {

    Participants participants;
    GameResult gameResult;

    @BeforeEach
    void setUp() {
        participants = new Participants("pobi,honux,crong,jk");
        Ladder ladder = new Ladder(new Height("3"), new Weight(4), () -> true);
        Results results = new Results("a,b,c,d", 4);
        final Map<Person, Result> ladderResult = new HashMap<>();
        for (int index = 0; index < participants.getParticipantCount(); index++) {
            int resultIndex = ladder.getResultIndex(index);
            ladderResult.put(participants.getByIndex(index), results.getByIndex(resultIndex));
        }

        gameResult = new GameResult(ladderResult);
    }

    @DisplayName("요청 값으로 all을 전달한 경우 전체 결과를 반환한다.")
    @Test
    void getAllResult() {
        Map<Person, Result> allResult = gameResult.getAllResult();

        Assertions.assertThat(allResult.get(participants.getByIndex(0)).equals(new Result("b")))
                  .isTrue();
        Assertions.assertThat(allResult.get(participants.getByIndex(1)).equals(new Result("a")))
                  .isTrue();
        Assertions.assertThat(allResult.get(participants.getByIndex(2)).equals(new Result("d")))
                  .isTrue();
        Assertions.assertThat(allResult.get(participants.getByIndex(3)).equals(new Result("c")))
                  .isTrue();
    }

    @DisplayName("요청 값으로 존재하는 사람의 이름을 전달한 경우 해당 사람의 결과를 반환한다.")
    @Test
    void getResultByName() {
        Assertions.assertThat(gameResult.getResultByName("pobi").getResult())
                  .isEqualTo("b");
    }

    @DisplayName("요청 값으로 존재하지 않는 사람의 이름을 전달한 경우 오류를 반환한다.")
    @Test
    void getResultNotFindName() {
        Assertions.assertThatThrownBy(() -> gameResult.getResultByName("test"))
                  .isExactlyInstanceOf(NotFindPersonException.class);
    }

    @DisplayName("요청 값으로 빈값을 전달한 경우 오류를 반환한다.")
    @ParameterizedTest
    @NullAndEmptySource
    void getResultNullAndEmpty(String input) {
        Assertions.assertThatThrownBy(() -> gameResult.getResultByName(input))
                  .isExactlyInstanceOf(InvalidPersonNameException.class);
    }

    @DisplayName("요청 값으로 공백만 전달한 경우 오류를 반환한다.")
    @Test
    void getResultBlank() {
        Assertions.assertThatThrownBy(() -> gameResult.getResultByName("   "))
                  .isExactlyInstanceOf(InvalidPersonNameException.class);
    }
}
