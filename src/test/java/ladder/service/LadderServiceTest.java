package ladder.service;

import static ladder.Util.createPlayers;
import static ladder.Util.createPrizes;
import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatIllegalArgumentException;

import java.util.List;
import ladder.domain.Player;
import ladder.domain.Prize;
import ladder.domain.Step;
import ladder.dto.LadderResponse;
import ladder.dto.PlayerResultResponse;
import ladder.repository.PlayerRepository;
import ladder.repository.PlayerResultsRepository;
import ladder.repository.PrizeRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

class LadderServiceTest {
    PlayerRepository playerRepository;
    PrizeRepository prizeRepository;
    PlayerResultsRepository playerResultsRepository;
    LadderService ladderService;

    @BeforeEach
    void setUp() {
        LineStrategy lineStrategy = new CustomLineStrategy(List.of(Step.EMPTY));
        playerRepository = new PlayerRepository();
        prizeRepository = new PrizeRepository();
        playerResultsRepository = new PlayerResultsRepository();
        ladderService = new LadderService(lineStrategy, playerRepository, prizeRepository, playerResultsRepository);
    }

    @Test
    @DisplayName("사용자가 정상적으로 생성되어야 한다.")
    void createPlayers_success() {
        // given
        String[] playerNames = {"glen", "doggy"};

        // when
        ladderService.createPlayers(playerNames);

        // then
        assertThat(playerRepository.countBy())
                .isEqualTo(2);
        assertThat(playerRepository.findAll())
                .containsExactly(new Player("glen"), new Player("doggy"));
    }

    @Test
    @DisplayName("사용자의 이름이 중복되면 예외가 발생한다.")
    void createPlayers_duplicate() {
        // given
        String[] playerNames = {"glen", "glen", "glen"};

        // expect
        assertThatIllegalArgumentException().isThrownBy(() -> {
            ladderService.createPlayers(playerNames);
        }).withMessage("[ERROR] 중복된 이름이 있습니다.");
    }

    @Test
    @DisplayName("사용자가 13명을 초과하면 예외가 발생한다.")
    void createPlayers_overMaxPlayers() {
        // given
        String[] playerNames = {"1", "2", "3", "4", "5", "6", "7", "8", "9", "10", "11", "12", "13", "14"};

        // expect
        assertThatIllegalArgumentException().isThrownBy(() -> {
            ladderService.createPlayers(playerNames);
        }).withMessage("[ERROR] 사용자는 2명에서 13명까지 가능합니다.");
    }

    @Test
    @DisplayName("사용자가 2명 미만이면 예외가 발생한다.")
    void createPlayers_underMinPlayers() {
        // given
        String[] playerNames = {"glen"};

        // expect
        assertThatIllegalArgumentException().isThrownBy(() -> {
            ladderService.createPlayers(playerNames);
        }).withMessage("[ERROR] 사용자는 2명에서 13명까지 가능합니다.");
    }

    @Test
    @DisplayName("실행 결과가 정상적으로 생성되어야 한다.")
    void createPrizes_success() {
        // given
        playerRepository.saveAll(createPlayers(4));
        String[] input = {"꽝", "5000", "꽝", "3000"};

        // when
        ladderService.createPrizes(input);

        // then
        assertThat(prizeRepository.findAll())
                .containsExactly(
                        new Prize("꽝"),
                        new Prize("5000"),
                        new Prize("꽝"),
                        new Prize("3000")
                );
    }

    @Test
    @DisplayName("실행 결과의 갯수가 참여하는 인원과 같지 않으면 예외가 발생한다.")
    void createPrizes_notEqualsPlayersCount() {
        // given
        playerRepository.saveAll(createPlayers(3));
        String[] input = {"꽝", "5000", "꽝", "3000"};

        // expect
        assertThatIllegalArgumentException().isThrownBy(() -> {
            ladderService.createPrizes(input);
        }).withMessage("[ERROR] 실행 결과의 갯수와 참여할 사람이 같아야 합니다.");
    }


