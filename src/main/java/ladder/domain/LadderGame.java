package ladder.domain;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class LadderGame {

    private final Players players;
    private final Results results;
    private final Ladder ladder;
    private final ResultByPlayer resultByPlayer;

    public LadderGame(List<String> names, List<String> results, int height) {
        this.players = new Players(generatePlayers(names));
        this.results = new Results(generateResults(results));
        LadderMaker ladderMaker = new LadderMaker(new LadderProperty(names.size() - 1, height));

        this.ladder = ladderMaker.generate();
        this.resultByPlayer = generateResultByPlayer();
    }

    private List<Player> generatePlayers(List<String> names) {
        List<Player> gamePlayers = new ArrayList<>();
        for (int generateIndex = 0; generateIndex < names.size(); generateIndex++) {
            Name name = new Name(names.get(generateIndex));
            StartIndex startIndex = new StartIndex(generateIndex);
            gamePlayers.add(new Player(name, startIndex));
        }
        return gamePlayers;
    }

    private List<Result> generateResults(List<String> results) {
        List<Result> gameResults = new ArrayList<>();
        for (int generateIndex = 0; generateIndex < results.size(); generateIndex++) {
            Reward reward = new Reward(results.get(generateIndex), generateIndex);
            gameResults.add(new Result(reward));
        }
        return gameResults;
    }

    public ResultByPlayer generateResultByPlayer() {
        Map<Player, Result> gameResultByPlayer = new HashMap<>();
        for (Player player : players.getPlayers()) {
            int rewardIndex = ladder.moveToEnd(player.getStartIndex());
            Result result = results.findResultByRewardIndex(rewardIndex);
            gameResultByPlayer.put(player, result);
        }
        return new ResultByPlayer(gameResultByPlayer);
    }

    public Result findResultByPlayerName(String playerName) {
        Player findPlayer = players.findByPlayerName(playerName);
        return resultByPlayer.findResultByPlayer(findPlayer);
    }

    public List<Line> getLines() {
        return ladder.getLines();
    }
}
