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

//TODO: 테스트 만들기
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
            Position position = player.move(ladder);
            LadderPrize prize = ladderPrizes.findPrizeByPosition(position);
            gameResultDtos.add(GameResultDto.of(player, prize));
        }

        return gameResultDtos;
    }

    public LadderPrize findResultByName(String name) {
        Player findPlayer = players.findPlayerByName(name);
        Position position = findPlayer.move(ladder);

        return ladderPrizes.findPrizeByPosition(position);
    }
}
