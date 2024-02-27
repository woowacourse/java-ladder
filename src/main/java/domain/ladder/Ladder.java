package domain.ladder;

import domain.bridge.BridgeGenerator;
import domain.player.PlayerNames;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Ladder {
    private final List<Floor> floors;
    private final PlayerNames playerNames;
    private final LadderResults ladderResults;

    private Ladder(List<Floor> floors, PlayerNames playerNames, LadderResults ladderResults) {
        this.floors = List.copyOf(floors);
        this.playerNames = playerNames;
        this.ladderResults = ladderResults;
    }

    public static Ladder create(LadderHeight height, PlayerNames playerNames, LadderResults ladderResults, BridgeGenerator bridgeGenerator) {
        List<Floor> floors = new ArrayList<>();
        for (int i = 0; i < height.getValue(); i++) {
            List<LadderBridge> bridges = bridgeGenerator.generate(calculatePointCount(playerNames));
            floors.add(new Floor(bridges));
        }

        return new Ladder(floors, playerNames, ladderResults);
    }

    private static int calculatePointCount(PlayerNames playerNames) {
        return playerNames.getCount() - 1;
    }

    public Map<String, String> findAllPlayersLadderResultValue() {
        Map<String, String> playersLadderResult = new HashMap<>();
        for (int i = 0; i < playerNames.getCount(); i++) {
            String playerName = playerNames.getNameOfIndex(i);
            playersLadderResult.put(playerName, findPlayerLadderResultValueByName(playerName));
        }

        return playersLadderResult;
    }

    public Map<String, String> findSinglePlayerLadderResultValue(String playerName) {
        Map<String, String> playersLadderResult = new HashMap<>();
        playersLadderResult.put(playerName, findPlayerLadderResultValueByName(playerName));

        return playersLadderResult;
    }

    private String findPlayerLadderResultValueByName(String playerName) {
        int playerPosition = playerNames.getIndexOfName(playerName);

        for (Floor floor : floors) {
            BridgeDirection direction = floor.getBridgeAroundAt(playerPosition);
            playerPosition += direction.getValue();
        }
        return ladderResults.getValueByIndex(playerPosition);
    }

    public List<Floor> getFloors() {
        return floors;
    }

    public String getLadderResultByIndex(int index) {
        return ladderResults.getValueByIndex(index);
    }

    public int getResultSize() {
        return ladderResults.size();
    }
}
