package model;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.ValueSource;

public class LadderTest {

    @ParameterizedTest(name = "Ladder personCount = {0} , ladderHeight = {1} 일 경우 객체 생성 성공 테스트")
    @CsvSource(value = {"1:1", "2:2", "3:3", "4:4", "5:5"}, delimiter = ':')
    void createLadderTest(int nameSize, int ladderHeight) {
        Assertions.assertThatNoException().isThrownBy(() -> new Ladder(nameSize,
                new LadderHeight(ladderHeight)));
    }

    @ParameterizedTest(name = "Ladder personCount = {0} , ladderHeight = {1} 일 경우 객체 생성 실패 테스트")
    @CsvSource(value = {"0:0", "0:-1", "-1:0", "-1:-1"}, delimiter = ':')
    void createLadderFailTest(int nameSize, int ladderHeight) {
        Assertions.assertThatThrownBy(
                () -> new Ladder(nameSize,new LadderHeight(ladderHeight))
        ).isInstanceOf(IllegalArgumentException.class);
    }
}
