package domain;

public class Player {

    private final Name name;
    private final int position;

    public Player(String name, int position){
        this.name = new Name(name);
        this.position = position;
    }

    public String getName() {
        return name.getName();
    }
}
