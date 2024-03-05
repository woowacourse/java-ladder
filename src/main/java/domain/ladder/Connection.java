package domain.ladder;

import java.util.function.IntUnaryOperator;

public enum Connection {
    LEFT(index -> index - 1) {
        @Override
        public Connection next(boolean isConnected) {
            if (isConnected) {
                return RIGHT;
            }
            return DISCONNECTED;
        }
    },
    RIGHT(index -> index + 1) {
        @Override
        public Connection next(boolean isConnected) {
            return LEFT;
        }
    },
    DISCONNECTED(index -> index) {
        @Override
        public Connection next(boolean isConnected) {
            if (isConnected) {
                return RIGHT;
            }
            return DISCONNECTED;
        }
    };

    private final IntUnaryOperator moveFunction;

    Connection(IntUnaryOperator moveFunction) {
        this.moveFunction = moveFunction;
    }

    public static Connection first(boolean isConnected) {
        if (isConnected) {
            return RIGHT;
        }
        return DISCONNECTED;
    }

    public Connection makeLastConnection() {
        if (this == RIGHT) {
            return DISCONNECTED;
        }
        return this;
    }

    public int moveToNextIndex(int currentIndex) {
        return moveFunction.applyAsInt(currentIndex);
    }

    public boolean isLeft() {
        return this == LEFT;
    }

    public abstract Connection next(boolean isConnected);
}
