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
        List<Integer> stepPositions = List.of();
        List<Destination> destinations = List.of(new Destination("꽝"), new Destination("3000"));
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
        String destination = gameResults.findByUserName("a").getDestination().value();
        assertThat(destination).isEqualTo("꽝");
    }
}
