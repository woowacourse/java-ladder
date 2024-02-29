package domain;

import domain.ladder.Ladder;
import domain.ladder.Row;
import domain.ladder.Step;
import domain.player.Player;
import domain.player.Players;
import domain.prize.Prize;
import domain.prize.Prizes;
import domain.result.PlayersPrize;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

public class LadderGame {
    private final Ladder ladder;
    private final Players players;
    private final Prizes prizes;

    public LadderGame(final Ladder ladder, final Players players, final Prizes prizes) {
        this.ladder = ladder;
        this.players = players;
        this.prizes = prizes;
    }

    public PlayersPrize getPlayersPrize() {
        Map<Player, Prize> playersPrize = new LinkedHashMap<>();

        for (int index = 0; players.isCountMoreThan(index); index++) {
            Player player = players.findByIndex(index);
            int resultIndex = playLadder(index);
            Prize prize = prizes.findByIndex(resultIndex);

            playersPrize.put(player, prize);
        }

        return new PlayersPrize(playersPrize);
    }

    private int playLadder(int currentIndex) {
        for (Row row : ladder.getRows()) {
            currentIndex = playRow(currentIndex, row);
        }
        return currentIndex;
    }

    // TODO: 각 라인에서의 위치 계산은 Line에게 역할을 부여해주는 것이 어떨까요?
    // TODO : 이부분의 객체분리 장,단점 점검
    // toInt로 하네? 이건 괜찮나?
    private int playRow(int currentIndex, Row row) {
        List<Step> steps = row.getSteps();
        if (steps.get(currentIndex).isExist()) {
            return currentIndex + 1;
        }
        if (currentIndex > 0 && steps.get(currentIndex - 1).isExist()) {
            return currentIndex - 1;
        }
        return currentIndex;
    }
}
