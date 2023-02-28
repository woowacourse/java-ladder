package domain;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import domain.generator.ConnectionGenerator;

public class Line {

    private final List<Boolean> connections;

    public Line(final int numberOfPlayer, final ConnectionGenerator connectionGenerator) {
        this.connections = makeConnections(numberOfPlayer, connectionGenerator);
    }

    private List<Boolean> makeConnections(final int numberOfPlayer, final ConnectionGenerator connectionGenerator) {
        List<Boolean> connections = new ArrayList<>();
        int numberOfConnection = numberOfPlayer - 1;

        for (int i = 0; i < numberOfConnection; i++) {
            connections.add(isConnectionValidWithoutOverLap(connections, i, connectionGenerator.generate()));
        }

        return connections;
    }

    private boolean isConnectionValidWithoutOverLap(final List<Boolean> connections, final int index,
                                                    final boolean isExisting) {
        if (index == 0) {
            return isExisting;
        }
        if (connections.get(index - 1) && isExisting) {
            return false;
        }
        return isExisting;
    }

    public Position move(final Position position) {
        if (isLeftConnectionExist(position)) {
            return position.moveLeft();
        }
        if (isRightConnectionExist(position)) {
            return position.moveRight();
        }
        return position;
    }

    private boolean isLeftConnectionExist(final Position position) {
        return (position.getValue() != 0) && connections.get(position.moveLeft().getValue());
    }

    private boolean isRightConnectionExist(final Position position) {
        return (position.getValue() != connections.size()) && connections.get(position.getValue());
    }

    public List<Boolean> getConnections() {
        return Collections.unmodifiableList(this.connections);
    }
}
