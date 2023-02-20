package domain;

public class Player {

    private final Name name;
    private final Position position;

    public Player(String name, int position){
        this.name = new Name(name);
        this.position = new Position(position);
    }

    public String getName() {
        return name.getName();
    }
}
