package domain;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.List;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import utils.LadderRowGenerator;

public class LadderTest {

    @Test
    @DisplayName("parseLadderToString은 사다리의 정보를 문자열로 변환한다.")
    void parseLadderToStringTest() {
//        아래와 같은 모양의 사다리가 생성되는 지 확인
//            |-----|     |-----|
//            |     |-----|     |
//            |-----|     |     |
//            |     |-----|     |
//            |-----|     |-----|

        LadderRowGenerator ladderRowGenerator = new TestLadderRowGenerator();
        Ladder ladder = new Ladder(ladderRowGenerator);

        ladder.create(5, 4);

        assertThat(ladder.getLadderMap())
                .containsExactly(List.of(true, false, true),
                        List.of(false, true, false),
                        List.of(true, false, false),
                        List.of(false, true, false),
                        List.of(true, false, true));
    }
}
