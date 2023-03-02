package ladder.repository;

import static org.assertj.core.api.Assertions.*;

import java.util.List;
import ladder.domain.Player;
import ladder.domain.PlayerResult;
import ladder.domain.Prize;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class PlayerResultsRepositoryTest {

    PlayerResultsRepository playerResultsRepository;

    @BeforeEach
    void setUp() {
        playerResultsRepository = new PlayerResultsRepository();
    }

    @Test
    @DisplayName("사용자의 결과가 정상적으로 저장되어야 한다.")
    void save_success() {
        // given
        PlayerResult playerResult = new PlayerResult(new Player("glen"), new Prize("1000"));

        // when
        playerResultsRepository.save(playerResult);

        // then
        List<PlayerResult> playerResults = playerResultsRepository.findAll();
        assertThat(playerResults)
                .hasSize(1);
        assertThat(playerResults.get(0).getPlayerName())
                .isEqualTo("glen");
        assertThat(playerResults.get(0).getPrize())
                .isEqualTo("1000");
    }

    @Test
    @DisplayName("사용자의 이름으로 찾을 수 있어야 한다.")
    void findByPlayerName_success() {
        // given
        playerResultsRepository.save(new PlayerResult(new Player("glen"), new Prize("1000")));

        // when
        PlayerResult playerResult = playerResultsRepository.findByPlayerName("glen");

        // then
        assertThat(playerResult.getPlayerName())
                .isEqualTo("glen");
        assertThat(playerResult.getPrize())
                .isEqualTo("1000");
    }

    @Test
    @DisplayName("사용자의 이름으로 찾을 때 사용자가 없으면 예외가 발생한다.")
    void findByPlayerName_wrongName() {
        // expect
        assertThatIllegalArgumentException().isThrownBy(() -> {
            playerResultsRepository.findByPlayerName("glen");
        }).withMessage("[ERROR] 해당 참여자가 없습니다.");
    }
}
