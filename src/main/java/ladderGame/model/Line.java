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
            throw new IllegalArgumentException(EXCEPTION_MESSAGE_CONTINUOUS_LINE);
        }
    }

    public int checkConnectionAndFindNextPosition(int position) {
        if (checkLeftConnection(position)) {
            return position - 1;
        }
        if (checkRightConnection(position)) {
            return position + 1;
        }
        return position;
    }

    private boolean checkLeftConnection(int position) {
        if (position == 0) {
            return false;
        }
        return connectionStatuses.get(position - 1).equals(ConnectionStatus.CONNECTION);
    }

    private boolean checkRightConnection(int position) {
        if (position >= connectionStatuses.size()) {
            return false;
        }
        return connectionStatuses.get(position).equals(ConnectionStatus.CONNECTION);
    }

    public List<ConnectionStatus> getConnectionStatuses() {
        return new ArrayList<>(connectionStatuses);
    }
}
