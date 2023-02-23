package ladder.service;

import static java.util.stream.Collectors.*;

import java.util.Arrays;
import ladder.domain.Height;
import ladder.domain.Ladder;
import ladder.domain.Line;
import java.util.ArrayList;
import java.util.List;
import ladder.domain.Player;
import ladder.domain.PlayerResult;
import ladder.domain.PlayerResults;
import ladder.domain.Players;
import ladder.domain.Prize;
import ladder.domain.Prizes;

public class LadderService {
    private static final String PLAYERS_STRING_DELIMITER = ",";
    private static final String RESULTS_STRING_DELIMITER = ",";

    private final LineStrategy lineStrategy;

    public LadderService(LineStrategy lineStrategy) {
        this.lineStrategy = lineStrategy;
    }

    public Ladder createLadder(Height height, Players players) {
        List<Line> lines = new ArrayList<>();
        for (int i = 0; i < height.getHeight(); i++) {
            lines.add(lineStrategy.generate(players.getPlayersCount()));
        }
        return new Ladder(lines, players);
    }

    public Players createPlayers(String namesInput) {
        String[] playerNames = namesInput.split(PLAYERS_STRING_DELIMITER);
        return Arrays.stream(playerNames)
                .map(Player::new)
                .collect(collectingAndThen(toList(), Players::new));
    }

    public Prizes createPrizes(String resultsInput, Players players) {
        String[] resultsStrings = resultsInput.split(RESULTS_STRING_DELIMITER);
        List<Prize> prizes = Arrays.stream(resultsStrings)
                .map(Prize::new)
                .collect(toList());
        return new Prizes(prizes, players);
    }

    public PlayerResults createPlayerResults(Players players, Ladder ladder, Prizes prizes) {
        List<Prize> playerPrizes = players.getPlayers().stream()
                .map(players::findIndexByPlayer)
                .map(ladder::getLadderIndexResult)
                .map(prizes::findPrizeByIndex)
                .collect(toList());
        return combinePlayerResults(players.getPlayers(), playerPrizes);
    }

    private PlayerResults combinePlayerResults(List<Player> players, List<Prize> prizes) {
        List<PlayerResult> resultList = new ArrayList<>();
        for (int i = 0; i < players.size(); i++) {
            resultList.add(new PlayerResult(players.get(i), prizes.get(i)));
        }
        return new PlayerResults(resultList);
    }
}
