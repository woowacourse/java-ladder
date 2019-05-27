/*
 * @(#)HorizonTest.java      1.0 2019/05/16
 *
 * Copyright (c) 2019 Hyogeon Kim,
 * Ladder, Java, Seoul, KOREA
 */

package ladder.model.ladder;

import org.junit.jupiter.api.Test;

import java.util.Random;

import static org.assertj.core.api.Java6Assertions.assertThat;

/**
 * @author 김효건
 * @version 1.0 2019년 05년 16일
 */
public class HorizonTest {
        /*가로선에 대한 검사를 하는 클래스*/
        @Test
        void 가로선_비중복_생성검사() {
                Random randomGenerator = new Random();
                Horizon beforeHorizon = new Horizon(true);
                assertThat(new Horizon(beforeHorizon, randomGenerator.nextBoolean()).hasHorizon()).isEqualTo(false);
        }

        @Test
        void true_false_이동검사() {
                Horizon beForeHorizon = new Horizon(true);
                Horizon horizon = new Horizon(beForeHorizon, false);

                assertThat(horizon.move()).isEqualTo(-1);
        }

        @Test
        void false_true_이동검사() {
                Horizon beForeHorizon = new Horizon(false);
                Horizon horizon = new Horizon(beForeHorizon, true);

                assertThat(horizon.move()).isEqualTo(1);
        }

        @Test
        void false_false_이동검사() {
                Horizon beForeHorizon = new Horizon(false);
                Horizon horizon = new Horizon(beForeHorizon, false);

                assertThat(horizon.move()).isEqualTo(0);
        }
}
