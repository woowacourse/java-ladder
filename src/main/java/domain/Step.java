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
            return RIGHT;
        }
        return EMPTY;
    }

    public boolean isRight() {
        return this.equals(RIGHT);
    }

    public abstract int move(int index);
}
