package ladder.domain;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

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

    private ResultByPlayer generateResultByPlayer() {
        Map<Player, Result> gameResultByPlayer = new HashMap<>();
        for (Player player : players.getPlayers()) {
            int rewardIndex = ladder.moveToEnd(player.getStartIndex());
            Result result = results.findResultByRewardIndex(rewardIndex);
            gameResultByPlayer.put(player, result);
        }
        return new ResultByPlayer(gameResultByPlayer);
    }

    public String findResultByPlayerName(String playerName) {
        Player findPlayer = players.findByPlayerName(playerName);
        Result findResult = resultByPlayer.findResultByPlayer(findPlayer);
        return findResult.getReward();
    }

    public Map<String, String> findAllResultByPlayerName() {
        Map<Player, Result> allResultByPlayer = resultByPlayer.findAll();
        return allResultByPlayer.entrySet().stream()
                .collect(Collectors.toMap(
                        entry -> entry.getKey().getName(),
                        entry -> entry.getValue().getReward()
                ));
    }

    public List<Line> getLines() {
        return ladder.getLines();
    }
}
