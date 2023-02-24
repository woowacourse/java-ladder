package ladder.service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import ladder.domain.ladder.Ladder;
import ladder.domain.ladder.LadderMaker;
import ladder.domain.ladder.LadderProperty;
import ladder.domain.player.Name;
import ladder.domain.player.Player;
import ladder.domain.player.Players;
import ladder.domain.player.StartIndex;
import ladder.domain.result.Result;
import ladder.domain.result.ResultByPlayer;
import ladder.domain.result.Results;
import ladder.domain.result.Reward;

public class LadderGameMaker {

    public static LadderGame createLadderGame(List<String> names, List<String> results, int height) {
        Players generatedPlayers = new Players(generatePlayers(names));
        Results generatedResults = new Results(generateResults(results));
        LadderMaker ladderMaker = new LadderMaker(new LadderProperty(names.size() - 1, height));
        Ladder generatedLadder = ladderMaker.generate();
        ResultByPlayer generatedResultByPlayer = generateResultByPlayer(generatedPlayers, generatedLadder, generatedResults);

        return new LadderGame(generatedPlayers, generatedResults, generatedLadder, generatedResultByPlayer);
    }

    private static List<Player> generatePlayers(List<String> names) {
        List<Player> gamePlayers = new ArrayList<>();
        for (int generateIndex = 0; generateIndex < names.size(); generateIndex++) {
            Name name = new Name(names.get(generateIndex));
            StartIndex startIndex = new StartIndex(generateIndex);
            gamePlayers.add(new Player(name, startIndex));
        }
        return gamePlayers;
    }

    private static List<Result> generateResults(List<String> results) {
        List<Result> gameResults = new ArrayList<>();
        for (int generateIndex = 0; generateIndex < results.size(); generateIndex++) {
            Reward reward = new Reward(results.get(generateIndex), generateIndex);
            gameResults.add(new Result(reward));
        }
        return gameResults;
    }

    private static ResultByPlayer generateResultByPlayer(Players players, Ladder ladder, Results results) {
        Map<Player, Result> gameResultByPlayer = new HashMap<>();
        for (Player player : players.getPlayers()) {
            int rewardIndex = ladder.moveToEnd(player.getStartIndex());
            Result result = results.findResultByRewardIndex(rewardIndex);
            gameResultByPlayer.put(player, result);
        }
        return new ResultByPlayer(gameResultByPlayer);
    }
}
