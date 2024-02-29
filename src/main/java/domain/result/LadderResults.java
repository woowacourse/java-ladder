package domain.result;

import domain.ladder.Floor;
import domain.ladder.Ladder;
import domain.player.Players;
import domain.result.message.ResultExceptionMessage;
import java.util.List;

public class LadderResults {
    private final Players players;
    private final Ladder ladder;
    private final List<LadderResult> results;

    public LadderResults(final Players players, final Ladder ladder, final List<LadderResult> results) {
        validateTotalResults(players, results);
        this.players = players;
        this.ladder = ladder;
        this.results = List.copyOf(results);
    }

    private void validateTotalResults(final Players players, final List<LadderResult> results) {
        if (results.size() != players.getPlayerCount()) {
            throw new IllegalArgumentException(ResultExceptionMessage.TOTAL_RESULTS_SIZE);
        }
    }

    public String getPlayerNameOfIndex(int index) {
        return players.getNameOfIndex(index);
    }

    public int getPlayerCount() {
        return players.getPlayerCount();
    }

    public List<Floor> getFloors() {
        return ladder.getFloors();
    }

    public Ladder getLadder() {
        return ladder;
    }

    public String getLadderResultOfIndex(int index) {
        return results.get(index).getResult();
    }

    public int getLadderResultsSize() {
        return results.size();
    }

    public boolean isParticipantPlayer(final String playerName) {
        return players.isParticipate(playerName);
    }

    // TODO : 위치와 이름을 갖고 있는 Player객체를 만든 뒤 BFS로 좌우만 탐색해 마지막 지점의 위치로 갱신해서 사다리 결과와 동일 index의 결과를 찾아낸다?
//    public String findResultOf(final String playerName) {
//        Queue<String> q = new LinkedList<>();
//        q.add(playerName);
//
//    }
}
