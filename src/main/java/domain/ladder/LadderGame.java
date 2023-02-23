package domain.ladder;

import domain.player.Players;
import domain.result.Prizes;

import java.util.HashMap;
import java.util.Map;

public class LadderGame {

    private final Map<String, String> result;

    private LadderGame(Map<String, String> result) {
        this.result = result;
    }

    public static LadderGame of(Players players, Prizes prizes, Ladder ladder) {
        validate(players, prizes);

        HashMap<String, String> gameResult = start(players, prizes, ladder);
        return new LadderGame(gameResult);
    }

    public String findByName(String name) {
        if (!result.containsKey(name)) {
            throw new IllegalArgumentException("이름과 일치하는 참가자가 존재하지 않습니다.");
        }
        return result.get(name);
    }

    public boolean hasContain(String name) {
        return result.containsKey(name);
    }

    private static HashMap<String, String> start(Players players, Prizes prizes, Ladder ladder) {
        HashMap<String, String> gameResult = new HashMap<>();
        for (int playerIndex = 0; playerIndex < players.getPlayers().size(); playerIndex++) {
            String playerName = players.findNameByIndex(playerIndex);

            int playerLastPosition = ladder.move(playerIndex);
            String prize = prizes.findByIndex(playerLastPosition);
            gameResult.put(playerName, prize);
        }
        return gameResult;
    }

    private static void validate(Players players, Prizes prizes) {
        if (players.getPlayers().size() != prizes.getPrizes().size()) {
            throw new IllegalArgumentException("참가자 수와 결과 수는 일치해야 합니다.");
        }
    }

    public Map<String, String> findAllResults() {
        return this.result;
    }

}
