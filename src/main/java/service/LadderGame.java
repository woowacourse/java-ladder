package service;

import domain.ladder.Ladder;
import domain.ladder.LadderResult;
import domain.ladder.LadderResults;
import domain.player.Player;
import domain.player.Players;
import domain.player.Position;
import dto.GameResultDto;
import java.util.ArrayList;
import java.util.List;

public class LadderGame {

    private final Ladder ladder;
    private final Players players;
    private final LadderResults ladderResults;

    public LadderGame(Ladder ladder, Players players, LadderResults ladderResults) {
        this.ladder = ladder;
        this.players = players;
        this.ladderResults = ladderResults;
    }

    public boolean isPlayerExistByName(String name) {
        return players.containPlayerBySpecificName(name);
    }

    public List<GameResultDto> findAllPlayerResult() {
        List<GameResultDto> gameResultDtos = new ArrayList<>();

        for (Player player : players.getPlayers()) {
            Position position = player.move(ladder);
            LadderResult ladderResult = ladderResults.findResultByPosition(position);
            gameResultDtos.add(new GameResultDto(player.getName(), ladderResult.getResult()));
        }

        return gameResultDtos;
    }

    public LadderResult findSinglePlayerResultByName(String name) {
        Player findPlayer = players.findSpecificNamePlayer(name);
        Position position = findPlayer.move(ladder);

        return ladderResults.findResultByPosition(position);
    }
}
