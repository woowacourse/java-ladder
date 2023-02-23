package ladder.service;

import static java.util.stream.Collectors.*;

import java.util.Arrays;
import java.util.stream.IntStream;
import ladder.domain.Height;
import ladder.domain.Ladder;
import java.util.ArrayList;
import java.util.List;
import ladder.domain.Player;
import ladder.domain.PlayerResult;
import ladder.domain.PlayerResults;
import ladder.domain.Players;
import ladder.domain.Prize;
import ladder.domain.Prizes;

public class LadderService {
    private final LineStrategy lineStrategy;

    public LadderService(LineStrategy lineStrategy) {
        this.lineStrategy = lineStrategy;
    }

    public Ladder createLadder(Height height, Players players) {
        return IntStream.range(0, height.getHeight())
                .mapToObj(v -> lineStrategy.generate(players.getPlayersCount()))
                .collect(collectingAndThen(toList(), lines -> new Ladder(lines, players)));
    }

    public Players createPlayers(String[] playerNames) {
        return Arrays.stream(playerNames)
                .map(Player::new)
                .collect(collectingAndThen(toList(), Players::new));
    }

    public Prizes createPrizes(String[] prizesNames, Players players) {
        return Arrays.stream(prizesNames)
                .map(Prize::new)
                .collect(collectingAndThen(toList(), prizes -> new Prizes(prizes, players)));
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