    @Test
    @DisplayName("사다리가 정상적으로 생성되어야 한다.")
    void playLadderGame_success() {
        // given
        playerRepository.saveAll(createPlayers(4));
        prizeRepository.saveAll(createPrizes(4));

        // when
        LadderResponse ladderResponse = ladderService.playLadderGame(6);
        List<List<Step>> lines = ladderResponse.getLines();

        // then
        assertThat(lines)
                .hasSize(6);
        assertThat(lines.get(0))
                .hasSize(3);
        assertThat(ladderResponse.getPlayerNames())
                .hasSize(4);
        assertThat(ladderResponse.getPrizeNames())
                .hasSize(4);
    }

    @Test
    @DisplayName("모든 플레이어의 결과가 정확히 반환되어야 한다.")
    void findAllPlayerResults_success() {
        // given
        ladderService.createPlayers(new String[]{"glen", "pobi", "bero"});
        ladderService.createPrizes(new String[]{"1000", "꽝", "5000"});

        // when
        ladderService.playLadderGame(3);

        // then
        List<PlayerResultResponse> results = ladderService.findAllPlayerResults();
        assertThat(results)
                .hasSize(3);
        assertThat(results.get(0).getPlayerPrize())
                .isEqualTo("1000");
        assertThat(results.get(1).getPlayerPrize())
                .isEqualTo("꽝");
        assertThat(results.get(2).getPlayerPrize())
                .isEqualTo("5000");
    }

    @Test
    @DisplayName("게임을 플레이하지 않으면 결과가 없어야 한다.")
    void findAllPlayerResults_notPlayGame() {
        // given
        ladderService.createPlayers(new String[]{"glen", "pobi", "bero"});
        ladderService.createPrizes(new String[]{"1000", "꽝", "5000"});

        // expect
        assertThat(ladderService.findAllPlayerResults())
                .isEmpty();
    }

    @Test
    @DisplayName("사용자의 이름으로 결과가 정확히 반환되어야 한다.")
    void findPlayerResultByName_success() {
        // given
        ladderService.createPlayers(new String[]{"glen", "pobi", "bero"});
        ladderService.createPrizes(new String[]{"1000", "꽝", "5000"});

        // when
        ladderService.playLadderGame(4);

        // then
        PlayerResultResponse result = ladderService.findPlayerResultByName("pobi");
        assertThat(result.getPlayerName())
                .isEqualTo("pobi");
        assertThat(result.getPlayerPrize())
                .isEqualTo("꽝");
    }

    @Test
    @DisplayName("사용자 이름으로 결과를 가져올 때 사용자가 없으면 예외가 발생한다.")
    void findPlayerResultByName_noPlayer() {
        // given
        ladderService.createPlayers(new String[]{"glen", "pobi", "bero"});
        ladderService.createPrizes(new String[]{"1000", "꽝", "5000"});

        // when
        ladderService.playLadderGame(4);

        // then
        assertThatIllegalArgumentException().isThrownBy(() -> {
            ladderService.findPlayerResultByName("mango");
        }).withMessage("[ERROR] 해당 참여자가 없습니다.");
    }

    @ParameterizedTest
    @ValueSource(ints = {2, 3, 11, 12})
    @DisplayName("사다리 게임을 플레이할 때 높이가 범위를 벗어나면 예외가 발생한다.")
    void playerLadderGame_heightOutOfRange(int input) {
        // given
        ladderService.createPlayers(new String[]{"glen", "pobi", "bero", "mango"});
        ladderService.createPrizes(new String[]{"1000", "꽝", "5000", "1000"});

        // expect
        assertThatIllegalArgumentException().isThrownBy(() -> {
            ladderService.playLadderGame(input);
        }).withMessage("[ERROR] 사다리의 높이는 사람 수보다 크거나, 사람 수의 두 배 보다 작아야 합니다.");
    }
}
