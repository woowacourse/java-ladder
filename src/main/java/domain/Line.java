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

    private void makeOtherConnections(final ConnectionGenerator connectionGenerator, final List<Boolean> connection,
                                      final int numberOfPoint) {
        for (int i = 1; i < numberOfPoint; i++) {
            boolean isExisting = connectionGenerator.generate();
            makeConnectionExceptFirst(connection, i, isExisting);
        }
    }

    private void makeConnectionExceptFirst(final List<Boolean> connection, final int index, final boolean isExisting) {
        if (connection.get(index-1) && isExisting) {
            connection.add(false);
            return;
        }
        connection.add(isExisting);
    }

    public List<Boolean> getConnections() {
        return Collections.unmodifiableList(this.connections);
    }
}
