package ladderGame.model;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class LadderGenerator {

    public static Ladder makeLadder(int maxHeight, int playerCount) {
        List<Line> ladder = new ArrayList<>();
        for(int i = 0; i < maxHeight; i++) {
            ladder.add(makeLine(playerCount));
        }

        return new Ladder(ladder);
    }

    private static Line makeLine(int playerCount) {
        List<ConnectionStatus> connectionStatuses = new ArrayList<>();
        connectionStatuses.add(decideConnectionStatus());
        for (int i = 1; i <  playerCount- 1; i++) {
            connectionStatuses.add(makeConnectionStatus(connectionStatuses.get(i - 1)));
        }

        return new Line(connectionStatuses);
    }

    private static ConnectionStatus makeConnectionStatus(ConnectionStatus connectionStatus) {
        if (connectionStatus == ConnectionStatus.DISCONNECTION) {
            return decideConnectionStatus();
        }
        return ConnectionStatus.DISCONNECTION;
    }

    private static ConnectionStatus decideConnectionStatus() {
        if (new Random().nextBoolean()) {
            return ConnectionStatus.CONNECTION;
        }
        return ConnectionStatus.DISCONNECTION;

    }
}
