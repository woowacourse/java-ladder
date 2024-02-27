package ladder.domain;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatIllegalArgumentException;

import java.util.List;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class GameResultsTest {
    private GameResults gameResults;

    @BeforeEach
    void beforeEach() {
        UserNames userNames = UserNames.from(List.of("a", "b"));
        List<Integer> stepPositions = List.of(0);
        Destinations destinations = Destinations.of(List.of("꽝", "3000"), 2);
        this.gameResults = new GameResults(userNames, stepPositions, destinations);
    }

    @DisplayName("결과를 보고 싶은 사람의 이름이 all이나 입력했던 사용자 중에 없는 이름이면 예외를 던진다.")
    @Test
    void requestResultByUndefined() {
        assertThatIllegalArgumentException()
                .isThrownBy(() -> gameResults.findByUserName("c"))
                .withMessage("존재하지 않는 참여자입니다.");
    }

    @DisplayName("결과를 보고 싶은 사람의 이름에 해당하는 결과를 반환한다.")
    @Test
    void findGameResultByUserName() {
        String destination = gameResults.findByUserName("a");
        assertThat(destination).isEqualTo("3000");
    }

    @DisplayName("모든 결과를 반환한다")
    @Test
    void findAll() {
        List<UserDestination> userDestinations = gameResults.findAll();
        List<String> actualUserNames = userDestinations.stream()
                .map(UserDestination::getUserName)
                .toList();
        List<String> actualDestinations = userDestinations.stream()
                .map(UserDestination::getDestination)
                .toList();

        assertThat(actualUserNames).containsExactly("a", "b");
        assertThat(actualDestinations).containsExactly("3000", "꽝");
    }
}
