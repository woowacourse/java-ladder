package ladder.domain;

import java.util.List;
import ladder.domain.dto.LadderInfoDto;
import ladder.domain.dto.PlayerResultDto;
import ladder.domain.item.Result;
import ladder.domain.ladder.ConnectionJudgement;
import ladder.domain.ladder.Ladder;
import ladder.domain.player.Players;

/**
 * 이 클래스는 사다리 게임에 대한 실제 로직을 담당하는 클래스 입니다
 */
public class LadderGameImpl implements LadderGame {

    private final ConnectionJudgement connectionJudgement;
    private final LadderRepository ladderRepository;

    public LadderGameImpl(ConnectionJudgement connectionJudgement) {
        this.connectionJudgement = connectionJudgement;
        ladderRepository = new LadderRepository();
    }

    @Override
    public void initializePlayers(List<String> playerNames) {
        ladderRepository.put(Players.class, new Players(playerNames));
    }

    @Override
    public void initializeResults(List<String> resultNames) {
        ladderRepository.put(Result.class, new Result(resultNames));
    }

    @Override
    public void initializeLadder(int height) {
        Players players = ladderRepository.get(Players.class);
        ladderRepository.put(Ladder.class, generateLadder(height, players));

    }

    private Ladder generateLadder(int height, Players players) {
        return Ladder.of(players.size(), height, connectionJudgement);
    }

    @Override
    public LadderInfoDto getLadderInfo() {
        return null;
    }

    @Override
    public PlayerResultDto calculateResult() {
        return null;
    }
}
