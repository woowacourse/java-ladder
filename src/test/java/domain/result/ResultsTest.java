package domain.result;

import static org.assertj.core.api.AssertionsForClassTypes.assertThatCode;

import domain.user.Users;
import java.util.List;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class ResultsTest {

    @Test
    @DisplayName("유저수와 결과수가 다르면 예외가 발생한다")
    void sameSize() {
        Users users = Users.fromNames(List.of("pobi", "brown"));
        Results results = Results.fromNames(List.of("꽝", "5000", "300"));
        assertThatCode(() -> results.validateSameSizeWithUsers(users)).isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    @DisplayName("결과가 비어 있으면 예외가 발생한다")
    void empty() {
        assertThatCode(() -> Results.fromNames(List.of())).isInstanceOf(IllegalArgumentException.class);
    }
}
