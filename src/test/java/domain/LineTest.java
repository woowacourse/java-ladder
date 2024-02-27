package domain;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import utils.RandomGenerator;
import util.TrueGenerator;

import java.util.List;

import static domain.Bridge.*;
import static org.assertj.core.api.Assertions.*;

class LineTest {


    @Test
    @DisplayName("가로 길이는 사용자 수 -1 이다.")
    void createLineWithPersonCount() {
        //given
        int personCount = 4;
        //when
        //then
        assertThatCode(() -> new Line(personCount, new RandomGenerator())).doesNotThrowAnyException();
    }

    @Test
    @DisplayName("가로 라인은 겹치지 않는다.")
    void createRandomLine() {
        //given
        int personCount = 4;
        List<Boolean> expectedPoint = List.of(true, false, true);
        //when
        Line line = new Line(personCount, new TrueGenerator());
        List<Boolean> list = line.getBridges().stream()
                .map(Bridge::getBridge)
                .toList();
        //then
        assertThat(list).isEqualTo(expectedPoint);
    }

    @Test
    @DisplayName("양 옆에 Bridge가 없다면, 현재 위치 Line 값을 반환한다.")
    void moveDirectly() {
        // given
        List<Bridge> bridges = List.of(NON_BRIDGE, BRIDGE, NON_BRIDGE);
        Line line = new Line(bridges);
        // when
        int nextBridgeIndex = line.moveFrom(0);
        // then
        assertThat(nextBridgeIndex).isZero();
    }

    @Test
    @DisplayName("Bridge를 만나면, 좌 우로 이동한다.")
    void moveWithBridge() {
        //given
        Line line = new Line(
                List.of(NON_BRIDGE, BRIDGE, NON_BRIDGE, BRIDGE)
        );

        //when
        //then
        Assertions.assertAll(
                () -> assertThat(line.moveFrom(1)).isEqualTo(2),
                () -> assertThat(line.moveFrom(4)).isEqualTo(3)
        );
    }

}
