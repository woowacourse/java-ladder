package domain;

import static org.assertj.core.api.Assertions.*;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import strategy.RandomConnectStrategy;

public class LinesTest {

    @Test
    @DisplayName("Lines 생성 성공: 사다리 높이 만큼의 Line 객체 리스트 생성")
    void test_ok_createLines() {
        Height height = Height.from(5);
        Lines lines = Lines.of(4, height, new RandomConnectStrategy());
        assertThat(lines.getLines().size()).isEqualTo(5);
    }

    @Test
    @DisplayName("성공: 전체 라인에 대해 플레이어를 이동시켰을 때 index가 정상 매핑된다.")
    void test_ok_findRewardIndex() {
        Lines lines = Lines.of(4, Height.from(3), () -> Connection.CONNECTED);

        Assertions.assertAll(
            () -> assertThat(lines.findRewardIndex(0)).isEqualTo(1),
            () -> assertThat(lines.findRewardIndex(1)).isEqualTo(0),
            () -> assertThat(lines.findRewardIndex(2)).isEqualTo(3),
            () -> assertThat(lines.findRewardIndex(3)).isEqualTo(2)
        );
    }
}
