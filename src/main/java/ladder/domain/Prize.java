package ladder.domain;

import java.util.Objects;

public class Prize {
    private final String result;

    public Prize(String result) {
        this.result = result;
    }

    public String getPrize() {
        return result;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (!(o instanceof Prize)) {
            return false;
        }
        Prize prize1 = (Prize) o;
        return Objects.equals(result, prize1.result);
    }

    @Override
    public int hashCode() {
        return Objects.hash(result);
    }
}
