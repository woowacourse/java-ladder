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

    public int move(final int presentPosition) {
        if (isLeftConnectionExist(presentPosition)) {
            return presentPosition - 1;
        }
        if (isRightConnectionExist(presentPosition)) {
            return presentPosition + 1;
        }
        return presentPosition;
    }

    private boolean isLeftConnectionExist(final int presentPosition) {
        return (presentPosition != 0) && connections.get(presentPosition - 1);
    }

    private boolean isRightConnectionExist(final int presentPosition) {
        return (presentPosition != connections.size()) && connections.get(presentPosition);
    }

    public List<Boolean> getConnections() {
        return Collections.unmodifiableList(this.connections);
    }
}
