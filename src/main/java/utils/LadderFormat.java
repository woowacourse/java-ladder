package utils;

public enum LadderFormat {
    LADDER_COLUMN {
        @Override
        public String toString() {
            return "|";
        }
    },

    CONNECTION {
        @Override
        public String toString() {
            return "-----";
        }
    },

    NON_CONNECTION {
        @Override
        public String toString() {
            return "     ";
        }
    }
}
