package domain;

import domain.LadderTest.TestLadderRowGenerator;
import java.util.List;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import utils.LadderRowGenerator;

public class LadderGameTest {

    private LadderGame ladderGame;
    private LadderRowGenerator ladderRowGenerator;
    private Ladder ladder;
    private Users users;

    @BeforeEach
    void init() {
        ladderRowGenerator = new TestLadderRowGenerator();
        ladder = new Ladder(4, 5, ladderRowGenerator);
        users = new Users(List.of(new User("userA"), new User("userB"), new User("userC"), new User("userD")));
        ladderGame = new LadderGame(ladder, users);
    }

    @Test
    @DisplayName("LadderGame은 Ladder와 Users를 받아 생성된다.")
    void LadderGame은_Ladder와_Users를_받아_생성된다() {
        Assertions.assertThatCode(() -> new LadderGame(ladder, users))
                .doesNotThrowAnyException();
    }

    @ParameterizedTest(name = "출발할 인덱스를 주면 도착할 인덱스를 반환한다.")
    @CsvSource({"0,0", "1,3", "2,2", "3,1"})
    void 출발할_인덱스를_주면_사다리를_내려가_최종적으로_도착할_인덱스를_반환한다(int departureIndex, int arrivalIndex) {
        Assertions.assertThat(ladderGame.move(departureIndex, 0, 5)).isEqualTo(arrivalIndex);
    }
}
