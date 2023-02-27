package domain;

import static org.assertj.core.api.Assertions.assertThat;

import domain.LineGeneratorTest.TestLinkGenerator;
import domain.ladder.Ladder;
import domain.ladder.Link;
import domain.ladder.RandomLinkGenerator;
import domain.user.User;
import domain.user.Users;
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
        Assertions.assertDoesNotThrow(() -> new Ladder(new Height(height),
                new PersonCount(personCount), new RandomLinkGenerator()));
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
        final Ladder ladder = new Ladder(new Height(2), new PersonCount(3),
                new TestLinkGenerator(List.of(Link.LINKED, Link.UNLINKED, Link.LINKED)));

        ladder.playLadderGame(users);

        assertThat(users)
                .extracting("users")
                .asInstanceOf(InstanceOfAssertFactories.list(User.class))
                .isEqualTo(List.of(new User("다니"), new User("썬샷"), new User("홍실")));
    }

}
