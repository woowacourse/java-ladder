package domain;

import exception.InvalidLadderHeightException;
import java.util.List;
import util.BooleanGenerator;

public class Ladder {

    private final boolean[] status;

    public Ladder(int height) {
        validateHeight(height);
        status = new boolean[height];
    }

    private void validateHeight(int height) {
        if (isValidHeight(height)) {
            throw new InvalidLadderHeightException();
        }
    }

    private boolean isValidHeight(int height) {
        final int maxHeight = 10;
        final int minHeight = 1;
        return height < minHeight || height > maxHeight;
    }

    public int getHeight() {
        return status.length;
    }

    public void generateStatus(List avoid, BooleanGenerator booleanGenerator) {
        for (int i = 0; i < status.length; i++) {
            if (avoid.contains(i)) {
                status[i] = false;
            } else {
                boolean isConnect = booleanGenerator.generate();
                if (isConnect) {
                    status[i] = true;
                } else {
                    status[i] = false;
                }
            }
        }
    }

    public boolean[] getStatus() {
        return status;
    }
}
