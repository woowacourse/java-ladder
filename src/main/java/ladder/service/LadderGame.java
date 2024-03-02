package ladder.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import ladder.model.Ladder;
import ladder.model.Line;
import ladder.model.Players;

public class LadderGame {
    private final Players players;
    private final List<String> rewards;
    private final Ladder ladder;

    private LadderGame(Players ladderPlayers, List<String> rewards, Ladder ladder) {
        this.players = ladderPlayers;
        this.rewards = rewards;
        this.ladder = ladder;
    }

    public static LadderGame from(Players ladderPlayers, List<String> rewards, Ladder ladder) {
        validate(ladderPlayers, rewards, ladder);
        return new LadderGame(ladderPlayers, rewards, ladder);
    }

    private static void validate(Players players, List<String> rewards, Ladder ladder) {
        if (playerAndLadderDoesNotMatch(players, ladder)) {
            throw new IllegalArgumentException("참여자의 수와 사다리의 폭이 일치하지 않습니다.");
        }
        if (playerAndRewardDoesNotMatch(players, rewards)) {
            throw new IllegalArgumentException("참여자의 수와 실행 결과의 수가 일치하지 않습니다.");
        }
    }

    private static boolean playerAndLadderDoesNotMatch(Players players, Ladder ladder) {
        return players.getSize() != ladder.getLadder().get(0).size();
    }

    private static boolean playerAndRewardDoesNotMatch(Players players, List<String> rewards) {
        return players.getSize() != rewards.size();
    }

    public Map<String, String> play() {
        List<String> position = new ArrayList<>(players.getPlayerNames());

        for (Line line : ladder.getLadder()) {
            position = line.climbDown(position);
        }
        return createGameResult(position);
    }

    private Map<String, String> createGameResult(List<String> finalPosition) {
        return IntStream.range(0, finalPosition.size())
                .boxed()
                .collect(Collectors.toMap(finalPosition::get, rewards::get));
    }

    public List<String> getPlayerNames() {
        return players.getPlayerNames();
    }

    public List<String> getRewards() {
        return rewards;
    }
}
