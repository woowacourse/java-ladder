package ladder.domain;

import ladder.domain.linegenerator.LineGenerator;

import java.util.Collections;
import java.util.List;

public class RowLine {
    private static final int MIN_PEOPLE_NUMBER = 1;
    private static final int MAX_PEOPLE_NUMBER = 100;
    private final List<Boolean> connection;

    public RowLine(int peopleNumber, LineGenerator generator) {
        validatePeopleNumber(peopleNumber);
        List<Boolean> generatedConnection = generator.getLine(peopleNumber);
        validateSuccessiveLine(generatedConnection);
        this.connection = Collections.unmodifiableList(generatedConnection);
    }

    public List<Boolean> getConnection() {
        return connection;
    }

    public PositionRow nextPositionOf(PositionRow positionRow) {
        if (isConnectedOnLeftFrom(positionRow)) {
            return positionRow.left();
        }
        if (isConnectedOnRightFrom(positionRow)) {
            return positionRow.right();
        }
        return positionRow;
    }

    private void validatePeopleNumber(int peopleNumber) {
        if (peopleNumber < MIN_PEOPLE_NUMBER || peopleNumber > MAX_PEOPLE_NUMBER) {
            throw new IllegalArgumentException("참여자 수는 1이상 100이하의 사람 수 입니다.");
        }
    }

    private void validateSuccessiveLine(List<Boolean> booleans) {
        Boolean before = Boolean.FALSE;
        for (Boolean after : booleans) {
            validateSuccessiveLineBetween(before, after);
            before = after;
        }
    }

    private void validateSuccessiveLineBetween(Boolean before, Boolean after) {
        if (before && after) {
            throw new IllegalArgumentException("사다리 가로선이 연속되었습니다.");
        }
    }

    private boolean isConnectedOnLeftFrom(PositionRow positionRow) {
        if (positionRow.getPosition() == 0) {
            return false;
        }
        return connection.get(positionRow.getPosition() - 1);
    }

    private boolean isConnectedOnRightFrom(PositionRow positionRow) {
        if (positionRow.getPosition() == connection.size()) {
            return false;
        }
        return connection.get(positionRow.getPosition());
    }
}
