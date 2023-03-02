package ladder.repository;

import static ladder.Util.createPrizes;
import static org.assertj.core.api.Assertions.*;

import java.util.List;
import ladder.domain.Prize;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class PrizeRepositoryTest {
    PrizeRepository prizeRepository;

    @BeforeEach
    void setUp() {
        prizeRepository = new PrizeRepository();
    }
    
    @Test
    @DisplayName("실행 결과 목록이 정상적으로 저장되어야 한다.")
    void saveAll_success() {
        // given
        List<Prize> prizes = createPrizes(5);

        // when
        prizeRepository.saveAll(prizes);

        // then
        assertThat(prizeRepository.findAll())
                .hasSize(5);
    }

    @Test
    @DisplayName("인덱스로 실행 결과를 찾을 수 있어야 한다.")
    void findByIndex_success() {
        // given
        prizeRepository.saveAll(createPrizes("1000", "꽝", "5000"));

        // when
        Prize prize = prizeRepository.findByIndex(1);

        // then
        assertThat(prize.getPrize())
                .isEqualTo("꽝");
    }
}
