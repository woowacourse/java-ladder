package service;

import domain.ladder.Ladder;
import domain.ladder.LadderPrize;
import domain.ladder.LadderPrizes;
import domain.player.Player;
import domain.player.Players;
import domain.player.Position;
import dto.GameResultDto;
import java.util.ArrayList;
import java.util.List;

public class LadderGame {

    private final Ladder ladder;
    private final Players players;
    private final LadderPrizes ladderPrizes;

    public LadderGame(Ladder ladder, Players players, LadderPrizes ladderPrizes) {
        this.ladder = ladder;
        this.players = players;
        this.ladderPrizes = ladderPrizes;
    }

    public boolean isPlayerExistByName(String name) {
        return players.containPlayerBySpecificName(name);
    }

    public List<GameResultDto> findAllPlayerResult() {
        List<GameResultDto> gameResultDtos = new ArrayList<>();

        for (Player player : players.getPlayers()) {
            Position position = player.move(ladder);
            LadderPrize prize = ladderPrizes.findResultByPosition(position);
            gameResultDtos.add(new GameResultDto(player.getName(), prize.getPrize()));
        }

        return gameResultDtos;
    }

    public LadderPrize findSinglePlayerResultByName(String name) {
        Player findPlayer = players.findSpecificNamePlayer(name);
        Position position = findPlayer.move(ladder);

        return ladderPrizes.findResultByPosition(position);
    }
}
