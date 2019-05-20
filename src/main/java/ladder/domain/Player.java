package ladder.domain;

import ladder.view.ConsoleMessages;

public class Player {
    public static final String FINISH_COMMAND = "all";
    private static final int MAX_NAME_LENGTH = 5;
    private final String name;
    private final int position;

    Player(final String name, final int position) {
        valid(name);
        this.name = name;
        this.position = position;
    }

    private void valid(String name) {
        if (name.equals("")) {
            throw new IllegalArgumentException(ConsoleMessages.ERR_BLANK.message());
        }
        if (name.equals(FINISH_COMMAND)) {
            throw new IllegalArgumentException(ConsoleMessages.ERR_ILLEGAL_NAME.message());
        }
        if (name.length() > MAX_NAME_LENGTH) {
            throw new IllegalArgumentException(ConsoleMessages.ERR_NAME_LENGTH.message());
        }
    }


    @Override
    public boolean equals(Object obj) {

        if (obj == null) {
            return false;
        }
        if (obj.getClass() != this.getClass()) {
            return false;
        }
        Player another = (Player) obj;
        return this.name.equals(another.name) && this.position == another.position;
    }

    public String name() {
        return this.name;
    }

    int position() {
        return this.position;
    }
}
