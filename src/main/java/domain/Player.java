package domain;

public class Player {

    private final Name name;

    public Player(String name){
        this.name = new Name(name);
    }

    public boolean isTargetPlayer(String name) {
        return this.name.isSame(name);
    }

    public String getName() {
        return name.getName();
    }

}
