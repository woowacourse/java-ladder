package ladder.domain.creator;

import ladder.domain.Connection;
import ladder.domain.Line;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.concurrent.ThreadLocalRandom;
import java.util.stream.IntStream;

public class RandomLineCreator {
    public Line create(int width) {
        List<Connection> randomConnections = new ArrayList<>(Collections.nCopies(width, Connection.EMPTY));

        for (int index : shuffleOrder(width)) {
            placeRandomScaffold(randomConnections, index);
        }

        return new Line(randomConnections);
    }

    private List<Integer> shuffleOrder(int width) {
        List<Integer> order = new ArrayList<>(IntStream.range(0, width)
                .boxed()
                .toList());
        Collections.shuffle(order);

        return order;
    }

    private void placeRandomScaffold(List<Connection> randomConnections, int index) {
        if (isLeftExist(randomConnections, index) || isRightExist(randomConnections, index)) {
            return;
        }

        List<Connection> connections = Arrays.stream(Connection.values())
                .toList();
        Connection randomConnection = connections.get(ThreadLocalRandom.current().nextInt(connections.size()));

        randomConnections.set(index, randomConnection);
    }

    private boolean isLeftExist(List<Connection> randomConnections, int index) {
        return index - 1 >= 0 && Connection.RUNG.equals(randomConnections.get(index - 1));
    }

    private boolean isRightExist(List<Connection> randomConnections, int index) {
        return index + 1 < randomConnections.size() && Connection.RUNG.equals(randomConnections.get(index + 1));
    }
}
