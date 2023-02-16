package utils;

public enum LadderStatus {

    INPUT_PARTICIPANT_NAMES,
    INPUT_LADDER_HEIGHT,
    APPLICATION_EXIT;

    public boolean canPlay() {
        return this != APPLICATION_EXIT;
    }
}
