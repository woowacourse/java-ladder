package ladder.service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import ladder.domain.ladder.Ladder;
import ladder.domain.ladder.LadderMaker;
import ladder.domain.ladder.LadderProperty;
import ladder.domain.ladder.Line;
import ladder.domain.player.Name;
import ladder.domain.player.Player;
import ladder.domain.player.Players;
import ladder.domain.player.StartIndex;
import ladder.domain.result.Result;
import ladder.domain.result.ResultByPlayer;
import ladder.domain.result.Results;
import ladder.domain.result.Reward;

public class LadderGame {

    private static final String RESULT_SIZE_NOT_MATCH_PLAYER_SIZE_ERROR_MESSAGE = "[ERROR] 실행 결과의 수는 참여자의 수와 같아야합니다.";

    private final Players players;
    private final Results results;
    private final Ladder ladder;
    private final ResultByPlayer resultByPlayer;

    public LadderGame(Players players, Results results, Ladder ladder, ResultByPlayer resultByPlayer) {
        this.players = players;
        this.results = results;
        validateResultsSize();
        this.ladder = ladder;
        this.resultByPlayer = resultByPlayer;
    }

    public void validateResultsSize() {
        if (isNotEqualResultsSizeToPlayersSize()) {
            throw new IllegalArgumentException(RESULT_SIZE_NOT_MATCH_PLAYER_SIZE_ERROR_MESSAGE);
        }
    }

    private boolean isNotEqualResultsSizeToPlayersSize() {
        return results.getSize() != players.getSize();
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

    public List<String> getPlayerNames() {
        List<Player> receivedPlayers = players.getPlayers();
        return receivedPlayers.stream()
                .map(Player::getName)
                .collect(Collectors.toUnmodifiableList());
    }

    public List<String> getResults() {
        List<Result> receivedResults = results.getResults();
        return receivedResults.stream()
                .map(Result::getReward)
                .collect(Collectors.toUnmodifiableList());
    }

    public List<Line> getLines() {
        return ladder.getLines();
    }
}
