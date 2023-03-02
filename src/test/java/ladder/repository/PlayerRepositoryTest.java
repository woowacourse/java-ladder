package ladder.repository;

import static ladder.Util.createPlayers;
import static org.assertj.core.api.Assertions.*;
import static org.assertj.core.api.Assertions.assertThatIllegalArgumentException;

import java.util.List;
import ladder.domain.Player;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class PlayerRepositoryTest {
    PlayerRepository playerRepository;

    @BeforeEach
    void setUp() {
        playerRepository = new PlayerRepository();
    }

    @Test
    @DisplayName("사용자 리스트가 정상적으로 저장되어야 한다.")
    void saveAll_success() {
        // given
        List<Player> players = createPlayers(5);

        // when
        playerRepository.saveAll(players);

        // then
        assertThat(playerRepository.findAll())
                .hasSize(5);
    }
    
    @Test
    @DisplayName("사용자 인원 수가 정상적으로 반환되어야 한다.")
    void countBy_success() {
        // given
        List<Player> players = createPlayers(5);

        // when
        playerRepository.saveAll(players);

        // then
        assertThat(playerRepository.countBy())
                .isEqualTo(5);
    }

    @Test
    @DisplayName("사용자가 주어지면 해당 인덱스가 반환되어야 한다.")
    void findIndexByPlayer_success() {
        // given
        List<Player> players = createPlayers("glen", "bero", "pobi");

        // when
        playerRepository.saveAll(players);

        // then
        assertThat(playerRepository.findIndexByPlayer(new Player("bero")))
                .isEqualTo(1);
    }

    @Test
    @DisplayName("인덱스를 찾을 때 사용자가 없으면 예외가 발생해야 한다.")
    void findIndexByPlayer_wrongPlayer() {
        // expect
        assertThatIllegalArgumentException().isThrownBy(() -> {
            playerRepository.findIndexByPlayer(new Player("glen"));
        }).withMessage("[ERROR] 해당 참여자가 없습니다.");
    }
}
