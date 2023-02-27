package domain;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import util.RandomBooleanGenerator;

class LineTest {
    @DisplayName("사람 수에 따른 라인 길이 생성 테스트")
    @ParameterizedTest
    @CsvSource(value = {"2:1", "10:9", "1000000:999999"}, delimiter = ':')
    void 사람_수에_따른_라인_길이_테스트(final int personNum, final int expectedLineLength) {
        Assertions.assertEquals(
                Line.newInstanceWithPersonCount(personNum, new RandomBooleanGenerator()).getPoints().size(),
                expectedLineLength);
    }
}
