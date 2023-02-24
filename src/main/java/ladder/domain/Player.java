package ladder.domain;

public class Player {
    private final Name name;
    private Prize prize;

    public Player(Name name) {
        this.name = name;
    }

    public boolean isSameName(String name) {
        return this.name.equals(new Name(name));
    }

    public void setPrize(Prize prize) {
        this.prize = prize;
    }

    public String getName() {
        return name.getName();
    }

    public String getPrizeName() {
        return prize.getName();
    }
}
