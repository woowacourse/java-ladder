package ladderGame.model;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.stream.Stream;

public class Line {
    private final List<ConnectionStatus> connectionStatuses;

    public Line(int number) {
        StatusBuilder statusBuilder = new StatusBuilder();
        for (int i = 0; i < number; i++) {
            statusBuilder.add();
        }

        connectionStatuses = statusBuilder.build();
    }

    public List<ConnectionStatus> getConnectionStatuses() {
        return new ArrayList<>(connectionStatuses);
    }

}
