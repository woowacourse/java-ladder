package ladder.domain;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;

public class ResultTest {
    private Names names;

    @BeforeEach
    void setup() {
        names = new Names(
                Arrays.asList("AAAA", "BBBB", "CCCC", "DDDD", "EEEE")
        );
    }

    @DisplayName("참여자 수와 내기 목록의 수가 같아야 한다.")
    @Test
    void createResultFailTestByDifferentCountOfNamesAndBet() {
        List<String> bets = Arrays.asList("꽝", "꽝", "당첨");

        Assertions.assertThrows(IllegalArgumentException.class,
                () -> new Result(names, bets));
    }
}
