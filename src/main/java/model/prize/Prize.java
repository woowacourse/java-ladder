package model.prize;

import java.util.Objects;

public class Prize {
    private final String name;

    public Prize(final String name) {
        this.name = name;
    }

    @Override
    public boolean equals(final Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        final Prize prize = (Prize) o;
        return Objects.equals(name, prize.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name);
    }

    public String getName() {
        return name;
    }
}
