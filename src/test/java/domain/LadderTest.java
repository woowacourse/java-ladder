package domain;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.List;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

class LadderTest {
    Ladder ladder;

    @BeforeEach
    void setUp() {
        ladder = new Ladder(new TestLadderRowGenerator());
        ladder.create(5, 4);
    }

//    생성한 사다라의 모양은 다음과 같다.
//      |-----|     |-----|
//      |     |-----|     |
//      |-----|     |     |
//      |     |-----|     |
//      |-----|     |-----|

    @ParameterizedTest(name = "startIndex({0}) 을 입력하면 endIndex({1})을 반환한다")
    @CsvSource({"0,0", "1,3", "2,2", "3,1"})
    void calculateEndIndexTest(int startIndex, int expected) {
        int result = ladder.calculateEndIndex(startIndex);

        assertThat(result).isEqualTo(expected);
    }

    @Test
    @DisplayName("startIndexes를 입력하면 endIndexes를 반환한다")
    void calculateEndIndexesTest() {
        List<Integer> result = ladder.calculateEndIndex(List.of(1, 3));

        assertThat(result).containsExactly(3, 1);
    }
}
