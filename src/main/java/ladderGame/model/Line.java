package ladderGame.model;

import java.util.ArrayList;
import java.util.List;

public class Line {
    private static final String EXCEPTION_MESSAGE_CONTINUOUS_LINE = "사다리에 연속된 줄이 생길 수 없습니다.";

    private final List<ConnectionStatus> connectionStatuses;

    public Line(List<ConnectionStatus> connectionStatuses) {
        for (int i = 1; i < connectionStatuses.size(); i++) {
            validateContinuousLine(connectionStatuses.get(i - 1), connectionStatuses.get(i));
        }
        this.connectionStatuses = connectionStatuses;
    }

    private void validateContinuousLine(ConnectionStatus preStatus, ConnectionStatus currentStatus) {
        if (preStatus.equals(ConnectionStatus.CONNECTION) && currentStatus.equals(ConnectionStatus.CONNECTION)) {
            throw new IllegalStateException(EXCEPTION_MESSAGE_CONTINUOUS_LINE);
        }
    }

    public int checkConnectionAndFindNextIndex(int index) {
        if (checkLeftConnection(index)) {
            return index - 1;
        }
        if (checkRightConnection(index)) {
            return index + 1;
        }
        return index;
    }

    private boolean checkLeftConnection(int index) {
        if (index == 0)
            return false;
        return connectionStatuses.get(index - 1).equals(ConnectionStatus.CONNECTION);
    }

    private boolean checkRightConnection(int index) {
        if (index >= connectionStatuses.size())
            return false;
        return connectionStatuses.get(index).equals(ConnectionStatus.CONNECTION);
    }

    public List<ConnectionStatus> getConnectionStatuses() {
        return new ArrayList<>(connectionStatuses);
    }
}
