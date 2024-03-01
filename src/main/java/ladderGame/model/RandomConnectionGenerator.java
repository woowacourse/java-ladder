package ladderGame.model;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class RandomConnectionGenerator {

    public static List<ConnectionStatus> makeConnections(int playerCount) {
        Random random = new Random();
        List<ConnectionStatus> statuses = new ArrayList<>();
        for(int i = 0; i < playerCount; i++) {
            statuses.add(ConnectionStatus.of(random.nextBoolean()));
        }
        return statuses;
    }
}
