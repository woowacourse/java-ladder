package domain;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import domain.generator.ConnectionGenerator;

public class Line {

    private final List<Boolean> connections;

    public Line(final int numberOfPlayer, final ConnectionGenerator connectionGenerator) {
        connections = makeConnections(numberOfPlayer, connectionGenerator);
    }

    private List<Boolean> makeConnections(final int numberOfPlayer, final ConnectionGenerator connectionGenerator) {
        List<Boolean> connections = new ArrayList<>();
        int numberOfConnection = numberOfPlayer - 1;

        connections.add(connectionGenerator.generate());
        makeOtherConnections(connectionGenerator, connections, numberOfConnection);

        return connections;
    }

    private void makeOtherConnections(final ConnectionGenerator connectionGenerator, final List<Boolean> footholds,
                                      final int numberOfPoint) {
        for (int i = 1; i < numberOfPoint; i++) {
            boolean random = connectionGenerator.generate();
            makeConnectionWithoutFirst(footholds, i, random);
        }
    }

    private void makeConnectionWithoutFirst(final List<Boolean> footholds, final int index, final boolean isExisting) {
        if (isContinuousConnection(footholds, index, isExisting)) {
            footholds.add(false);
            return;
        }
        footholds.add(isExisting);
    }

    private boolean isContinuousConnection(final List<Boolean> footholds, final int index, final boolean random) {
        return footholds.get(index-1) && random;
    }

    public List<Boolean> getConnections() {
        return Collections.unmodifiableList(this.connections);
    }
}
