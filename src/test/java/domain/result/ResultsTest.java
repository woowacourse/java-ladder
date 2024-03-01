package domain.result;

import static org.assertj.core.api.Assertions.assertThatCode;
import static org.junit.jupiter.api.Assertions.*;

import domain.result.Result;
import domain.result.Results;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;

public class ResultsTest {
    @Test
    @DisplayName("보상 목록을 포함한 일급 컬렉션을 만든다.")
    public void createRewards() {
        List<String> value = List.of("꽝", "5000", "꽝", "3000");

        assertThatCode(() -> Results.from(value, value.size()))
                .doesNotThrowAnyException();
    }

    @Test
    @DisplayName("보상 목록이 플레이어 수와 다를시 예외를 발생한다.")
    public void throwExceptionWhenRewardsNotEqualSize() {
        List<String> value = List.of("꽝", "5000", "꽝");
        int playerSize = 4;

        assertThrows(IllegalArgumentException.class, () -> Results.from(value, playerSize));
    }

    @Test
    @DisplayName("특정 인덱스의 보상을 받아온다.")
    public void getRewardAtIndex() {
        List<String> value = List.of("꽝", "5000", "꽝", "3000");
        Results results = Results.from(value, value.size());

        Result result = results.getRewardAt(2);

        assertEquals(result.resultToString(), value.get(2));
    }

}
