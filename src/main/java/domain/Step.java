package domain;

public enum Step {
    LEFT {
        public int move(int index) {
            return index - 1;
        }
    },
    RIGHT {
        public int move(int index) {
            return index + 1;
        }
    },
    EMPTY {
        public int move(int index) {
            return index;
        }
    };

    public static Step from(boolean hasStep) {
        if (hasStep) {
            return LEFT;
        }
        return EMPTY;
    }

    public boolean isLeft() {
        return this.equals(LEFT);
    }

    public abstract int move(int index);
}
