package domain;

import static org.assertj.core.api.Assertions.*;
import static org.junit.jupiter.api.Assertions.*;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import view.OutputView;

class LadderTest {
    Ladder ladder;

    @BeforeEach
    void setUp() {
        ladder = new Ladder(new TestLadderRowGenerator());
        ladder.create(5,4);
    }

//    생성한 사다라의 모양은 다음과 같다.
//      |-----|     |-----|
//      |     |-----|     |
//      |-----|     |     |
//      |     |-----|     |
//      |-----|     |-----|

    @ParameterizedTest(name = "startIndex({0}) 을 입력하면 endIndex({1})을 반환한다")
    @CsvSource({"0,0","1,3","2,2","3,1"})
    void calculateEndIndexTest(int startIndex, int expected) {
        int result = ladder.calculateEndIndex(startIndex);

        assertThat(result).isEqualTo(expected);
    }
}
