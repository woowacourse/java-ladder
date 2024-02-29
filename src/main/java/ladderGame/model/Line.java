package ladderGame.model;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.IntStream;

public class Line {
    private static final String EXCEPTION_MESSAGE_UNAVAILABLE_BRIDGE = "유효하지 않은 다리가 생성되었습니다.";

    private final List<ConnectionStatus> connectionStatuses;

    Line(ConnectionStatus... connectionStatuses) {
        this(List.of(connectionStatuses));
    }

    public Line(List<ConnectionStatus> connectionStatuses) {
        validate(connectionStatuses);
        this.connectionStatuses = connectionStatuses;
    }

    private void validate(List<ConnectionStatus> connectionStatuses) {
        boolean isContinuous = IntStream.range(0, connectionStatuses.size() - 1)
                .anyMatch(i -> {
                    return isConnectedTwice(connectionStatuses.get(i), connectionStatuses.get(i + 1));
                });

        if(isContinuous) {
            throw new IllegalStateException(EXCEPTION_MESSAGE_UNAVAILABLE_BRIDGE);
        }
    }

    private boolean isConnectedTwice(ConnectionStatus left, ConnectionStatus right) {
        return (left == ConnectionStatus.CONNECTION) && (left == right);
    }

    public int descend(int index) {
        ConnectionStatus connectionLeft = decideConnectionLeft(index);
        ConnectionStatus connectionRight = decideConnectionRight(index);

        if(connectionLeft == ConnectionStatus.CONNECTION) {
            return index - 1;
        }
        if(connectionRight == ConnectionStatus.CONNECTION) {
            return index + 1;
        }
        return index;
    }

    private ConnectionStatus decideConnectionLeft(int index) {
        ConnectionStatus connectionLeft = ConnectionStatus.DISCONNECTION;
        if(index != 0) {
            connectionLeft = connectionStatuses.get(index - 1);
        }

        return connectionLeft;
    }

    private ConnectionStatus decideConnectionRight(int index) {
        ConnectionStatus connectionRight = ConnectionStatus.DISCONNECTION;
        if(index < connectionStatuses.size()) {
            connectionRight = connectionStatuses.get(index);
        }

        return connectionRight;
    }

    public List<ConnectionStatus> getConnectionStatuses() {
        return new ArrayList<>(connectionStatuses);
    }
}
