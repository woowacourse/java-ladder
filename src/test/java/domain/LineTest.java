package domain;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;
import util.FalseGenerator;
import util.TrueGenerator;

class LineTest {

    @ParameterizedTest
    @ValueSource(ints = {3, 5, 10})
    @DisplayName("한 라인에 사람 수 만큼 칸이 생성되는가")
    void createSpaceTest(int personCount) {
        //given
        //when
        Line line = new Line(personCount);

        //then
        assertThat(line.getBridges().size()).isEqualTo(personCount - 1);
    }

    @Test
    @DisplayName("BooleanGenerator 결과가 항상 true 일 때 다리 생성 테스트")
    void alwaysTrueCreateBridge() {
        //given
        Line line = new Line(5);

        //when
        line.generate(new TrueGenerator());

        //then
        assertThat(line.getBridges()).containsExactly(true, false, true, false);
    }

    @Test
    @DisplayName("BooleanGenerator 결과가 항상 false 일 때 다리 생성 테스트")
    void alwaysFalseCreateBridge() {
        //given
        Line line = new Line(5);

        //when
        line.generate(new FalseGenerator());

        //then
        assertThat(line.getBridges()).containsExactly(false, false, false, false);
    }

}