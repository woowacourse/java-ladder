package domain;

import java.util.LinkedHashMap;
import java.util.Map;

public class LadderGame {

    private final Ladder ladder;
    private final Results unsortedResults;
    private final Map<Player, Result> playersAndResults;

    public LadderGame(Ladder ladder, Results unsortedResults) {
        this.ladder = ladder;
        this.unsortedResults = unsortedResults;
        this.playersAndResults = new LinkedHashMap<>();
    }
    public Result getResultOf(Player player) {
        if (isResultAlreadyExist(player)) {
            return playersAndResults.get(player);
        }
        Position resultPosition = ladder.getResultPositionOf(player.position());
        Result result = unsortedResults.get(resultPosition.value());
        playersAndResults.put(player, result);
        return result;
    }

    private boolean isResultAlreadyExist(Player player) {
        return playersAndResults.containsKey(player);
    }

}
