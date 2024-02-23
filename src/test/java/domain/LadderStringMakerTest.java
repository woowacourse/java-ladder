package domain;

import java.util.List;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class LadderStringMakerTest {
    @Test
    @DisplayName("생성된 다리 행들을 개행으로 이어 붙임")
    void testJoiningWithNewLine() {
        Height height = new Height(5);
        Width width = new Width(2);
        Ladder ladder = new Ladder(height, width, bridge -> List.of(true));
        String ladderString = LadderStringMaker.make(ladder);

        long actual = ladderString.chars().filter(c -> c == '\n').count();
        long expected = 4;

        Assertions.assertThat(actual).isEqualTo(expected);
    }

    @Test
    @DisplayName("사다리 마지막 문자는 | 으로 끝남")
    void testLadderStringEnd() {
        Height height = new Height(5);
        Width width = new Width(2);
        Ladder ladder = new Ladder(height, width, width1 -> List.of(true));
        String ladderString = LadderStringMaker.make(ladder);

        String actual = ladderString.substring(ladderString.length() - 1);
        String expected = "|";
        Assertions.assertThat(actual).isEqualTo(expected);
    }

}