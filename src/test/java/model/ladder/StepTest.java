package model.ladder;

import model.ladder.generator.AlwaysConnectStatusGenerator;
import model.ladder.generator.AlwaysDisconnectStatusGenerator;
import model.ladder.generator.RandomStatusGenerator;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;

class StepTest {

    @DisplayName("이전에 생성된 다리와 겹쳐서 현재 위치의 다리가 연결되지 않는다.")
    @Test
    void previousOverlapTest() {
        // given
        Step previous = Step.from(StepStatus.CONNECTED);
        Step expected = Step.from(StepStatus.DISCONNECTED);

        // when
        Step step = Step.of(previous, new RandomStatusGenerator());

        // then
        Assertions.assertTrue(step.equals(expected));
    }

    @Nested
    @DisplayName("이전에 생성된 다리와 겹치지 않는 경우 테스트")
    class PreviousDoesNotOverlapTest {
        @DisplayName("현재 최초로 생성되는 다리이며 현재 위치의 다리를 연결한다.")
        @Test
        void firstConnectStepTest() {
            // given
            Step previous = Step.from(StepStatus.EMPTY);
            Step expected = Step.from(StepStatus.CONNECTED);

            // when
            Step step = Step.of(previous, new AlwaysConnectStatusGenerator());

            // then
            Assertions.assertTrue(step.equals(expected));
        }

        @DisplayName("이전에 다리가 생성되지 않으며 현재 위치의 다리를 연결한다.")
        @Test
        void connectStepTest() {
            // given
            Step previous = Step.from(StepStatus.DISCONNECTED);
            Step expected = Step.from(StepStatus.CONNECTED);

            // when
            Step step = Step.of(previous, new AlwaysConnectStatusGenerator());

            // then
            Assertions.assertTrue(step.equals(expected));
        }

        @DisplayName("현재 최초로 생성되는 다리이며 현재 위치의 다리를 연결하지 않는다.")
        @Test
        void firstDisconnectStepTest() {
            // given
            Step previous = Step.from(StepStatus.EMPTY);
            Step expected = Step.from(StepStatus.DISCONNECTED);

            // when
            Step step = Step.of(previous, new AlwaysDisconnectStatusGenerator());

            // then
            Assertions.assertTrue(step.equals(expected));
        }

        @DisplayName("이전에 다리가 생성되지 않으며 현재 위치의 다리를 연결하지 않는다.")
        @Test
        void disconnectStepTest() {
            // given
            Step previous = Step.from(StepStatus.DISCONNECTED);
            Step expected = Step.from(StepStatus.DISCONNECTED);

            // when
            Step step = Step.of(previous, new AlwaysDisconnectStatusGenerator());

            // then
            Assertions.assertTrue(step.equals(expected));
        }
    }

}
