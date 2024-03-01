package ladderGame.model;

public class Player {
    private final Name name;
    private int position;

    public Player(String name, int position) {
        this.name = new Name(name);
        this.position = position;
    }

    public String getName() {
        return name.getName();
    }

    public void move(Line line) {
        this.position = line.descend(position);
    }

    public int getPosition() {
        return position;
    }

    public boolean equalsName(Name name) {
        return this.name.equals(name);
    }
}
