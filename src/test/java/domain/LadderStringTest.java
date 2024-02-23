package domain;

import java.util.Arrays;
import java.util.List;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class LadderStringTest {
    @Test
    @DisplayName("사다리 문자열 생성 시 맨 왼쪽 사다리는 4개의 공백으로 시작")
    void testLeftFourSpace() {
        Height height = new Height(5);
        Width width = new Width(2);
        Ladder ladder = new Ladder(height, width, width1 -> List.of(true));
        String ladderString = LadderString.from(ladder);

        String expected = "    ";
        Arrays.stream(ladderString.split("\n"))
                .map(ladderRow -> ladderRow.substring(0, 4))
                .forEach(actual -> Assertions.assertThat(actual).isEqualTo(expected));

    }

    @Test
    @DisplayName("사다리 마지막 문자는 | 으로 끝남")
    void testLadderStringEnd() {
        Height height = new Height(5);
        Width width = new Width(2);
        Ladder ladder = new Ladder(height, width, width1 -> List.of(true));
        String ladderString = LadderString.from(ladder);

        String actual = ladderString.substring(ladderString.length() - 1);
        String expected = "|";
        Assertions.assertThat(actual).isEqualTo(expected);


    }

}