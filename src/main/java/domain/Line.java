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

        connections.add(connectionGenerator.generate());
        makeOtherConnections(connectionGenerator, connections, numberOfConnection);

        return connections;
    }

    private void makeOtherConnections(final ConnectionGenerator connectionGenerator, final List<Boolean> connections,
                                      final int numberOfPoint) {
        for (int i = 1; i < numberOfPoint; i++) {
            connections.add(makeConnectionExceptFirst(connections, i, connectionGenerator.generate()));
        }
    }

    private boolean makeConnectionExceptFirst(final List<Boolean> connections, final int index, final boolean isExisting) {
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
