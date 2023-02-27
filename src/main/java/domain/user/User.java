package domain.user;

import domain.ladder.Line;
import java.util.List;

public class User {
    private final Name name;
    private int position;

    public User(String name, int position) {
        this.name = new Name(name);
        this.position = position;
    }

    public String getName() {
        return name.getName();
    }

    public void movePosition(Line nextLine) {
        List<Boolean> nextLineValues = nextLine.getLine();
        if (nextLineValues.get(position)) {
            this.position--;
        }
        else if (position + 1 < nextLineValues.size() && nextLineValues.get(position + 1)) {
            this.position++;
        }
    }

    public int getPosition() {
        return position;
    }
}
