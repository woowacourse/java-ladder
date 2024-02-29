package domain.ladder;

import domain.bridge.BridgeGenerator;
import domain.player.PlayerNames;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Ladder {
    private final List<Floor> floors;

    private Ladder(final List<Floor> floors) {
        this.floors = List.copyOf(floors);
    }

    public static Ladder create(final LadderHeight height, final int playerCount,
                                final BridgeGenerator bridgeGenerator) {
        List<Floor> floors = new ArrayList<>();
        for (int i = 0; i < height.getValue(); i++) {
            List<LadderBridge> bridges = bridgeGenerator.generate(calculatePointCount(playerCount));
            floors.add(new Floor(bridges));
        }

        return new Ladder(floors);
    }

    private static int calculatePointCount(final int playerCount) {
        return playerCount - 1;
    }

    public Map<String, String> findAllPlayersLadderResultValue(final PlayerNames playerNames,
                                                               final LadderResults results) {
        Map<String, String> playersLadderResult = new HashMap<>();

        Map<Integer, String> playerSequenceToName = playerNames.getPlayerSequenceAndName();
        for (int sequence : playerSequenceToName.keySet()) {
            playersLadderResult.put(playerSequenceToName.get(sequence), findPlayerLadderResultValueByName(sequence, results));
        }
        return playersLadderResult;
    }

    public Map<String, String> findSinglePlayerLadderResultValue(final String playerName, final PlayerNames playerNames,
                                                                 final LadderResults results) {
        Map<String, String> playersLadderResult = new HashMap<>();

        int indexOfName = playerNames.getIndexOfName(playerName);
        String playerLadderResult = findPlayerLadderResultValueByName(indexOfName, results);
        playersLadderResult.put(playerName, playerLadderResult);

        return playersLadderResult;
    }

    private String findPlayerLadderResultValueByName(int playerPosition,
                                                     final LadderResults ladderResults) {
        for (Floor floor : floors) {
            BridgeDirection direction = floor.getBridgeAroundAt(playerPosition);
            playerPosition += direction.getValue();
        }
        return ladderResults.getValueByIndex(playerPosition);
    }

    public List<Floor> getFloors() {
        return floors;
    }
}
