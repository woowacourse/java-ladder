package ladder.domain;

import ladder.utils.InputValidator;

import java.util.Objects;

public class Player {
    private String name;

    public Player(String name) {
        try {
            InputValidator.checkValidComponent(name);
            this.name = name;
        }catch (IllegalArgumentException e){
            e.getMessage();
        }
    }

    public String getName() {
        return this.name;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Player player = (Player) o;
        return Objects.equals(name, player.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name);
    }
}
