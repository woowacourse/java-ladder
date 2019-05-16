package laddergame.domain;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Objects;

public class Prize {
   List<String> prizes = new ArrayList();

    Prize(String input) {
        List<String> prizes = Arrays.asList(input.split(","));
        this.prizes = prizes;

    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Prize prizes1 = (Prize) o;
        return Objects.equals(prizes, prizes1.prizes);
    }

    @Override
    public int hashCode() {
        return Objects.hash(prizes);
    }
}
