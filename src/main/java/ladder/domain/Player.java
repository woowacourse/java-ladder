package ladder.domain;

public class Player {
    private final String name;
    private final int position;

    Player(final String name, final int position) {
        this.name = name;
        this.position = position;
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
