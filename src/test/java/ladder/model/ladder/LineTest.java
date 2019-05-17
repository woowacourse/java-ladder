/*
 * @(#)LineTest.java      1.0 2019/05/16
 *
 * Copyright (c) 2019 Hyogeon Kim,
 * Ladder, Java, Seoul, KOREA
 */

package ladder.model.ladder;

import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertThrows;

/**
 * @version 1.0 2019년 05년 16일
 * @author 김효건
 */
public class LineTest {
    /*사다리게임 각 층(라인)에 대한 테스트     */
    @Test
    void 중복_가로줄_검사_get() {
        List<Boolean> line = (new Line(5)).getHorizons();
        for (int i = 0; i < line.size() - 1; i++) {
            assertThat(line.get(i) && line.get(i + 1)).isEqualTo(false);
        }
    }

    @Test
    void 가로선_중복_생성_생성자() {
        assertThrows(IllegalArgumentException.class, ()->{
            new Line(Arrays.asList(false, true, true));
        });
    }

    @Test
    void 왼쪽_시작_결과추출_테스트() {
        Line line = new Line(Arrays.asList(false, true));
        assertThat(line.getIndexAfterMovingHorizon(0)).isEqualTo(0);
    }

    @Test
    void 오른쪽_시작_결과추출_테스트() {
        Line line = new Line(Arrays.asList(true, false));
        assertThat(line.getIndexAfterMovingHorizon(2)).isEqualTo(2);
    }
    @Test
    void 가운데_시작_결과추출_테스트() {
        Line line = new Line(Arrays.asList(false, true));
        assertThat(line.getIndexAfterMovingHorizon(1)).isEqualTo(2);
    }
}
