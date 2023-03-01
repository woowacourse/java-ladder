package service;

import domain.ladder.Ladder;
import domain.ladder.LadderPrize;
import domain.ladder.LadderPrizes;
import domain.player.Player;
import domain.player.Players;
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

    public boolean containName(String name) {
        return players.containName(name);
    }

    public List<GameResultDto> findResults() {
        List<GameResultDto> gameResultDtos = new ArrayList<>();

        for (Player player : players.getPlayers()) {
            ladder.play(player);
            LadderPrize prize = ladderPrizes.findPrizeByPosition(player.getPosition());
            gameResultDtos.add(GameResultDto.of(player, prize));
        }

        return gameResultDtos;
    }

    public LadderPrize findResultByName(String name) {
        Player findPlayer = players.findPlayerByName(name);
        ladder.play(findPlayer);

        return ladderPrizes.findPrizeByPosition(findPlayer.getPosition());
    }
}
