package laddergame.domain;

import static laddergame.TestDummy.TEST_BOOLEAN_GENERATOR;
import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertDoesNotThrow;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.List;
import java.util.Map;
import laddergame.TestDummy;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class LadderGameTest {
    @DisplayName("사다리 게임은 참여자와 실행결과를 받아 생성된다.")
    @Test
    void createWithParticipantsAndLadderResult() {
        //given
        PersonalNames personalNames = TestDummy.NAME_SIZE_2;
        LadderResult ladderResult = TestDummy.LADDER_RESULT_SIZE_2;
        //when
        //then
        assertDoesNotThrow(() -> new LadderGame(personalNames, ladderResult));
    }

    @DisplayName("사다리 게임은 참여자와 실행결과를 받아 게임 결과를 만들 수 있다.")
    @Test
    void makeGameResultFromParticipantsAndLadderResult() {
        //given
        PersonalNames personalNames = new PersonalNames(List.of("rosie", "kiara"));
        LadderResult ladderResult = TestDummy.LADDER_RESULT_SIZE_2;
        Ladder ladder = new Ladder(new Width(2), new Height(3), TEST_BOOLEAN_GENERATOR);
        LadderGame ladderGame = new LadderGame(personalNames, ladderResult);
        //when
        //then
        assertDoesNotThrow(() -> {
            ladderGame.moveAndGetResult(ladder);
        });
    }

    @DisplayName("매치된 결과에 모든 이름이 포함되어야한다.")
    @Test
    void includeAllNames() {
        //given
        PersonalNames personalNames = new PersonalNames(List.of("rosie", "kiara"));
        LadderResult ladderResult = TestDummy.LADDER_RESULT_SIZE_2;
        Ladder ladder = new Ladder(new Width(2), new Height(3), TEST_BOOLEAN_GENERATOR);
        LadderGame ladderGame = new LadderGame(personalNames, ladderResult);
        //when
        Map<String, String> gameResult = ladderGame.moveAndGetResult(ladder);
        //then
        assertThat(gameResult.keySet()).contains(PersonalName.valueOf("rosie"), PersonalName.valueOf("kiara"));
    }

    @DisplayName("매칭된 결과가 일치해야한다.")
    @Test
    void correctMatch() {
        //given
        PersonalNames personalNames = new PersonalNames(List.of("rosie", "kiara"));
        LadderResult ladderResult = LadderResult.of(personalNames, List.of("result1", "result2"));
        BooleanGenerator fixedGenerator = new BooleanGenerator() { // TODO: fixture로 빼기
            final Deque<Boolean> queue = new ArrayDeque<>(List.of(
                    false,
                    true,
                    false
            ));

            @Override
            public boolean generate() {
                return queue.pollFirst();
            }
        };
        Ladder ladder = new Ladder(new Width(2), new Height(3), fixedGenerator);
        LadderGame ladderGame = new LadderGame(personalNames, ladderResult);
        //when
        Map<String, String> matchedResult = ladderGame.moveAndGetResult(ladder);
        //then
        assertThat(matchedResult.get(PersonalName.valueOf("rosie")).getName()).isEqualTo("result2");
        assertThat(matchedResult.get(PersonalName.valueOf("kiara")).getName()).isEqualTo("result1");
    }
}
