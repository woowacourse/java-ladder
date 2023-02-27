package domain;

public enum SearchCommand {

    SEARCH_ALL,
    SEARCH_ONE,
    BLANK;

    public static SearchCommand from(String command) {
        if (command.isBlank()) {
            return BLANK;
        }
        if (command.equals("all")) {
            return SEARCH_ALL;
        }
        return SEARCH_ONE;
    }

    public boolean isDone() {
        return this == SEARCH_ALL || this == BLANK;
    }
}
