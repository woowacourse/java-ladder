package ladder.domain;

import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;
import ladder.common.LadderGame;

/**
 * 이 클래스는 사다리 게임에 대한 실제 로직을 담당하는 클래스 입니다
 */
public class LadderGameController implements LadderGame {

    private final ConnectionJudgement connectionJudgement;
    private final LadderRepository ladderRepository;

    public LadderGameController(ConnectionJudgement connectionJudgement, LadderRepository ladderRepository) {
        this.connectionJudgement = connectionJudgement;
        this.ladderRepository = ladderRepository;
    }

    @Override
    public void initializePlayers(List<String> playerNames) {
        ladderRepository.put(Players.class, new Players(playerNames));
    }

    @Override
    public void initializeResults(List<String> resultNames) {
        int playerCount = ladderRepository.get(Players.class)
                .size();
        ladderRepository.put(Result.class, new Result(resultNames, playerCount));
    }

    @Override
    public void initializeLadder(int height) {
        Players players = ladderRepository.get(Players.class);
        ladderRepository.put(Ladder.class, generateLadder(height, players));

    }

    @Override
    public List<String> getPlayerNames() {
        return ladderRepository.get(Players.class)
                .getPlayerNames();
    }

    @Override
    public List<List<Boolean>> getLadderRows() {
        return ladderRepository.get(Ladder.class)
                .getRows();
    }

    @Override
    public List<String> getResultNames() {
        return ladderRepository.get(Result.class)
                .getNames();
    }

    private Ladder generateLadder(int height, Players players) {
        return Ladder.of(players.size(), height, connectionJudgement);
    }

    @Override
    public Map<String, String> calculateResult() {
        Players players = ladderRepository.get(Players.class);
        Ladder ladder = ladderRepository.get(Ladder.class);
        Result resultItems = ladderRepository.get(Result.class);
        Map<String, Position> playerNameAndResultPosition = players.calculateResult(ladder);
        //그냥 바로 collect toMap 만 호출하면 순서가 보장이 되지 않아서 LinkedHashMap 으로 감싸준다
        return playerNameAndResultPosition.entrySet()
                .stream()
                .collect(Collectors.toMap(
                        Map.Entry::getKey,
                        entry -> resultItems.findByPosition(entry.getValue()),
                        (x, y) -> y,
                        LinkedHashMap::new));
    }
}
