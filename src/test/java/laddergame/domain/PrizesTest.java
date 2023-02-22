package laddergame.domain;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;

class PrizesTest {

    private Prizes prizes;

    @BeforeEach
    void setup() {
        prizes = new Prizes(List.of("꽝", "1000", "꽝", "2000"));
    }

    @Test
    @DisplayName("사다리의 정상 생성 크기 확인 테스트")
    void prizesSizeTest() {
        assertThat(prizes.size()).isEqualTo(4);
    }

    @Test
    @DisplayName("사다리 위체(position)에 따라 해당 상품(prize)반환 테스트")
    void getPrizeAtTest() {
        assertThat(prizes.getPrizeValueAt(2)).isEqualTo("1000");
    }

}
