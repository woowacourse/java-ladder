package domain;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

import domain.LineGeneratorTest.TestLinkGenerator;
import exception.ErrorMessage;
import java.util.List;
import org.assertj.core.api.InstanceOfAssertFactories;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class LadderTest {
    @Test
    @DisplayName("사다리는 높이를 입력받는다.")
    void ladderTest() {
        int height = 4;
        int personCount = 5;
        Assertions.assertDoesNotThrow(() -> new Ladder(height, personCount, new RandomLinkGenerator()));
    }

    @Test
    @DisplayName("사다리의 높이로 음수가 들어오는 경우 예외를 발생시킨다.")
    void ladderHeightNonPositive() {
        int height = -1;
        int personCount = 5;
        assertThatThrownBy(() -> new Ladder(height, personCount, new RandomLinkGenerator()))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage(ErrorMessage.LADDER_HEIGHT_EXCEPTION.getMessage());
    }

    /*
    테스트하는 사다리의 형태
    |-----|     |
    |     |-----|
     */
    @Test
    @DisplayName("User의 index가 사다리 게임 결과에 맞게 변경되는지 테스트")
    void playLadderGameTest() {
        final Users users = new Users(List.of("홍실", "다니", "썬샷"));
        final Ladder ladder = new Ladder(2, 3,
                new TestLinkGenerator(List.of(Link.LINKED, Link.UNLINKED, Link.LINKED)));

        ladder.playLadderGame(users);

        assertThat(users)
                .extracting("users")
                .asInstanceOf(InstanceOfAssertFactories.list(User.class))
                .isEqualTo(List.of(new User("다니"), new User("썬샷"), new User("홍실")));
    }

}
