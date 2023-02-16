package utils;

public enum LadderStatus {

    INPUT_PARTICIPANT_NAMES,
    GENERATE_LADDER,
    PRINT_LADDER,
    APPLICATION_EXIT;

    public boolean canPlay() {
        return this != APPLICATION_EXIT;
    }
}
