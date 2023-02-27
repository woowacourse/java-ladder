package domain;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.List;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;
import util.FalseGenerator;
import util.TrueGenerator;

class LineTest {
    @Nested
    @DisplayName("생성 테스트")
    class createTest {
        @Test
        @DisplayName("한 라인에 (사람 수-1) 만큼 칸이 생성되는가")
        void createSpaceTest() {
            //given
            int personCount = 5;

            //when
            Line line = Line.from(personCount);

            //then
            assertThat(line.getBridges().size()).isEqualTo(personCount - 1);
        }

        @Test
        @DisplayName("BridgeGenerator 결과가 항상 true 일 때 다리 생성 테스트")
        void alwaysTrueCreateBridge() {
            //given
            Line line = Line.from(5);

            //when
            line.generate(new TrueGenerator());

            //then
            assertThat(line.getBridges()).containsExactly(Bridge.EXIST, Bridge.EMPTY, Bridge.EXIST, Bridge.EMPTY);
        }

        @Test
        @DisplayName("BridgeGenerator 결과가 항상 false 일 때 다리 생성 테스트")
        void alwaysFalseCreateBridge() {
            //given
            Line line = Line.from(5);

            //when
            line.generate(new FalseGenerator());

            //then
            assertThat(line.getBridges()).containsExactly(Bridge.EMPTY, Bridge.EMPTY, Bridge.EMPTY, Bridge.EMPTY);
        }
    }

    @Nested
    @DisplayName("연결유무 테스트")
    class hasBridge {
        @Test
        @DisplayName("왼쪽에 연결된 다리가 있는지")
        void hasBridgeInLeftTest() {
            //given
            Line line = new Line(List.of(Bridge.EXIST, Bridge.EMPTY));

            //when
            assertThat(line.hasBridgeInLeft(1)).isTrue();
            assertThat(line.hasBridgeInLeft(2)).isFalse();
        }

        @Test
        @DisplayName("오른쪽에 연결된 다리가 있는지")
        void hasBridgeInRightTest() {
            //given
            Line line = new Line(List.of(Bridge.EXIST, Bridge.EMPTY));

            //when
            assertThat(line.hasBridgeInRight(0)).isTrue();
            assertThat(line.hasBridgeInRight(1)).isFalse();
        }
    }
}
