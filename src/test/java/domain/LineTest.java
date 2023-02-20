package domain;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import util.FalseGenerator;
import util.TrueGenerator;

class LineTest {

    @Test
    @DisplayName("한 라인에 (사람 수-1) 만큼 칸이 생성되는가")
    void createSpaceTest() {
        //given
        int personCount = 5;

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
        assertThat(line.getBridges()).containsExactly(Bridge.EXIST, Bridge.EMPTY, Bridge.EXIST, Bridge.EMPTY);
    }

    @Test
    @DisplayName("BooleanGenerator 결과가 항상 false 일 때 다리 생성 테스트")
    void alwaysFalseCreateBridge() {
        //given
        Line line = new Line(5);

        //when
        line.generate(new FalseGenerator());

        //then
        assertThat(line.getBridges()).containsExactly(Bridge.EMPTY, Bridge.EMPTY, Bridge.EMPTY, Bridge.EMPTY);
    }

}