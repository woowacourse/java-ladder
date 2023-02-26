package ladder.service;

import static java.util.stream.Collectors.*;

import java.util.Arrays;
import java.util.stream.IntStream;
import ladder.domain.Height;
import ladder.domain.Ladder;
import java.util.List;
import ladder.domain.Player;
import ladder.domain.PlayerResult;
import ladder.domain.Prize;
import ladder.dto.LadderResponse;
import ladder.dto.PlayerResultResponse;
import ladder.repository.PlayerRepository;
import ladder.repository.PlayerResultsRepository;
import ladder.repository.PrizeRepository;

public class LadderService {
    private static final int MIN_PLAYERS = 2;
    private static final int MAX_PLAYERS = 13;

    private final LineStrategy lineStrategy;
    private final PlayerRepository playerRepository;
    private final PrizeRepository prizeRepository;
    private final PlayerResultsRepository playerResultsRepository;

    public LadderService(LineStrategy lineStrategy, PlayerRepository playerRepository, PrizeRepository prizeRepository,
                         PlayerResultsRepository playerResultsRepository) {
        this.lineStrategy = lineStrategy;
        this.playerRepository = playerRepository;
        this.prizeRepository = prizeRepository;
        this.playerResultsRepository = playerResultsRepository;
    }

    public void createPlayers(String[] playerNames) {
        List<Player> players = Arrays.stream(playerNames)
                .map(Player::new)
                .collect(toList());
        validatePlayers(players);
        playerRepository.saveAll(players);
    }

    private void validatePlayers(List<Player> players) {
        validateSize(players);
        validateDuplicate(players);
    }

    private void validateSize(List<Player> players) {
        if (isProperPlayerLength(players)) {
            throw new IllegalArgumentException(
                    String.format("[ERROR] 사용자는 %d명에서 %d명까지 가능합니다.", MIN_PLAYERS, MAX_PLAYERS));
        }
    }

    private boolean isProperPlayerLength(List<Player> players) {
        return MAX_PLAYERS < players.size() || players.size() < MIN_PLAYERS;
    }

    private void validateDuplicate(List<Player> players) {
        long uniquePlayersCount = players.stream()
                .distinct()
                .count();
        if (uniquePlayersCount != players.size()) {
            throw new IllegalArgumentException("[ERROR] 중복된 이름이 있습니다.");
        }
    }

    public void createPrizes(String[] prizesNames) {
        validatePlayerCount(prizesNames.length);
        List<Prize> prizes = Arrays.stream(prizesNames)
                .map(Prize::new)
                .collect(toList());
        prizeRepository.saveAll(prizes);
    }

    private void validatePlayerCount(int resultsCount) {
        if (resultsCount != playerRepository.countBy()) {
            throw new IllegalArgumentException("[ERROR] 실행 결과의 갯수와 참여할 사람이 같아야 합니다.");
        }
    }

    public LadderResponse playLadderGame(int heightInput) {
        List<Player> players = playerRepository.findAll();
        Height height = createHeight(heightInput, players.size());
        Ladder ladder = createLadder(height, players.size());
        createPlayerResult(ladder);
        return LadderResponse.of(players, ladder, prizeRepository.findAll());
    }

    private Height createHeight(int heightInput, int playersCount) {
        return new Height(heightInput, playersCount);
    }

    private Ladder createLadder(Height height, int playersCount) {
        return IntStream.range(0, height.getValue())
                .mapToObj(v -> lineStrategy.generate(playersCount))
                .collect(collectingAndThen(toList(), lines -> new Ladder(lines, playersCount)));
    }

    private void createPlayerResult(Ladder ladder) {
        List<Player> players = playerRepository.findAll();
        List<Prize> playerPrizes = players.stream()
                .map(playerRepository::findIndexByPlayer)
                .map(ladder::getLadderIndexResult)
                .map(prizeRepository::findByIndex)
                .collect(toList());
        savePlayerResult(players, playerPrizes);
    }

    private void savePlayerResult(List<Player> players, List<Prize> prizes) {
        for (int i = 0; i < players.size(); i++) {
            playerResultsRepository.save(new PlayerResult(players.get(i), prizes.get(i)));
        }
    }

    public PlayerResultResponse findPlayerResultByName(String playerName) {
        PlayerResult playerResult = playerResultsRepository.findByPlayerName(playerName);
        return PlayerResultResponse.of(playerResult);
    }

    public List<PlayerResultResponse> findAllPlayerResults() {
        List<PlayerResult> playerResults = playerResultsRepository.findAll();
        return playerResults.stream()
                .map(PlayerResultResponse::of)
                .collect(toList());
    }
}
